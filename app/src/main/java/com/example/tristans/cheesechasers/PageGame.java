package com.example.tristans.cheesechasers;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class PageGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_game);
        Dessin d = findViewById(R.id.dessin);
        ImageButton imgBtn = (ImageButton) findViewById(R.id.imgBtnCarte);
        d.ImageBtn = imgBtn;
        TextView txtView = (TextView) findViewById(R.id.nbCartes);
        d.nbCarteRestant = txtView;
    }
}
