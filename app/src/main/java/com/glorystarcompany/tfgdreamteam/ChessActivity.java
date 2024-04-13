package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ChessActivity extends AppCompatActivity implements View.OnClickListener {

    private Toast toast;
    private String toastMessage, usuarioActualChessActivity;
    private ImageView chessActivityImageViewMain;

    private ImageButton goBackToGamesImageButtonMain, chessPlayImageButtonMain, chessDifficultyImageButtonMain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_selected);

        Intent GamesActivityContainer = getIntent();
        usuarioActualChessActivity = GamesActivityContainer.getStringExtra("usuarioActualGames");

        goBackToGamesImageButtonMain = findViewById(R.id.imageButtonBackChessToGames);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackToGamesImageButtonMain);
        goBackToGamesImageButtonMain.setOnClickListener(this);

        chessActivityImageViewMain = findViewById(R.id.chessActivitySelectedImageView);
        Glide.with(this).asGif().load(R.drawable.chess).into(chessActivityImageViewMain);

        chessPlayImageButtonMain = findViewById(R.id.playChessSelectedImageButton);
        Glide.with(this).asGif().load(R.drawable.jugar).into(chessPlayImageButtonMain);
        chessPlayImageButtonMain.setOnClickListener(this);

        chessDifficultyImageButtonMain= findViewById(R.id.difficultyChessSelectedImageButton);
        Glide.with(this).asGif().load(R.drawable.dificultad).into(chessDifficultyImageButtonMain);
        chessDifficultyImageButtonMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.imageButtonBackChessToGames) {
            Intent goBackToGamesActivity = new Intent(this, GamesActivity.class);
            startActivity(goBackToGamesActivity);
            finish();
        } else if (v.getId()== R.id.playChessSelectedImageButton) {
            toastMessage = "Pendiente";
            showToast(toastMessage);
            Intent goToChessGameActivity = new Intent(this, ChessGameActivity.class);
            goToChessGameActivity.putExtra("usuarioActualChessActivity", usuarioActualChessActivity);
            startActivity(goToChessGameActivity);

        } else if (v.getId()== R.id.difficultyChessSelectedImageButton) {
            toastMessage = "Próximamente...";
            showToast(toastMessage);
        }
    }

    private void showToast(String loginMessage) {
        // Crea el Toast con la duración corta
        toast = Toast.makeText(getApplicationContext(), loginMessage, Toast.LENGTH_SHORT);
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
