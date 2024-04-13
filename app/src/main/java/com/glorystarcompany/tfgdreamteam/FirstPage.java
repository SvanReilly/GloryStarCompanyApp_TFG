package com.glorystarcompany.tfgdreamteam;

import android.app.Activity;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;


public class FirstPage extends AppCompatActivity {
    private String usuarioActualFirstPageActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_first_page);

        Intent ChessActivityContainerToGames = getIntent();
        usuarioActualFirstPageActivity = ChessActivityContainerToGames.getStringExtra("usuarioActualChessActivity");

        final ImageView FirstLayout = (ImageView) findViewById(R.id.FirstLayout);
        Glide.with(this).asGif().load(R.drawable.chessingame).into(FirstLayout);
        final LinearLayout SecondLayout = (LinearLayout) findViewById(R.id.SecondLayout);

        SecondLayout.setVisibility(View.INVISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SecondLayout.setVisibility(View.VISIBLE);
                FirstLayout.setVisibility(View.INVISIBLE);
            }
        },5000);

        ImageButton StartGame = (ImageButton) findViewById(R.id.button);
        Glide.with(this).asGif().load(R.drawable.letsstart).into(StartGame);

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstPage.this, ChessGameActivity.class);
                i.putExtra("usuarioActualFirstPageActivity", usuarioActualFirstPageActivity);
                FirstPage.this.startActivity(i);
                finish();
            }
        });
    }
}