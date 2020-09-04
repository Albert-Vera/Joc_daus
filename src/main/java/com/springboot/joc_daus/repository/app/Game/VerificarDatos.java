package com.springboot.joc_daus.repository.app.Game;

import com.springboot.joc_daus.model.User;

import java.util.Optional;

public class VerificarDatos {
    public User verificarDatosUser(User user){

        if ( user.getUserName() == null || user.getUserName().length() == 0  ) user.setUserName("ANONIM");

        return user;
    }
    public User asignarValoresNewUser(User user){
        user.setCounterPlays(0);
        user.setPlaysWon(0);
        user.setRanking(0);
        return user;
    }
    public User editarUser(User userOriginal, User user ){
        user.setCounterPlays(userOriginal.getCounterPlays());
        user.setPlaysWon(userOriginal.getPlaysWon());
        user.setRanking(userOriginal.getRanking());
        //user.setDate(user.getDate());

        return user;
    }
}
