/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulaire;
import static dao.DatabaseService.getConnection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Utilisateur;
import dao.UtilisateurDao;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gaye_
 */
public class JoueurForm extends javax.swing.JFrame {

    /**
     * Creates new form JoueurForm
     */
    public JoueurForm() throws SQLException, ClassNotFoundException {
        initComponents();
        con = getConnection();
            
}
// Déclaration en haut de ta classe
Utilisateur u1;
PreparedStatement pst; 
Connection con;
ResultSet rs;

public JoueurForm(Utilisateur u) throws SQLException, ClassNotFoundException {
    initComponents();
    con = getConnection();
    this.u1 = u; 
    Loadusername();
    fetch(); 
}

private void displayMessageError(String message) {
    JOptionPane.showMessageDialog(this, message);
} 
    
public void Loadusername() {
    if (id_cbx == null) {
        System.err.println("Erreur : id_cbx n'est pas initialisée !");
        return;
    }

    try {
        pst = con.prepareStatement("SELECT id_joueur FROM joueurs");
        rs = pst.executeQuery();
        id_cbx.removeAllItems();

        while (rs.next()) {
            id_cbx.addItem(rs.getString("id_joueur"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void fetch() {
    try {
        long id_organisateur = u1.getId(); 
        pst = con.prepareStatement("SELECT * FROM joueurs WHERE id_organisateur =? and id_tournois is null");
        pst.setLong(1, id_organisateur); 
        rs = pst.executeQuery();

        ResultSetMetaData rss = rs.getMetaData();
        int q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            for (int a = 1; a <= q; a++) {
                v2.add(rs.getString(a)); 
            }
            df.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username_tf = new javax.swing.JTextField();
        modifier_btn = new javax.swing.JButton();
        supprimer_btn = new javax.swing.JButton();
        ajouter_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        id_cbx = new javax.swing.JComboBox<>();
        search_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("nom du joueur");

        username_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_tfActionPerformed(evt);
            }
        });

        modifier_btn.setText("Modifier");
        modifier_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifier_btnActionPerformed(evt);
            }
        });

        supprimer_btn.setText("Supprimer");
        supprimer_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_btnActionPerformed(evt);
            }
        });

        ajouter_btn.setText("Ajouter");
        ajouter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_btnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "joueurs"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("idUser");

        id_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_cbxActionPerformed(evt);
            }
        });

        search_btn.setText("Rechercher");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(username_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ajouter_btn)
                                .addGap(101, 101, 101)
                                .addComponent(modifier_btn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprimer_btn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(search_btn)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifier_btn)
                    .addComponent(supprimer_btn)
                    .addComponent(ajouter_btn))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_btnActionPerformed
        try {
            // TODO add your handling code here:
            String username = username_tf.getText().trim();
            
            if (username.isEmpty()) {
        displayMessageError("Le username est obligatoire.");
        return;
    } 
            
      try {
        if (UtilisateurDao.joueurExiste(username)) {
            displayMessageError("Ce username est deja utilise par un joueur.");
            return;
        }
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
        displayMessageError("Erreur lors de la vérification du username.");
        return;
    }
            long id_organisateur = u1.getId();
            pst=con.prepareStatement("INSERT INTO JOUEURS(username,id_organisateur) VALUES (?,?)");
            pst.setString(1,username);
            pst.setLong(2,id_organisateur);
            
            int k =pst.executeUpdate();
            
            if (k==1) {
                JOptionPane.showMessageDialog(this, "Insersion reuissie");
                username_tf.setText(""); 
                 fetch(); 
                Loadusername();
            }else {
                JOptionPane.showMessageDialog(this, "Insersion non reuissie");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ajouter_btnActionPerformed

    private void modifier_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifier_btnActionPerformed
        
        
        try {
            String username = username_tf.getText();
            String id=id_cbx.getSelectedItem().toString();
            
            pst=con.prepareStatement("UPDATE JOUEURS SET username=? where id_joueur=?");
            pst.setString(1,username);
            pst.setString(2,id);
            
            int k=pst.executeUpdate();
            if (k==1) {
                JOptionPane.showMessageDialog(this, "Mis a jour avec succes");
                username_tf.setText("");
                 fetch(); 
                Loadusername();
            } else { 
                JOptionPane.showMessageDialog(this, "Mis a jour fail");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modifier_btnActionPerformed

    private void supprimer_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_btnActionPerformed
        try {
            // TODO add your handling code here:
            
            String id = id_cbx.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM JOUEURS where id_joueur = ?");
            pst.setString(1, id);
            
            int k = pst.executeUpdate();
            if(k==1) {
                JOptionPane.showMessageDialog(this, "Suppression reuissie");
                username_tf.setText("");
                 fetch(); 
                Loadusername();
            } else {
                JOptionPane.showMessageDialog(this, "Suppression echoué");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_supprimer_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        try {
            // TODO add your handling code here:
            String id = id_cbx.getSelectedItem().toString();
            
            pst=con.prepareStatement("SELECT * FROM JOUEURS where id_joueur = ?");
            pst.setString(1,id);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                username_tf.setText(rs.getString(2));
            } else {
          JOptionPane.showMessageDialog(this, "Joueur introuvable");

            }
        } catch (SQLException ex) {
            Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_search_btnActionPerformed

    private void username_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_tfActionPerformed

    private void id_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_cbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_cbxActionPerformed

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
            java.util.logging.Logger.getLogger(JoueurForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JoueurForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JoueurForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JoueurForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JoueurForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JoueurForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter_btn;
    private javax.swing.JComboBox<String> id_cbx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifier_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton supprimer_btn;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}
