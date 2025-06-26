/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulaire;

import static dao.DatabaseService.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Utilisateur;

/**
 *
 * @author user
 */
public class DemieFinal extends javax.swing.JFrame {

    /**
     * Creates new form DemieFinal
     */
    public DemieFinal() {
        initComponents();
    }
    public DemieFinal(Utilisateur u,long t) throws SQLException, ClassNotFoundException {
        initComponents();
         this.u1=u;
         this.t1=t;
        con = getConnection();
        if(CompterMatchDemie(con,t1)==0){
                TirageDemie(con, t1);    
                 fetch();
        }else{
             fetch();
        }
        if(VerifScore(con, t1, 1)>0){
            apply_match2.setVisible(false);
        }
        if(VerifScore(con, t1, 2)>0){
            apply_match3.setVisible(false);
        }
        if(VerifScore(con, t1, 1)==0 || VerifScore(con, t1, 2)==0){
            Finalbtn.setVisible(false);
        }else{
            Finalbtn.setVisible(true);
        }
//        fetch();
        
        }
 Utilisateur u1;
    long t1;
     ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    public static int CompterMatchDemie(Connection con, long t1) throws SQLException {
               PreparedStatement pst;
               ResultSet rs;           
    int total = 0;
    long id_tournois=t1; 
    pst = con.prepareStatement("SELECT COUNT(*) AS total_demiefinal FROM demiefinal WHERE  id_tournois = ?");
//    pst.setLong(1, id); 
    pst.setLong(1, id_tournois); 
    rs = pst.executeQuery();
    if (rs.next()) {
        total = rs.getInt("total_demiefinal");
    }
    return total;
}
    public static int VerifScore(Connection con,long t1, long id_match) throws SQLException {
               PreparedStatement pst;
               ResultSet rs;           
    int total = 0;
    long id_tournois=t1; 
    
    pst = con.prepareStatement("SELECT COUNT(*) AS total_scoredemiefinal FROM scoredemiefinal WHERE  id_tournois = ? and id_match=?");
//    pst.setLong(1, id); 
    pst.setLong(1, id_tournois); 
    pst.setLong(2, id_match);
    rs = pst.executeQuery();
    if (rs.next()) {
        total = rs.getInt("total_scoredemiefinal");
    }
    return total;
}
     private void fetch (){
         try {
            int q;
            long id=t1;
            pst = con.prepareStatement("SELECT * FROM demiefinal WHERE id_tournois = ?");
            pst.setLong(1,id);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q=rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)tableaumatchmaking.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int a=1 ; a<=q ;a++) {
                   v2.add(rs.getString("id_joueur1"));
                   v2.add(rs.getString("id_joueur2"));
                   v2.add(rs.getString("numero_match"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListeJoueurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void TirageDemie(Connection con, long idTournois) throws SQLException {
       
//        String sqlSelect = "SELECT id_gagnant FROM scores WHERE id_tournois = ?";
//        PreparedStatement pstSelect = con.prepareStatement(sqlSelect);

        PreparedStatement pst = con.prepareStatement("SELECT id_gagnant FROM scores WHERE id_tournois = ?");
        pst.setLong(1, idTournois);
        ResultSet rs = pst.executeQuery();
        

        List<Long> joueurs = new ArrayList<>();
        while (rs.next()) {
            joueurs.add(rs.getLong("id_gagnant"));
        }
        rs.close();
        pst.close();
        if (joueurs.size() < 2) {
            JOptionPane.showMessageDialog(null, "Pas assez de joueurs pour générer des matchs.");
            return;
        }
       
        Collections.shuffle(joueurs);

        pst = con.prepareStatement("INSERT INTO demiefinal (id_joueur1, id_joueur2, id_tournois, numero_match) VALUES (?, ?, ?, ?)");
        
       for (int i = 0; i + 1 < joueurs.size(); i += 2) {
    int matchNum = (i / 2) + 1;
        pst.setLong(1, joueurs.get(i));
        pst.setLong(2, joueurs.get(i + 1));
        pst.setLong(3, idTournois);
        pst.setInt(4, matchNum);
        pst.executeUpdate();
        
}
        pst.close();
        JOptionPane.showMessageDialog(null, "Matchmaking crees avec succeess.");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableaumatchmaking = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        score_p3 = new javax.swing.JTextField();
        apply_match2 = new javax.swing.JButton();
        score_p4 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        score_p5 = new javax.swing.JTextField();
        apply_match3 = new javax.swing.JButton();
        score_p6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Finalbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableaumatchmaking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Player1       vs", "Player2", "Match"
            }
        ));
        tableaumatchmaking.setFocusable(false);
        tableaumatchmaking.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tableaumatchmaking.setShowHorizontalLines(true);
        tableaumatchmaking.setShowVerticalLines(true);
        tableaumatchmaking.getTableHeader().setResizingAllowed(false);
        jScrollPane2.setViewportView(tableaumatchmaking);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DEMI-FINALE");

        jLabel4.setText("Match 1 selectionner gagnant:");

        jLabel5.setText("SCORE:");

        score_p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                score_p3ActionPerformed(evt);
            }
        });

        apply_match2.setText("Apply");
        apply_match2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apply_match2ActionPerformed(evt);
            }
        });

        score_p4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                score_p4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(score_p4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(apply_match2)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(score_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apply_match2)
                    .addComponent(score_p4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel10.setText("Match 2 selectionner gagnant:");

        jLabel11.setText("SCORE:");

        score_p5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                score_p5ActionPerformed(evt);
            }
        });

        apply_match3.setText("Apply");
        apply_match3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apply_match3ActionPerformed(evt);
            }
        });

        score_p6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                score_p6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score_p5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(score_p6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(apply_match3)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(score_p5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apply_match3)
                    .addComponent(score_p6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel9.setText("P1           P2");

        Finalbtn.setText("FINAL");
        Finalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Finalbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Finalbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void score_p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_score_p3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_score_p3ActionPerformed

    private void apply_match2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apply_match2ActionPerformed
        try {
            long gagnant;
            long place3eme;
            String score_3 = score_p3.getText().trim();
            String score_4 = score_p4.getText().trim();
            if (!score_3.matches("\\d+") || !score_4.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir uniquement des chiffres pour les scores.");
                return;
            }

            long score_33 = Long.parseLong(score_3);
            long score_44 = Long.parseLong(score_4);

            if (score_33 < 0 || score_44<0) {
                JOptionPane.showMessageDialog(this, "Pas de negatif.");
                return;
            }

            if (score_33 == score_44) {
                JOptionPane.showMessageDialog(this, "Pas de match nul.");
                return;
            }

            long id_match = 1;
            long id_tournois=t1;

            pst = con.prepareStatement("SELECT id_joueur1, id_joueur2 FROM demiefinal WHERE numero_match = 1 AND id_tournois = ?");
            pst.setLong(1, id_tournois);
            rs = pst.executeQuery();

            if (rs.next()) {
                long id_j3 = rs.getLong("id_joueur1");
                long id_j4 = rs.getLong("id_joueur2");
 
                if (score_33 > score_44){
                    gagnant = id_j3;
                    place3eme =id_j4 ;
                } else {
                    gagnant = id_j4;
                    place3eme = id_j3;
                }

                JOptionPane.showMessageDialog(this, "Le gagnant est le joueur avec l'ID : " + gagnant);
                PreparedStatement pstInsert = con.prepareStatement(
                    "INSERT INTO scoredemiefinal (id_gagnant,id_match,id_tournois,score_joueur1, score_joueur2,place3eme) VALUES (?, ?, ?, ?, ?,?)"
                );
                pstInsert.setLong(1,gagnant);
                pstInsert.setLong(2, id_match);
                pstInsert.setLong(3, id_tournois);
                pstInsert.setLong(4, score_33);
                pstInsert.setLong(5, score_44);
                pstInsert.setLong(6,place3eme);
                
                
                pstInsert.executeUpdate();
                pstInsert.close();
                
//                JOptionPane.showMessageDialog(this, "Score enregistré avec succès.");
                apply_match2.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Aucun match trouvé.");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_apply_match2ActionPerformed

    private void score_p4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_score_p4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_score_p4ActionPerformed

    private void score_p5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_score_p5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_score_p5ActionPerformed

    private void apply_match3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apply_match3ActionPerformed
        // TODO add your handling code here:
        try {
            long gagnant;
            long place3eme;
            String score_5 = score_p5.getText().trim();
            String score_6 = score_p6.getText().trim();
            if (!score_5.matches("\\d+") || !score_6.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir uniquement des chiffres pour les scores.");
                return;
            }

            long score_55 = Long.parseLong(score_5);
            long score_66 = Long.parseLong(score_6);

            if (score_55 < 0 || score_66<0) {
                JOptionPane.showMessageDialog(this, "Pas de negatif.");
                return;
            }

            if (score_55 == score_66) {
                JOptionPane.showMessageDialog(this, "Pas de match nul.");
                return;
            }

            long id_match = 2;
            long id_tournois=t1;

                pst = con.prepareStatement("SELECT id_joueur1, id_joueur2 FROM demiefinal WHERE numero_match = 2 AND id_tournois = ?");
            pst.setLong(1, id_tournois);
            rs = pst.executeQuery();

            if (rs.next()) {
                long id_j5 = rs.getLong("id_joueur1");
                long id_j6 = rs.getLong("id_joueur2");
 
                if (score_55 > score_66){
                    gagnant = id_j5;
                    place3eme =id_j6;
                } else {
                    gagnant =id_j6;
                    place3eme =id_j5 ;
                }

                JOptionPane.showMessageDialog(this, "Le gagnant est le joueur avec l'ID : " + gagnant);
                PreparedStatement pstInsert = con.prepareStatement(
                    "INSERT INTO scoredemiefinal (id_gagnant,id_match,id_tournois,score_joueur1, score_joueur2,place3eme) VALUES (?, ?, ?, ?, ?,?)"
                );
                pstInsert.setLong(1,gagnant);
                pstInsert.setLong(2, id_match);
                pstInsert.setLong(3, id_tournois);
                pstInsert.setLong(4, score_55);
                pstInsert.setLong(5, score_66);
                pstInsert.setLong(6,place3eme);
                
                
                pstInsert.executeUpdate();
                pstInsert.close();
                
//                JOptionPane.showMessageDialog(this, "Score enregistré avec succès.");
                apply_match3.setVisible(false);
                Finalbtn.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Aucun match trouvé.");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ResultatMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_apply_match3ActionPerformed

    private void score_p6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_score_p6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_score_p6ActionPerformed

    private void FinalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalbtnActionPerformed
        
        try {
            if(Final.CompterMatchFinal(con, t1)==0){
                try {
                    long id_tournois = t1;
                    
                    pst = con.prepareStatement("SELECT id_gagnant, place3eme FROM scoredemiefinal WHERE id_tournois = ?");
                    pst.setLong(1, id_tournois);
                    rs = pst.executeQuery();
                    
                    ArrayList<Long> gagnants = new ArrayList<>();
                    ArrayList<Long> troisiemes = new ArrayList<>();
                    
                    while (rs.next()) {
                        gagnants.add(rs.getLong("id_gagnant"));
                        troisiemes.add(rs.getLong("place3eme"));
                    }
                    if (gagnants.size() == 2 && troisiemes.size() == 2) {
                        
                        PreparedStatement pstFinal = con.prepareStatement(
                                "INSERT INTO final (id_joueur1, id_joueur2, id_tournois, lastmatch) VALUES (?, ?, ?, ?)"
                        );
                        pstFinal.setLong(1, gagnants.get(0));
                        pstFinal.setLong(2, gagnants.get(1));
                        pstFinal.setLong(3, id_tournois);
                        pstFinal.setString(4, "final");
                        pstFinal.executeUpdate();
                        
                        
                        PreparedStatement pst3rd = con.prepareStatement(
                                "INSERT INTO final (id_joueur1, id_joueur2, id_tournois, lastmatch) VALUES (?, ?, ?, ?)"
                        );
                        pst3rd.setLong(1, troisiemes.get(0));
                        pst3rd.setLong(2, troisiemes.get(1));
                        pst3rd.setLong(3, id_tournois);
                        pst3rd.setString(4, "3rdplace");
                        pst3rd.executeUpdate();
                        
                        
                        this.setVisible(false);
                        new Final(u1, t1).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, " il faut deux gagnants et deux perdants  pour les lestmatchs.");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DemieFinal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DemieFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                 this.setVisible(false);
                try {
                    new Final(u1, t1).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DemieFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DemieFinal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       


    }//GEN-LAST:event_FinalbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DemieFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemieFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemieFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemieFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemieFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finalbtn;
    private javax.swing.JButton apply_match1;
    private javax.swing.JButton apply_match2;
    private javax.swing.JButton apply_match3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField score_p1;
    private javax.swing.JTextField score_p2;
    private javax.swing.JTextField score_p3;
    private javax.swing.JTextField score_p4;
    private javax.swing.JTextField score_p5;
    private javax.swing.JTextField score_p6;
    private javax.swing.JTable tableaumatchmaking;
    // End of variables declaration//GEN-END:variables
}
