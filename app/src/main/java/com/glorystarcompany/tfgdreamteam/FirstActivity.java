package com.glorystarcompany.tfgdreamteam;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
//FUNCIONANDO//
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private String username, pass;
    private ImageButton buttonContinuar, buttonRegistrarse;
    private ImageView gloryStarLogoImageViewMain, usernameImageViewMain, passwordImageViewMain, creditosImageButtonMain;
    private String loginMessage;
    private TextView usernameIns;
    private TextView passIns;
    private UsuariosBD usuariosGloryStarBD;

    private ArrayList<Usuario> listadoUsuariosExistentes;
    private Usuario usuarioEntrante;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        creditosImageButtonMain = findViewById(R.id.gloryStarLogoImageViewActFirst);


        gloryStarLogoImageViewMain = findViewById(R.id.gloryStarLogoImageViewActFirst);
        usernameImageViewMain = findViewById(R.id.usernameImageView);
        passwordImageViewMain = findViewById(R.id.passwordImageView);


        Glide.with(this).load(R.drawable.glorystarcompanylogo).into(gloryStarLogoImageViewMain);
        Glide.with(this).load(R.drawable.usuario).into(usernameImageViewMain);
        Glide.with(this).load(R.drawable.contrasena).into(passwordImageViewMain);
        buttonContinuar = findViewById(R.id.imageButtonContinuar);
        Glide.with(this).asGif().load(R.drawable.entrar).into(buttonContinuar);

        buttonRegistrarse = findViewById(R.id.imageButtonRegistrarse);
        Glide.with(this).asGif().load(R.drawable.registrarse).into(buttonRegistrarse);

        usernameIns = findViewById(R.id.cajaTextoCorreo);
        passIns = findViewById(R.id.cajaTextoPass);

        usuariosGloryStarBD = new UsuariosBD(getApplicationContext());
        listadoUsuariosExistentes = usuariosGloryStarBD.getUsuarios();


        buttonContinuar.setOnClickListener(this);
        buttonRegistrarse.setOnClickListener(this);
        creditosImageButtonMain.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        username = usernameIns.getText().toString();
        pass = passIns.getText().toString();

        if (view.getId() == R.id.imageButtonContinuar) {
            if (username.isEmpty() || pass.isEmpty()) {
                loginMessage = "Escribe un nombre de usuario y su contraseña.";
                showToast(loginMessage);
            } else {
                boolean credentialsMatch = false; // Bandera para realizar un seguimiento de si se encontró una coincidencia de credenciales

                for (int i = 0; i < listadoUsuariosExistentes.size(); i++) {
                    if (username.equals(listadoUsuariosExistentes.get(i).getName()) && pass.equals(listadoUsuariosExistentes.get(i).getPassword())) {

                        usuarioEntrante = listadoUsuariosExistentes.get(i);
                        loginMessage = "Iniciando sesión...";
                        showToast(loginMessage);

                        Intent goToThirdActivity = new Intent(this, ThirdActivity.class);
                        //Esto permite enviar los datos al ThirdActiivty del objeto usuarioEntrante que hemos cotejado y recogido de la bbdd
                        goToThirdActivity.putExtra("usuarioActualFirstActivity", usuarioEntrante.getName());

                        credentialsMatch = true; // Establece la bandera en verdadero porque se encontró una coincidencia
                        startActivity(goToThirdActivity);
                        finish();
                        break; // Sale del bucle porque ya se encontró una coincidencia
                    }
                }

                if (!credentialsMatch) { // Si no se encontró una coincidencia después de recorrer toda la lista
                    loginMessage = "Usuario y/o contraseña incorrectos.";
                    showToast(loginMessage);
                }
            }
        } else if (view.getId() == R.id.imageButtonRegistrarse) {
            Intent goToSecondActivity = new Intent(this, SecondActivity.class);
            startActivity(goToSecondActivity);
            finish();
        } else {
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





































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































// Coded by Alejandro Ortega Maldonado aka SvanReilly in Github.