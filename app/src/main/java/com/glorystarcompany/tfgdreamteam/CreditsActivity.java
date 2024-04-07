package com.glorystarcompany.tfgdreamteam;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
//FUNCIONANDO//
public class CreditsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton goBackImageButtonMain;
    private ImageView developedByMain, gscMain,
            alejandroMain, maikyMain, aaronMain, adriMain, ikerMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

//No se visualizan los nombres siquiera.

        developedByMain = findViewById(R.id.developedByImageView);
        Glide.with(this).load(R.drawable.developedbycredit).into(developedByMain);
        setVisibilityDelayedTrue(developedByMain, 2000);

        gscMain = findViewById(R.id.glorySCCreditsImageView);
        Glide.with(this).load(R.drawable.glorystarcompanylogo).into(gscMain);
        setVisibilityDelayedTrue(gscMain, 5500);

        alejandroMain = findViewById(R.id.alejandroImageView);
        Glide.with(this).load(R.drawable.alejandro).into(alejandroMain);
        setVisibilityDelayedTrue(alejandroMain, 3000);

        maikyMain = findViewById(R.id.maikyImageView);
        Glide.with(this).load(R.drawable.maiky).into(maikyMain);
        setVisibilityDelayedTrue(maikyMain, 3500);

        aaronMain = findViewById(R.id.aaronImageView);
        Glide.with(this).load(R.drawable.aaron).into(aaronMain);
        setVisibilityDelayedTrue(aaronMain, 4500);

        adriMain = findViewById(R.id.adriImageView);
        Glide.with(this).load(R.drawable.adri).into(adriMain);
        setVisibilityDelayedTrue(adriMain, 4000);

        ikerMain = findViewById(R.id.ikerImageView);
        Glide.with(this).load(R.drawable.iker).into(ikerMain);
        setVisibilityDelayedTrue(ikerMain, 5000);


        goBackImageButtonMain = findViewById(R.id.imageButtonBackCredits);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackImageButtonMain);
        goBackImageButtonMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageButtonBackCredits) {
            finish();
        }
    }
    public void setVisibilityDelayedTrue (ImageView iv, int time){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hacer que el ImageView sea visible
                iv.setVisibility(View.VISIBLE);
            }
        }, time);
    }
}
