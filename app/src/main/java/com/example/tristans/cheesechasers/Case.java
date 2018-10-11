package com.example.tristans.cheesechasers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

// 0 = Vide
// 1 = +
// 2 = Souris
// 3 = Chat
// 4 = Fromage
// 5 = Trap

public class Case {
    int positionX;
    int positionY;
    int type;

    public Case(int x, int y, int type) {
        this.positionX = x;
        this.positionY = y;
        this.type = type;
    }

    public Case() {
        this.positionX = -1;
        this.positionY = -1;
        this.type = -1;
    }
}