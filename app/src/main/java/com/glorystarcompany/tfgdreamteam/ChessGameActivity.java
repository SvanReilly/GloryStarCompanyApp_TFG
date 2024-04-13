package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChessGameActivity extends AppCompatActivity {

    private String toastMessage, usuarioActualChessGameActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_selected);

        Intent ChessActivityContainerToGames = getIntent();
        usuarioActualChessGameActivity = ChessActivityContainerToGames.getStringExtra("usuarioActualChessActivity");

        //Codigo de la ejecucion del juego


    }
}
