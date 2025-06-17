/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author user
 */
public class Tournois {
    private long id;
     private String name;
     private String game;
     private String datedebut;
     private String datefin;
     private long player;
     private long fraisinscription;
     private  String price;
     private long id_organisateur;

     public Tournois(long id, String name, String game, String datedebut, String datefin, long player, long fraisinscription, String price, long id_organisateur) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.player = player;
        this.fraisinscription = fraisinscription;
        this.price = price;
        this.id_organisateur = id_organisateur;
    }

    public Tournois(String name, String game, String datedebut, String datefin, long player, long fraisinscription, String price, long id_organisateur) {
        this.name = name;
        this.game = game;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.player = player;
        this.fraisinscription = fraisinscription;
        this.price = price;
        this.id_organisateur = id_organisateur;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public long getPlayer() {
        return player;
    }

    public void setPlayer(long player) {
        this.player = player;
    }

    public long getFraisinscription() {
        return fraisinscription;
    }

    public void setFraisinscription(long fraisinscription) {
        this.fraisinscription = fraisinscription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getId_organisateur() {
        return id_organisateur;
    }

    public void setId_organisateur(long id_organisateur) {
        this.id_organisateur = id_organisateur;
    }

    
}
