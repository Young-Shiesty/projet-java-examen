/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MatchMaking {
    

   
    public static void creerMatchs(Connection con, long idTournois) throws SQLException {
       
        String sqlSelect = "SELECT id_joueur FROM joueurs WHERE id_tournois = ?";
        PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
        pstSelect.setLong(1, idTournois);
        ResultSet rs = pstSelect.executeQuery();

        List<Long> joueurs = new ArrayList<>();
        while (rs.next()) {
            joueurs.add(rs.getLong("id_joueur"));
        }
        rs.close();
        pstSelect.close();

       
        if (joueurs.size() < 2) {
            JOptionPane.showMessageDialog(null, "Pas assez de joueurs pour générer des matchs.");
            return;
        }

       
        Collections.shuffle(joueurs);

        PreparedStatement pst = con.prepareStatement("INSERT INTO matchs (id_joueur1, id_joueur2, id_tournois, numero_match) VALUES (?, ?, ?, ?)");
        
                
       for (int i = 0; i + 1 < joueurs.size(); i += 2) {
    int matchNum = (i / 2) + 1;
        pst.setLong(1, joueurs.get(i));
        pst.setLong(2, joueurs.get(i + 1));
        pst.setLong(3, idTournois);
        pst.setInt(4, matchNum);
        pst.executeUpdate();
        
}


        pst.close();
//        JOptionPane.showMessageDialog(null, "Matchs crees avec succeess.");
        
    }

    
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/examenjavafinal", "root", "");

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la création des matchs.");
        }
    }
}
    

