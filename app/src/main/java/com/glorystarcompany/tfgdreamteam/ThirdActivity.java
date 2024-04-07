package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    Usuario usuarioLogueado, usuarioNuevoLogueado;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent secondActivityIntentContainer = getIntent();
        usuarioNuevoLogueado = (Usuario) secondActivityIntentContainer.getSerializableExtra("usuarioNuevo");

        Intent firstActivityIntentContainer = getIntent();
        usuarioLogueado = (Usuario) firstActivityIntentContainer.getSerializableExtra("usuarioEntrante");

//        if (usuarioNuevoLogueado == null){
//
//        } else {
//
//        }





    }

}
