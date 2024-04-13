package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThreeInARowGameActivity extends AppCompatActivity {

    private String toastMessage, usuarioActualThreeInARowGameActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_in_a_row_game);


        Intent ChessActivityContainerToGames = getIntent();
        usuarioActualThreeInARowGameActivity = ChessActivityContainerToGames.getStringExtra("usuarioActualThreeInARowActivity");


        //Codigo de la ejecucion del juego


    }
}
