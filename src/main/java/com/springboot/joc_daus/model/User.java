package com.springboot.joc_daus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int idUser;

    @Column(name = "userName")
    private String userName;

    @Column(name = "counterPlays")
    private int counterPlays;

    @Column(name = "ranking")
    private double ranking;

    @Column(name = "playsWon")
    private int playsWon;
    @Column(name="dateRegister")
    private String dateRegister;

    @JsonIgnore
    @OneToMany(mappedBy="userMany" ) //, cascade = CascadeType.ALL
    private List<Plays> playsList ;

    public User() {
    }
    public User(int idUser, String userName, int counterPlays, double ranking, int playsWon, List<Plays> playsList, String dateRegister) {
        this.idUser = idUser;
        this.userName = userName;
        this.counterPlays = counterPlays;
        this.ranking = ranking;
        this.playsWon = playsWon;
        this.playsList = playsList;
        this.dateRegister = dateRegister;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public List<Plays> getPlaysList() {
        return playsList;
    }

    public void setPlaysList(Plays play) {
        if(this.playsList == null){
            this.playsList = new ArrayList<>();
        }
        this.playsList.add(play);
        System.out.println("anadido..... " + getUserName() + "  " +playsList.size());
    }

    public int getCounterPlays() {
        return counterPlays;
    }

    public void setCounterPlays(int counterPlays) {
        this.counterPlays = counterPlays;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public int getPlaysWon() {
        return playsWon;
    }

    public void setPlaysWon(int playsWon) {
        this.playsWon = playsWon;
    }
}
