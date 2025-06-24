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
        // 1. Récupérer tous les joueurs du tournoi
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

        // Si moins de 2 joueurs, on ne peut pas faire de match
        if (joueurs.size() < 2) {
            JOptionPane.showMessageDialog(null, "Pas assez de joueurs pour générer des matchs.");
            return;
        }

        // 2. Mélanger la liste aléatoirement
        Collections.shuffle(joueurs);

        // 3. Préparer la requête d'insertion pour les matchs
        String sqlInsert = "INSERT INTO matchs (id_joueur1, id_joueur2, id_tournois, numero_match) VALUES (?, ?, ?, ?)";
        PreparedStatement pstInsert = con.prepareStatement(sqlInsert);

        // 4. Boucler par paires et insérer
        int numeroMatch = 1;
        for (int i = 0; i + 1 < joueurs.size(); i += 2) {
            long j1 = joueurs.get(i);
            long j2 = joueurs.get(i+1);

            pstInsert.setLong(1, j1);
            pstInsert.setLong(2, j2);
            pstInsert.setLong(3, idTournois);
            pstInsert.setInt(4, numeroMatch);
            pstInsert.executeUpdate();

            numeroMatch++;
        }

        pstInsert.close();
        JOptionPane.showMessageDialog(null, "Matchs créés avec succès (" + (numeroMatch - 1) + " matchs).");
        
    }

    // Exemple d'appel :
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ta_base", "utilisateur", "motdepasse");

//            long idTournois = 5;  // ou récupéré dynamiquement
//            creerMatchs(con, idTournois);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la création des matchs.");
        }
    }
}
    

