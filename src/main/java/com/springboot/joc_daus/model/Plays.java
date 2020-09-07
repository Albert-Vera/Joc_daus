package com.springboot.joc_daus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "plays")
public class Plays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_play")
    private int idPlay;

    @Column(name = "diceOne")
    private int diceOne ;

    @Column(name = "diceTwo")
    private int diceTwo;

    @Column(name = "win")
    private boolean win;

    @Column(name = "userId")
    private int userId;

    @JsonIgnore
    @ManyToOne (  cascade = CascadeType.ALL) //fetch = FetchType.LAZY,
    @JoinTable(
            name = "user_play",
            joinColumns = {@JoinColumn(name = "FK_PLAY", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "FK_USER", nullable = false)}
    )
    private User userMany;
    // @JoinColumn(name="id_user") //, insertable = false, updatable = false

    //private Map<Integer, Integer> lista = new HashMap<>();
    public Plays() {
    }

    public int getIdPlay() {
        return idPlay;
    }

    public void setIdPlay(int idPlay) {
        this.idPlay = idPlay;
    }

    public int getDiceOne() {
        return diceOne;
    }

    public void setDiceOne(int diceOne) {
        this.diceOne = diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public void setDiceTwo(int diceTwo) {
        this.diceTwo = diceTwo;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public User getUserMany() {
        return userMany;
    }

    public void setUsererMany(User userMany) {
        this.userMany = userMany;
    }
//    public List<User> getUserManyList() {
//        return userManyList;
//    }
//
//    public void setUserManyList(User userMany) {
//        if(this.userManyList == null){
//            this.userManyList = new ArrayList<>();
//        }
//        this.userManyList.add(userMany);
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
