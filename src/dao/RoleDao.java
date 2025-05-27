/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Role;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class RoleDao {
    private static final String SQL_SELECT = "SELECT * FROM roles";
    private static Role convertResultSetToRole(ResultSet rs) throws SQLException{
        return new Role(
        rs.getLong("id"),
        rs.getString("nom")
        );
    }
    public static List<Role> getAllRole ()throws SQLException,ClassNotFoundException{
        ResultSet rs = DatabaseService.executeQuery(SQL_SELECT);
        List<Role> roleList = new ArrayList<>();
        while (rs.next()){
            Role role = convertResultSetToRole(rs);
            roleList.add(role);
        }
        return roleList;
        
    }
    
}
