package com.example.myapplication.activity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.models.ApiReponse;
import com.example.myapplication.models.User;
import com.example.myapplication.utils.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscription extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPrenom;
    private EditText editTextEmail;
    private EditText editTextPassword;
   private EditText editTextconfirmationPassword;
    private Button btnInscrire;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);



        init();

        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom = editTextNom.getText().toString();
                String Prenom = editTextPrenom.getText().toString();
                String Email = editTextEmail.getText().toString();
                String Password = editTextPassword.getText().toString();
                String confirmation_de_password = editTextPassword.getText().toString();

                User user=new User();
                user.setNom(Nom);
                user.setPrenom(Prenom);
                user.setEmail(Email);
                user.setPassword(Password);
                user.setConfirmation_de_password(confirmation_de_password);

                Log.v("test", "" + Email.contains("@"));

                 if (Nom.equals("")) {

                    editTextNom.setError("Saisir le nom ");


                }
                 if (Prenom.equals("")) {

                    editTextPrenom.setError("Saisir le prénom ");


                }
               if (Email.equals("")) {

                    editTextEmail.setError("Saisir l'email ");}
                  else if (!Email.contains("@")) {

                       editTextEmail.setError("champs with @ ");

                }
                if (Password.equals("")) {

                    editTextPassword.setError("Saisir le mot de passe ");


                }
                 if (confirmation_de_password.equals("")) {

                     editTextconfirmationPassword.setError("Saisir la confirmation de mot de passe");
                 }
//               else if (!editTextconfirmationPassword.equals(editTextPassword))
//                    {
//                        Toast.makeText(Inscription.this, "Mot de passe non confirmé", Toast.LENGTH_SHORT).show();
//                 }
                 else {

                ApiUtil.getServiceClass().register(user).enqueue(new Callback<ApiReponse>() {
                    @Override
                    public void onResponse(Call<ApiReponse> call, Response<ApiReponse> response) {
                        // response.body().getStatus()

                        Log.v("status",response.body().getStatus()+"");


                        Intent i = new Intent(Inscription.this, LoginActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<ApiReponse> call, Throwable t) {
                        Log.v("erreur",t.getMessage());

                    }
                });

            }
            }
        });
    }

    void init() {

        editTextNom = findViewById(R.id.editText);
        editTextPrenom = findViewById(R.id.editText2);
        editTextEmail = findViewById(R.id.editText5);
        editTextPassword = findViewById(R.id.editText6);
        editTextconfirmationPassword=findViewById(R.id.editText8);
     //  editTextconfirmationPassword.setSelected(true);
        btnInscrire = findViewById(R.id.button);


    }
}
