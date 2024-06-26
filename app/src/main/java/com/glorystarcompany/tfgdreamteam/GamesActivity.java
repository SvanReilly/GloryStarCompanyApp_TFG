package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GamesActivity extends AppCompatActivity implements View.OnClickListener{

    private Toast toast;
    private String toastMessage, usuarioActualGames;
    private ImageView juegosImageViewMain;

    private ImageButton goBackImageButtonMain, chessActivityImageButtonMain,
            threeInARowActivityImageButtonMain;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Intent ThirdActivityContainerToGames = getIntent();
        usuarioActualGames = ThirdActivityContainerToGames.getStringExtra("usuarioActualThirdActivity");

        juegosImageViewMain = findViewById(R.id.juegosGamesActivityImageView);
        Glide.with(this).asGif().load(R.drawable.juegos).into(juegosImageViewMain);

        goBackImageButtonMain = findViewById(R.id.imageButtonBackGamesToThird);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackImageButtonMain);
        goBackImageButtonMain.setOnClickListener(this);

        chessActivityImageButtonMain = findViewById(R.id.chessGamesActivityImageView);
        Glide.with(this).asGif().load(R.drawable.chess).into(chessActivityImageButtonMain);
        chessActivityImageButtonMain.setOnClickListener(this);

        threeInARowActivityImageButtonMain = findViewById(R.id.threeInARowGamesActivityImageView);
        Glide.with(this).asGif().load(R.drawable.tresenrayagame).into(threeInARowActivityImageButtonMain);
        threeInARowActivityImageButtonMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.imageButtonBackGamesToThird) {
            Intent goBackToThirdActivity = new Intent(this, ThirdActivity.class);
            goBackToThirdActivity.putExtra("usuarioActualGames", usuarioActualGames);
            startActivity(goBackToThirdActivity);
            finish();
        } else if (v.getId()== R.id.chessGamesActivityImageView) {
            toastMessage = "Cargando...";
            showToast(toastMessage);
            Intent goToChessActivity = new Intent(this, ChessActivity.class);
            goToChessActivity.putExtra("usuarioActualGames", usuarioActualGames);
            startActivity(goToChessActivity);

        } else if (v.getId()== R.id.threeInARowGamesActivityImageView) {
            toastMessage = "Cargando...";
            showToast(toastMessage);
            Intent goToThreeInARowActivity = new Intent(this, ThreeInARowActivity.class);
            goToThreeInARowActivity.putExtra("usuarioActualGames", usuarioActualGames);
            startActivity(goToThreeInARowActivity);
        }
    }


    private void showToast(String loginMessage) {
        // Crea el Toast con la duración corta
        toast = Toast.makeText(getApplicationContext(), loginMessage, Toast.LENGTH_LONG);
        toast.show(); // Muestra el Toast

        // Crea un temporizador para cancelar el Toast después de 2 segundos
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
                // No es necesario hacer nada en cada tick
            }

            public void onFinish() {
                toast.cancel(); // Cancela el Toast cuando el temporizador termina
            }
        }.start(); // Inicia el temporizador
    }


}































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































// Coded by Alejandro Ortega Maldonado aka SvanReilly in Github.