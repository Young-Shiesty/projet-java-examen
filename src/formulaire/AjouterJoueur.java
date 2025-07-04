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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DashBoardOrganisateur;
import models.Tournois;
import models.Utilisateur;

/**
 *
 * @author user
 */
public class AjouterJoueur extends javax.swing.JFrame {

    Boolean ajout = false;
    Boolean mt = false;
    /**
     * Creates new form AjouterJoueur
     */
    public AjouterJoueur() {
        
        initComponents();
    }
    Utilisateur u1;
    public AjouterJoueur(Utilisateur u) throws SQLException, ClassNotFoundException {

        initComponents();
        u1=u;
        con = getConnection();
        Fetch();
        LoadGameNo();
        if(ajout ==false){
            addplayer.setVisible(false);
        }if (mt==false){
            matchmaking.setVisible(false);
        }
        
        
    }
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    Tournois t;
    Tournois t1=t;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojeru_san.complementos.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Gid = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        addplayer = new javax.swing.JButton();
        matchmaking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 0));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Game", "DateDebut", "DateFin", "Players", "Frais", "Price"
            }
        ));
        jTable1.setColorBackgoundHead(new java.awt.Color(153, 153, 153));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("GAME_ID");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Gid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(Gid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Snap ITC", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK TO MENU");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addplayer.setText("ADD PLAYER");
        addplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addplayerActionPerformed(evt);
            }
        });

        matchmaking.setText("MATCH MAKING");
        matchmaking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchmakingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(58, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(addplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(matchmaking, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchmaking, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Fetch(){
    try {
        int q;  
        long id = u1.getId();
        pst = con.prepareStatement("SELECT * FROM tournois WHERE id_organisateur = ?");
        pst.setLong(1, id); 
        rs = pst.executeQuery();

        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("nom"));
            v2.add(rs.getString("type_jeux"));
            v2.add(rs.getString("datedebut"));
            v2.add(rs.getString("datefin"));
            v2.add(rs.getString("nombrejoueur"));
            v2.add(rs.getString("fraisinscription"));
            v2.add(rs.getString("recompense"));
            df.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(DashBoardOrganisateur.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void LoadGameNo(){
        try {
            long id = u1.getId();
            pst = con.prepareStatement("SELECT id FROM tournois where id_organisateur = ?");
            pst.setLong(1,id);
            rs = pst.executeQuery();
            Gid.removeAllItems();
            while (rs.next()){
                Gid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try 
        {
            String Game_Id=Gid.getSelectedItem().toString();
            pst=con.prepareStatement("SELECT * FROM tournois WHERE id=?");
            pst.setString(1,Game_Id);
            rs=pst.executeQuery();
           ResultSetMetaData rss = rs.getMetaData();
            int q = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("nom"));
            v2.add(rs.getString("type_jeux"));
            v2.add(rs.getString("datedebut"));
            v2.add(rs.getString("datefin"));
            v2.add(rs.getString("nombrejoueur"));
            v2.add(rs.getString("fraisinscription"));
            v2.add(rs.getString("recompense"));
            df.addRow(v2);
        }

            ajout =true;
            addplayer.setVisible(true);
            long id_tournois = Long.parseLong(Game_Id);
            int nb = CompterPlayer(con,id_tournois);
            System.out.println("le gid"+Game_Id);
        if(nb >=8){
             addplayer.setVisible(false);
             matchmaking.setVisible(true);
        }else{
            matchmaking.setVisible(false);
        }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //            long id_organisateur = u1.getId();
            this.setVisible(false);
            new DashBoardOrganisateur(u1).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CreerTournois.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreerTournois.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

           public static int CompterPlayer(Connection con, long idTournoi) throws SQLException {
               PreparedStatement pst;
               ResultSet rs;
    int total = 0;
    pst = con.prepareStatement("SELECT COUNT(*) AS total_joueurs FROM joueurs WHERE id_tournois = ?");
    pst.setLong(1, idTournoi); 
    rs = pst.executeQuery();
    
    
    if (rs.next()) {
        total = rs.getInt("total_joueurs");
    }
    return total;
}
 

    private void addplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addplayerActionPerformed
        try {
            // TODO add your handling code here:
            String Game_Id=Gid.getSelectedItem().toString();
            this.setVisible(false);
            new AjouterJoueurDansTournois(u1,Game_Id).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addplayerActionPerformed

    private void matchmakingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchmakingActionPerformed
        try {
            // TODO add your handling code here:
            String Game_Id=Gid.getSelectedItem().toString();
            
            long t = Long.parseLong(Game_Id);
            this.setVisible(false);
            new Gerermatch(u1,t).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AjouterJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_matchmakingActionPerformed

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
            java.util.logging.Logger.getLogger(AjouterJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterJoueur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterJoueur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Gid;
    private javax.swing.JButton addplayer;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro jTable1;
    private javax.swing.JButton matchmaking;
    // End of variables declaration//GEN-END:variables
}
