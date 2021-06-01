package com.example.myapplication.activity;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.models.ApiObject;
import com.example.myapplication.models.User;
import com.example.myapplication.utils.ApiUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import javax.security.auth.callback.CallbackHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "AndroidClarified";
    private GoogleSignInClient googleSignInClient;
    private SignInButton googleSignInButton;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button button;
    private TextView textView;
    private CallbackHandler callbackHandler;
    private CallbackManager callbackManager;
    private TextView info;
    private LoginButton loginButton;



    // SessionManager sessionManager;

  //  RelativeLayout loginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //sessionManager = new SessionManager(this);
//        sessionManager.checkLogin();

        init();



        googleSignInButton = findViewById(R.id.sign_in_button);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //.requestIdToken()
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });








        FacebookSdk.sdkInitialize(getApplicationContext());
        CallbackManager callbackManager = CallbackManager.Factory.create();
        info =findViewById(R.id.info);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("User ID:  " +
                        loginResult.getAccessToken().getUserId() + "\n" +
                        "Auth Token: " + loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {

                Toast.makeText(getApplicationContext(),"Login attempt cancelled",Toast.LENGTH_SHORT);
            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(getApplicationContext(),"Login attempt failed.",Toast.LENGTH_SHORT);

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Inscription.class);
                startActivity(i);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                User user=new User();
                user.setEmail(Email);
                user.setPassword(password);

                Log.v("test", "" + Email.contains("@"));

                if (Email.equals("")) {

                    editTextEmail.setError("Saisir l'email ");}
                else if (!Email.contains("@")) {

                    editTextEmail.setError("champs with @ ");

                }
                if (password.equals("")) {

                    editTextPassword.setError("Saisir le mot de passe ");


                } else {


                    ApiUtil.getServiceClass().login(user).enqueue(new Callback<ApiObject>() {
                        @Override
                        public void onResponse(Call<ApiObject> call, Response<ApiObject> response) {
                          response.body().getStatus();


                            try {
                                Log.v("status",response.body().getStatus());
                                if(response.body().getStatus().equals("success")){

                                    Intent i = new Intent(LoginActivity.this, Navigation.class);
                                    startActivity(i);

                                } else {

                                    Toast.makeText(getApplicationContext(), "erreur ", Toast.LENGTH_LONG).show();
                                }} catch (Exception e){

                                Toast.makeText(getApplicationContext(), "erreur ", Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<ApiObject> call, Throwable t) {
                            Log.v("erreur",t.getMessage());

                            Toast.makeText(getApplicationContext(), "erreur ", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });
    }


    void init() {

        editTextEmail = findViewById(R.id.editText3);
        editTextPassword = findViewById(R.id.editText4);
        button = findViewById(R.id.button2);
        loginButton = findViewById(R.id.login_button);
        textView = findViewById(R.id.textView2);

        googleSignInButton = findViewById(R.id.sign_in_button);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case 101:
                    try {
                        // The Task returned from this call is always completed, no need to attach
                        // a listener.
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        onLoggedIn(account);
                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                    }
                    break;
            }
    }

    private void onLoggedIn(GoogleSignInAccount googleSignInAccount) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(ProfileActivity.GOOGLE_ACCOUNT, googleSignInAccount);

        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (alreadyloggedAccount != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            onLoggedIn(alreadyloggedAccount);
        } else {
            Log.d(TAG, "Not logged in");
        }
    }

}

