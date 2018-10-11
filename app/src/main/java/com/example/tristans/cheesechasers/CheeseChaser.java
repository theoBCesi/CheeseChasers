package com.example.tristans.cheesechasers;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 0 = Vide
// 1 = +
// 2 = Souris
// 3 = Chat
// 4 = Fromage
// 5 = Trap
class CheeseChaser {
    Case[][] games;
    List<Card> cartes;
    int maxWidth;
    int maxHeight;
    int caseWidth;
    int caseHeight;

    public CheeseChaser(int column, int row, int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.games = new Case[column][row];
        this.caseWidth = maxWidth / this.games[0].length;
        this.caseHeight = maxHeight / this.games[0].length;
        this.games = initialiserCase(column, row);
        this.cartes = initialiserCartes(7, 20, 4, 9);
    }

    public List<Card> initialiserCartes(int nbChat, int nbSouris, int nbTrap, int nbFromage) {
        List<Card> cartes = new ArrayList<Card>();
        for (int i = 0; i < nbChat; i++) {
            cartes.add(new Card(3)); // Chat
        }

        for (int i = 0; i < nbSouris; i++) {
            cartes.add(new Card(2)); // Souris
        }

        for (int i = 0; i < nbTrap; i++) {
            cartes.add(new Card(5)); // Trap
        }

        for (int i = 0; i < nbFromage; i++) {
            cartes.add(new Card(4)); // Fromage
        }
        Collections.shuffle(cartes);
        return cartes;
    }

    public Case[][] initialiserCase(int column, int row) {
        Case[][] cases = new Case[column][row];
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[i].length; j++) {
                if (i == (column / 2) && j == (row / 2)) {
                    cases[i][j] = new Case((this.caseWidth * i), (this.caseHeight * j), 2);
                } else {
                    cases[i][j] = new Case((this.caseWidth * i), (this.caseHeight * j), 0);
                }
            }
        }
        return cases;
    }

    public Case getCase(float x, float y) {
        Case c = new Case();
        for (int i = 0; i < games.length; i++) {
            for (int j = 0; j < games[i].length; j++) {
                if ((games[i][j].positionX < x && x < games[i][j].positionX + this.caseWidth)
                        && (games[i][j].positionY < y && y < games[i][j].positionY + this.caseHeight)) {
                    c = games[i][j];
                }
            }
        }
        return c;
    }
}