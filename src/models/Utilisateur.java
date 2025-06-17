/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author user
 */
public class Utilisateur {
    private long id;
    private String nom;
    private String prenom;
    private String username;
    private String password;

    
    
    
    public Utilisateur(String nom, String prenom, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
       
    }

    public Utilisateur(long id, String nom, String prenom, String username, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
       
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    

    
}
