package com.example.tristans.cheesechasers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dessin extends View implements View.OnTouchListener {

    //LinkedList<Cercle> cercles;
    Cercle[][] jeux = new Cercle[10][10];

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("onDraw", "" + this.getWidth() + "-" + this.getHeight());
        int widthTotal = this.getWidth();
        int widthCase = widthTotal / 10;
        int heightTotal = this.getHeight();
        int heightCase = heightTotal / 10;

        for (int i = 0; i < jeux.length-1; i++) {
            for (int j = 0; j < jeux[i].length-1; j++) {
                Cercle c = new Cercle((widthCase + (widthCase * i)), (heightCase + (heightCase * j)), 15);
                c.draw(canvas);
            }
        }

        //Paint p = new Paint();
        //Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        //canvas.drawBitmap(b, 0, 0, p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("onTouch", "-x: " + event.getX() + " - y: " + event.getY());

        //switch (event.getAction()) {
        //    case MotionEvent.ACTION_DOWN:
        //        Case c = new Case(1, 100, 100);
        //        jeux[0][1] = c;
        //        break;
        //}
        //this.invalidate();
        return true;
    }
}


class Case {
    int type;
    int largeur;
    int hauteur;
    private Paint paint;

    public Case(int type, int largeur, int hauteur) {
        this.type = type;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.rgb((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255))
        );
    }

    public void draw(Canvas canvas) {
        Log.d("drawCase", "draw");
        canvas.drawCircle(100, 100, 50, paint);
        //canvas.drawRect(20, 20, 20, 20, paint);
        //canvas.drawBitmap(getRessource());
    }
}

class Cercle {
    int xc, yc, rayon;
    private Paint paint;

    public Cercle(int x, int y, int r) {
        xc = x;
        yc = y;
        rayon = r;
        paint = new Paint();
        paint.setColor(Color.rgb((int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255))
        );
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(xc, yc, rayon, paint);
    }
}