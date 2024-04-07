package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
//FUNCIONANDO//

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private ImageView aDreamTeamProjectViewMain, tapToContinueViewMain, gloryStarCompanyLogoViewMain;
    private View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aDreamTeamProjectViewMain = findViewById(R.id.aDreamTeamProjectView);
        Glide.with(this).asGif().load(R.drawable.introcredit).into(aDreamTeamProjectViewMain);

        gloryStarCompanyLogoViewMain = findViewById(R.id.gloryStarCompanyLogoViewActMain);
        Glide.with(this).load(R.drawable.glorystarcompanylogo).into(gloryStarCompanyLogoViewMain);

        tapToContinueViewMain = findViewById(R.id.tapToContinueView);
        Glide.with(this).asGif().load(R.drawable.taptocontinue).into(tapToContinueViewMain);


        // Crea un Handler y utiliza el método postDelayed para retrasar la visibilidad del ImageView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hacer que el ImageView sea visible
                aDreamTeamProjectViewMain.setVisibility(View.VISIBLE);
            }
        }, 2000); // 3000 milisegundos = 3 segundos

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // Hacer que el ImageView sea visible
                gloryStarCompanyLogoViewMain.setVisibility(View.VISIBLE);
            }
        }, 4500);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // Hacer que el ImageView sea visible
                tapToContinueViewMain.setVisibility(View.VISIBLE);
            }
        }, 6000);


        rootView = findViewById(android.R.id.content);
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

//     public void setDelayedVisibilityToImageView()
//
//}




