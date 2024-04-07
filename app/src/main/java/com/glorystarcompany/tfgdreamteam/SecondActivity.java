package com.glorystarcompany.tfgdreamteam;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private UsuariosBD firstActivityBD;
    private ArrayList<Usuario> listadoUsuariosExistentes;
    private Usuario usuarioNuevo;

    private ImageView crearUsuarioImageViewMain;
    private ImageButton registrarseImageButtonMain, goBackImageButtonMain;
    private EditText nombreUsuarioEditTextMain, passwordEditTextMain, confirmPassEditTextMain, maileditTextMain;
    private String signUpMessage, newUserName, newUserPassWord, newUserConfirmPassWord, newUserMail;
    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Intent firstActivityIntentContainer = getIntent();
//        firstActivityBD = (UsuariosBD) firstActivityIntentContainer.getSerializableExtra("usuariosGloryStarBD");

        crearUsuarioImageViewMain = findViewById(R.id.crearUsuarioImageView);
        Glide.with(this).asGif().load(R.drawable.crearusuario).into(crearUsuarioImageViewMain);

        nombreUsuarioEditTextMain = findViewById(R.id.cajaTextoNewUser);
        passwordEditTextMain = findViewById(R.id.cajaTextoNewPass);
        confirmPassEditTextMain = findViewById(R.id.cajaTextoConfirmPass);
        maileditTextMain = findViewById(R.id.cajaTextoMail);

        registrarseImageButtonMain = findViewById(R.id.imageButtonRegistrarNuevo);
        Glide.with(this).asGif().load(R.drawable.registrarse).into(registrarseImageButtonMain);

        goBackImageButtonMain = findViewById(R.id.imageButtonBackSecond);
        Glide.with(this).asGif().load(R.drawable.back).into(goBackImageButtonMain);


        firstActivityBD = new UsuariosBD(getApplicationContext());
        listadoUsuariosExistentes = firstActivityBD.getUsuarios();

        registrarseImageButtonMain.setOnClickListener(this);
        goBackImageButtonMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        newUserName = nombreUsuarioEditTextMain.getText().toString();
        newUserPassWord = passwordEditTextMain.getText().toString();
        newUserConfirmPassWord = confirmPassEditTextMain.getText().toString();
        newUserMail = maileditTextMain.getText().toString();


        if (v.getId() == R.id.imageButtonRegistrarNuevo) {

            if (newUserName.isEmpty() || newUserPassWord.isEmpty() || newUserConfirmPassWord.isEmpty() || newUserMail.isEmpty()) {
                signUpMessage = "Campos incompletos.";
                showToast(signUpMessage);
            } else if (!newUserPassWord.equals(newUserConfirmPassWord)) {
                signUpMessage = "Los campos de contraseña no son iguales.";
                showToast(signUpMessage);
            } else {
                boolean usuarioExistente = false;
                for (int i = 0; i < listadoUsuariosExistentes.size(); i++) {
                    if (newUserName.equals(listadoUsuariosExistentes.get(i).getName())) {
                        usuarioExistente = true;
                        signUpMessage = "Usuario existente. Pruebe otro nombre.";
                        showToast(signUpMessage);
                        break; // No necesitamos continuar verificando una vez que hemos encontrado un usuario existente
                    }
                }

                if (!usuarioExistente) {
                    usuarioNuevo = new Usuario(newUserName, newUserPassWord, newUserMail);

                    firstActivityBD.insertUsuario(usuarioNuevo);
                    signUpMessage = "Usuario creado. Accediendo...";
                    showToast(signUpMessage);
                    Intent goToThirdActivity = new Intent(this, ThirdActivity.class);
                    goToThirdActivity.putExtra("usuarioNuevo", usuarioNuevo);
                    startActivity(goToThirdActivity);
                    finish();
                }
            }
        } else if (v.getId() == R.id.imageButtonBackSecond) {
            Intent goBacktoFirstActivity = new Intent(this, FirstActivity.class);
            startActivity(goBacktoFirstActivity);
            finish();
        }
    }



    private void showToast(String signUpMessage) {
        // Crea el Toast con la duración corta
        toast = Toast.makeText(getApplicationContext(), signUpMessage, Toast.LENGTH_SHORT);
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

