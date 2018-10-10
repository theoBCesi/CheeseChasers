package com.example.tristans.cheesechasers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class Dessin extends View implements View.OnTouchListener {

    //LinkedList<Cercle> cercles;
    Case[][] jeux = new Case[5][10];

    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("onDraw", "" + this.getWidth() + "-" + this.getHeight());
        Case c =new Case(100,100,100);
        c.draw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Log.d("onTouch", "x: " + event.getX() + " - y: " + event.getY());

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
        Log.d("drawCase","draw");
        canvas.drawCircle(100, 100, 50, paint);
        //canvas.drawRect(20, 20, 20, 20, paint);
        //canvas.drawBitmap(getRessource());
    }
}