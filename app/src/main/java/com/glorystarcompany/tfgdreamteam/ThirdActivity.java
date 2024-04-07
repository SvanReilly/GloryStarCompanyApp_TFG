package com.glorystarcompany.tfgdreamteam;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
//FUNCIONANDO//
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private Toast toast;
    private String toastMessage;

    private Usuario usuarioLogueado, usuarioNuevoLogueado;
    private ImageButton goBackImageButtonMain, settingsActivityImageButtonMain,
            gamesImageButtonMain, onlineImageButtonMain,
            recordsImageButtonMain, eventsImageButtonMain,
            logOutImageButtonMain, creditosImageButtonMain;
    private TextView currentUserName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent secondActivityIntentContainer = getIntent();
        usuarioNuevoLogueado = (Usuario) secondActivityIntentContainer.getSerializableExtra("usuarioNuevo");

        Intent firstActivityIntentContainer = getIntent();
        usuarioLogueado = (Usuario) firstActivityIntentContainer.getSerializableExtra("usuarioEntrante");

        if (usuarioLogueado == null){
            usuarioLogueado = usuarioNuevoLogueado;
        }

        currentUserName=findViewById(R.id.usernameTextViewThird);

        currentUserName.setText(usuarioLogueado.getName());

//        goBackImageButtonMain = findViewById(R.id.imageButtonBackThird);
//        Glide.with(this).asGif().load(R.drawable.back).into(goBackImageButtonMain);
//        goBackImageButtonMain.setOnClickListener(this);

        settingsActivityImageButtonMain = findViewById(R.id.settingsImageButton);
        Glide.with(this).asGif().load(R.drawable.settings).into(settingsActivityImageButtonMain);
        settingsActivityImageButtonMain.setOnClickListener(this);

        gamesImageButtonMain = findViewById(R.id.gamesImageButton);
        Glide.with(this).asGif().load(R.drawable.juegos).into(gamesImageButtonMain);
        gamesImageButtonMain.setOnClickListener(this);

        onlineImageButtonMain = findViewById(R.id.onlineImageButton);
        Glide.with(this).asGif().load(R.drawable.online).into(onlineImageButtonMain);
        onlineImageButtonMain.setOnClickListener(this);

        recordsImageButtonMain = findViewById(R.id.recordsImageButton);
        Glide.with(this).asGif().load(R.drawable.records).into(recordsImageButtonMain);
        recordsImageButtonMain.setOnClickListener(this);

        eventsImageButtonMain = findViewById(R.id.eventsImageButton);
        Glide.with(this).asGif().load(R.drawable.eventos).into(eventsImageButtonMain);
        eventsImageButtonMain.setOnClickListener(this);

        logOutImageButtonMain = findViewById(R.id.logOutImageButton);
        Glide.with(this).asGif().load(R.drawable.cerrarsesion).into(logOutImageButtonMain);
        logOutImageButtonMain.setOnClickListener(this);

        creditosImageButtonMain = findViewById(R.id.creditosImageButton);
        Glide.with(this).asGif().load(R.drawable.creditos).into(creditosImageButtonMain);
        creditosImageButtonMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.logOutImageButton) {
            Intent goBackToFirstActivity = new Intent(this, FirstActivity.class);
            startActivity(goBackToFirstActivity);
            finish();
        } else if (v.getId()== R.id.settingsImageButton) {
            Intent goToSettingsActivity = new Intent(this, SettingsActivity.class);
            goToSettingsActivity.putExtra("ajustesUsuarioActual", usuarioLogueado);
            startActivity(goToSettingsActivity);

        } else if (v.getId()== R.id.gamesImageButton) {
            toastMessage = "Pendiente";
            showToast(toastMessage);
//            Intent goToGamesActivity = new Intent(this, GamesActivity.class);
//            goToGamesActivity.putExtra("ajustesUsuarioActual", usuarioLogueado);
//            startActivity(goToGamesActivity);
        } else if (v.getId()== R.id.onlineImageButton) {
            toastMessage = "Próximamente. En desarrollo...";
            showToast(toastMessage);
        } else if (v.getId()== R.id.recordsImageButton) {
            toastMessage = "Próximamente. En desarrollo...";
            showToast(toastMessage);
        } else if (v.getId()== R.id.eventsImageButton) {
            toastMessage = "Próximamente. En desarrollo...";
            showToast(toastMessage);
        } else if (v.getId()== R.id.creditosImageButton) {
            Intent goToCreditsActivity = new Intent(this, CreditsActivity.class);
            startActivity(goToCreditsActivity);
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
