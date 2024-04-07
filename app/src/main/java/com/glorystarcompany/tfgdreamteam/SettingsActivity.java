package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
//FUNCIONANDO//
public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton goBackThirdActivityImageButtonMain;
    private ImageView settingsImageViewMain, gloryCoinImageViewIconMain;
    private TextView usernameTextViewMain, mailTextViewMain,
            winsTextViewMain, defeatsTextViewMain, gloryCoinAmountTextViewMain;
    private Usuario usuarioActualAjustesMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent ThirdActivityIntentContainer = getIntent();
        usuarioActualAjustesMain = (Usuario) ThirdActivityIntentContainer.getSerializableExtra("ajustesUsuarioActual");

        goBackThirdActivityImageButtonMain = findViewById(R.id.imageButtonBackSettings);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackThirdActivityImageButtonMain);
        goBackThirdActivityImageButtonMain.setOnClickListener(this);

        settingsImageViewMain = findViewById(R.id.settingsImageView);
        Glide.with(this).asGif().load(R.drawable.ajustes).into(settingsImageViewMain);

        gloryCoinImageViewIconMain = findViewById(R.id.gloryCoinImageViewIcon);
        Glide.with(this).asGif().load(R.drawable.glorycoin).into(gloryCoinImageViewIconMain);

        usernameTextViewMain = findViewById(R.id.usernameTextView);
        usernameTextViewMain.setText(usuarioActualAjustesMain.getName());

        mailTextViewMain = findViewById(R.id.mailTextView);
        mailTextViewMain.setText(usuarioActualAjustesMain.getMail());

        winsTextViewMain = findViewById(R.id.winsTextView);
        winsTextViewMain.setText(String.valueOf(usuarioActualAjustesMain.getWins()));

        defeatsTextViewMain = findViewById(R.id.defeatsTextView);
        defeatsTextViewMain.setText(String.valueOf(usuarioActualAjustesMain.getDefeats()));

        gloryCoinAmountTextViewMain = findViewById(R.id.gloryCoinAmountTextView);
        gloryCoinAmountTextViewMain.setText(String.valueOf(usuarioActualAjustesMain.getGcAmount()));

    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageButtonBackSettings) {
            finish();
        }
    }
}
