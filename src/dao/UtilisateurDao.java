
package dao;

import models.Utilisateur;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

public class UtilisateurDao {
    private static final String sqlinsert = "INSERT INTO UTILISATEURS(nom,prenom,username,password) values (?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM  UTILISATEURS";
    private static final String SQL_Connexion = "SELECT * FROM  UTILISATEURS where username=? ";
    


    public static Utilisateur createuser(Utilisateur user) throws SQLException, ClassNotFoundException { 
        long idinserted = DatabaseService.executeInsertWithGeneratedKey(sqlinsert, user.getNom(), user.getPrenom(), user.getUsername(), user.getPassword());
        user.setId(idinserted);
        return user;
    }
    
    private static Utilisateur ConvertirResultSetToUser(ResultSet rs) throws SQLException, ClassNotFoundException {
        return new Utilisateur(rs.getLong("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("username"),rs.getString("password"),rs.getLong("role_id"));

    }
    
    public static Utilisateur getUserByPasswordAndUsername(String username) throws SQLException, ClassNotFoundException {

        ResultSet rs = DatabaseService.executeQuery(SQL_Connexion, username);
        if (rs.next()) {

            return ConvertirResultSetToUser(rs);
            

        }
        return null;

    }
    public static boolean usernameExiste(String username) throws SQLException, ClassNotFoundException {
    Connection con = DatabaseService.getConnection();
    PreparedStatement pst = con.prepareStatement("SELECT * FROM utilisateurs WHERE username = ?");
    pst.setString(1, username);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        return true;
    }
    return false;
}
    public static boolean joueurExiste(String username) throws SQLException, ClassNotFoundException {
    Connection con = DatabaseService.getConnection();
    PreparedStatement pst = con.prepareStatement("SELECT * FROM joueurs WHERE username = ?");
    pst.setString(1, username);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        return true;
    }
    return false;
}


}
      
              
  

