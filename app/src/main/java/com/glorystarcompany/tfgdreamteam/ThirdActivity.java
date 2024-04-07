package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    Usuario usuarioLogueado, usuarioNuevoLogueado;
    ImageButton goBackImageButtonMain;
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



        goBackImageButtonMain = findViewById(R.id.imageButtonBackThird);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackImageButtonMain);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.imageButtonBackThird) {

            Intent goBackToFirstActivity = new Intent(this, FirstActivity.class);
            startActivity(goBackToFirstActivity);
            finish();
        }
    }
}
