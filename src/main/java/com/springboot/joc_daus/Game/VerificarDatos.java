package com.springboot.joc_daus.Game;

import com.springboot.joc_daus.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VerificarDatos {
    public User verificarUserName(User user, List<User> userList){

        if ( user.getUserName() == null || user.getUserName().length() == 0  ) user.setUserName("ANONIM");

        for ( User x: userList){

            if (x.getUserName().equalsIgnoreCase(user.getUserName()) && !x.getUserName().equalsIgnoreCase("ANONIM"))
                user.setUserName("ERROR.. USUARIO YA EXISTENTE !");
        }
        return user;
    }
    public User asignarValoresUser(User user, String str){
        user.setCounterPlays(0);
        user.setPlaysWon(0);
        user.setRanking(0);
        // condicional para conservar la DateRegister al borrar Lista de Plays
        if ( !str.equalsIgnoreCase("delete")) user.setDateRegister(getDate());
        else user.setDateRegister(user.getDateRegister());
        return user;
    }
    public User editarUser(User userOriginal, User user){
        user.setCounterPlays(userOriginal.getCounterPlays());
        user.setPlaysWon(userOriginal.getPlaysWon());
        user.setRanking(userOriginal.getRanking());
        user.setDateRegister(userOriginal.getDateRegister());

        return user;
    }
    public String getDate() {
        Date date = new Date();
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return fecha.format(date);
    }
}
