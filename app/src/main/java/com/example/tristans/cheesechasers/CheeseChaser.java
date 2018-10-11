package com.example.tristans.cheesechasers;

import java.util.ArrayList;
import java.util.List;

// 0 = Vide
// 1 = +
// 2 = Souris
// 3 = Chat
// 4 = Fromage
// 5 = Trap
class CheeseChaser {
    Card[][] games;
    List<Card> cartes;

    public CheeseChaser(int column, int row) {
        this.games = new Card[column][row];
        this.cartes = new ArrayList<Card>();
    }

    public List<Card> initialiserCartes(int nbChat, int nbSouris, int nbTrap, int nbFromage) {
        List<Card> games = new ArrayList<Card>();
        for (int i = 0; i < nbChat; i++) {
            games.add(new  Card(3)); // Chat
        }

        for (int i = 0; i < nbSouris; i++) {
            games.add(new  Card(2)); // Souris
        }

        for (int i = 0; i < nbTrap; i++) {
            games.add(new  Card(5)); // Trap
        }

        for (int i = 0; i < nbFromage; i++) {
            games.add(new  Card(4)); // Fromage
        }
        return games;
    }

    public Integer getScore(){
        return 0;
    }
}