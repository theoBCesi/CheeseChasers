package com.example.tristans.cheesechasers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

public class PageGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_game);
        Dessin d = findViewById(R.id.dessin);
        ImageButton imgBtn = (ImageButton) findViewById(R.id.imgBtnCarte);
        d.ImageBtn = imgBtn;
    }
}
