package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private ImageView aDreamTeamProjectViewMain, tapToContinueViewMain;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aDreamTeamProjectViewMain = findViewById(R.id.aDreamTeamProjectView);
        Glide.with(this).asGif().load(R.drawable.introcredit).into(aDreamTeamProjectViewMain);

        tapToContinueViewMain = findViewById(R.id.tapToContinueView);
        Glide.with(this).asGif().load(R.drawable.taptocontinue).into(tapToContinueViewMain);

        rootView = findViewById(android.R.id.content);

        // Crea un Handler y utiliza el método postDelayed para retrasar la visibilidad del ImageView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hacer que el ImageView sea visible
                tapToContinueViewMain.setVisibility(View.VISIBLE);
            }
        }, 3000); // 3000 milisegundos = 3 segundos

        rootView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        startActivity(new Intent(MainActivity.this, FirstActivity.class));
        // Finalizar MainActivity si no quieres volver atrás
        finish();
        // Devolver true para indicar que el evento ha sido manejado
        return true;
    }
}




