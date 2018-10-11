package com.example.tristans.cheesechasers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.text.LocaleDisplayNames;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dessin extends View implements View.OnTouchListener {

    public ImageButton ImageBtn;
    CheeseChaser cheeseChaser;

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("Dessin", "start");
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (cheeseChaser == null) {
            cheeseChaser = new CheeseChaser(10, 10, this.getWidth(), this.getHeight());
        }
        Paint paint = new Paint();
        Resources res = getResources();

        /** Gestion de la case de la carte et premier démarrage du jeu **/
        List<Card> vListeCards = cheeseChaser.cartes;
        if (vListeCards.get(0) != null) {
            Log.d("Test : ", "Card n°" + vListeCards.get(0).type);
            int chiffre = vListeCards.get(0).type;
            switch (chiffre) {
                case 2: // Souris
                    ImageBtn.setBackgroundResource(R.drawable.mouse);
                    break;
                case 3: // Chat
                    ImageBtn.setBackgroundResource(R.drawable.cat);
                    break;
                case 4: // Fromage
                    ImageBtn.setBackgroundResource(R.drawable.cheese);
                    break;
                case 5: // Piège
                    ImageBtn.setBackgroundResource(R.drawable.mousetrap);
                    break;
            }
        }
        Log.d("onDraw", "" + this.getWidth() + "-" + this.getHeight());
        Bitmap bitmap;
        Bitmap newBitmap;
        for (int i = 0; i < cheeseChaser.games.length; i++) {
            for (int j = 0; j < cheeseChaser.games[i].length; j++) {
                switch (cheeseChaser.games[i][j].type) {
                    case 1: //+
                        bitmap = BitmapFactory.decodeResource(res, R.drawable.plus);
                        newBitmap = Bitmap.createScaledBitmap(bitmap, cheeseChaser.caseWidth, cheeseChaser.caseHeight, true);
                        break;

                    case 2: // Souris
                        bitmap = BitmapFactory.decodeResource(res, R.drawable.mouse);
                        newBitmap = Bitmap.createScaledBitmap(bitmap, cheeseChaser.caseWidth, cheeseChaser.caseHeight, true);
                        break;

                    case 3: // Chat
                        bitmap = BitmapFactory.decodeResource(res, R.drawable.cat);
                        newBitmap = Bitmap.createScaledBitmap(bitmap, cheeseChaser.caseWidth, cheeseChaser.caseHeight, true);
                        break;

                    case 4: // Fromage
                        bitmap = BitmapFactory.decodeResource(res, R.drawable.cheese);
                        newBitmap = Bitmap.createScaledBitmap(bitmap, cheeseChaser.caseWidth, cheeseChaser.caseHeight, true);
                        break;

                    case 5: // Trap
                        bitmap = BitmapFactory.decodeResource(res, R.drawable.mousetrap);
                        newBitmap = Bitmap.createScaledBitmap(bitmap, cheeseChaser.caseWidth, cheeseChaser.caseHeight, true);
                        break;
                    default:
                        continue;
                }
                canvas.drawBitmap(newBitmap, i * cheeseChaser.caseWidth, j * cheeseChaser.caseHeight, paint);
            }
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("onTouch", "-x: " + event.getX() + " - y: " + event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Case c = cheeseChaser.getCase(event.getX(), event.getY());
                Log.d("Case touché", " type  " + c.type + "  x  " + c.positionX + " y  " + c.positionY);
                break;
        }
        //this.invalidate();
        return true;
    }
}