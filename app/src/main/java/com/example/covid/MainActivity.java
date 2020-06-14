package com.example.covid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    Button login, create;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("COVID 19");
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.btnFacebook);

        if(AccessToken.getCurrentAccessToken()==null)
        {
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    goMainScreen();
                }



                @Override
                public void onCancel() {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "No se pudo Iniciar Sesión", Toast.LENGTH_SHORT);
                    toast1.show();
                }

                @Override
                public void onError(FacebookException error) {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Error al Iniciar Sesión", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            });

            login = (Button) findViewById(R.id.btnLogin);
            create = (Button) findViewById(R.id.btnCreate);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), login.class);
                    startActivityForResult(intent,0);
                }
            });

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),crearcuenta.class);
                    startActivityForResult(intent,0);
                }
            });
        }else{
            Intent intent = new Intent(this,Covid.class);
            startActivityForResult(intent,0);
        }

    }



    private void goMainScreen() {
        Intent intent = new Intent(this, Covid.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }



}
