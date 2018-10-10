package com.example.tristans.cheesechasers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Activity lecontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.NewGame);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent defineIntent = new Intent(lecontext, pagegame.class);
                //lecontext.startActivity(defineIntent);
            }
        });
    }
}
