package com.example.tristans.cheesechasers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

public class Dessin extends View implements View.OnTouchListener {

    LinkedList<Cercle> cercles;
    public Dessin(Context context, AttributeSet attrs) {
        super(context, attrs);
        cercles = new LinkedList<Cercle>();
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Cercle c : cercles) {
            c.draw(canvas);
        }
        Log.d("ee",""+this.getWidth()+"-"+this.getHeight());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                cercles.add(new Cercle(x, y, 1));
                break;
            case MotionEvent.ACTION_MOVE:
                Cercle clast = cercles.getLast();
                clast.rayon = (int) Math.sqrt((x - clast.xc) * (x - clast.xc) + (y - clast.yc) * (y - clast.yc));
                break;
        }
        this.invalidate();
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