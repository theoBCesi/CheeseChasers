package com.example.tristans.cheesechasers;

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
        List<Card> games = new ArrayList<Card>();
        for (int i = 0; i < nbChat; i++) {
            games.add(new Card(3)); // Chat
        }

        for (int i = 0; i < nbSouris; i++) {
            games.add(new Card(2)); // Souris
        }

        for (int i = 0; i < nbTrap; i++) {
            games.add(new Card(5)); // Trap
        }

        for (int i = 0; i < nbFromage; i++) {
            games.add(new Card(4)); // Fromage
        }
        Collections.shuffle(games);
        return games;
    }

    public Case[][] initialiserCase(int column, int row) {
        Case[][] cases = new Case[column][row];
        for (int i = 0; i < this.games[i].length - 1; i++) {
            for (int j = 0; j < this.games[j].length - 1; j++) {
                cases[i][j] = new Case((this.caseWidth + (this.caseWidth * i)), (this.caseHeight + (this.caseHeight * j)), 0);
            }
        }
        return cases;
    }

    public Case getCase(float x, float y) {
        Case c = new Case();
        for (int i = 0; i < this.games[i].length - 1; i++) {
            for (int j = 0; j < this.games[j].length - 1; j++) {
                if ((games[i][j].positionX < x && x < games[i][j].positionX + this.caseWidth)
                        && (games[i][j].positionY < y && y < games[i][j].positionY + this.caseHeight)) {
                    c = games[i][j];
                }
            }
        }
        return c;
    }
}