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
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dessin extends View implements View.OnTouchListener {

    CheeseChaser cheeseChaser;

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        //int toto=this.getWidth();

        Log.d("Dessin", "start");
        //Log.d("cheeseChaserMaxWidth", "" + cheeseChaser.maxWidth);
        //Log.d("cheeseChaserMaxHeight", "" + cheeseChaser.maxHeight);

        //Log.d("cheeseChaserCaseWidth", "" + cheeseChaser.caseWidth);
        //Log.d("cheeseChaserCaseHeight", "" + cheeseChaser.caseHeight);
        // Set image de la première carte en haut a droite
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (cheeseChaser == null) {
            cheeseChaser = new CheeseChaser(20, 20, this.getWidth(), this.getHeight());
        }
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.mouse);


        Log.d("onDraw", "" + this.getWidth() + "-" + this.getHeight());

        int widthTotal = this.getWidth();
        int widthCase = widthTotal / cheeseChaser.games.length;
        int heightTotal = this.getHeight();
        int heightCase = heightTotal / cheeseChaser.games.length;

        for (int i = 0; i < cheeseChaser.games.length -1 ; i++) {
            for (int j = 0; j < cheeseChaser.games[i].length -1 ; j++) {
                //Cercle c = new Cercle((widthCase + (widthCase * i)), (heightCase + (heightCase * j)), 15);
                canvas.drawBitmap(bitmap, (widthCase + (widthCase * i)), (heightCase + (heightCase * j)), paint);
                //c.draw(canvas,b);

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

class Cercle {
    int xc, yc, rayon;
    private Paint paint;

    public Cercle(int x, int y, int r) {
        xc = x;
        yc = y;
        rayon = r;
        //paint.setFilterBitmap(true);
        paint = new Paint();
        /*paint.setColor(Color.rgb((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255))
        );*/
    }

    public void draw(Canvas canvas,Bitmap b) {

        //canvas.drawBitmap(b, 10,10,paint);
        //canvas.drawCircle(xc, yc, rayon, paint);
    }
}