
package dao;

import models.Utilisateur;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao {
    
      private static final String SQL_SELECT = "SELECT * FROM utilisateurs";
      private static final String SQL_INSERT = "insert into utilisateurs (nom,prenom,username,password,role_id) (?,?,?,?,?)";
      private static final String SQL_CONNECTION = "SELCT * FROM utilisateurs where username = ? ";
      
      public static Utilisateur connexionUser(String username) throws SQLException, ClassNotFoundException{
          ResultSet rs = DatabaseService.executeQuery(SQL_CONNECTION,username);
          if(rs.next()){
              return convertResultSetToUtilisateur(rs);
              
          }
          return null;
      }
     private static Utilisateur convertResultSetToUtilisateur(ResultSet rs) throws SQLException{
        return new Utilisateur(
        rs.getLong("id"),
        rs.getString("nom"),
        rs.getString("prenom"),
        rs.getString("username"),
        rs.getString("password"),
        rs.getLong("role_id")
        
        );
        
    }
    public static List<Utilisateur> getAllUtilisateur ()throws SQLException,ClassNotFoundException{
        ResultSet rs = DatabaseService.executeQuery(SQL_SELECT);
        List<Utilisateur> utilisateurList = new ArrayList<>();
        while (rs.next()){
            Utilisateur utilisateur = convertResultSetToUtilisateur(rs);
            utilisateurList.add(utilisateur);
        }
        return utilisateurList;
        
    }
    public static boolean addUser(Utilisateur user) throws SQLException,ClassNotFoundException{
        int row = DatabaseService.executeUpdate(SQL_INSERT,
                user.getNom(),
                user.getPrenom(),
                user.getUsername(),
                user.getPassword(),
                user.getRole_id()
        );
        return row>1;
    }
  
}
