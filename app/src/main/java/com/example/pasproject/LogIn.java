package com.example.pasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Response;

public class LogIn extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";

    public static final String EMAIL_KEY = "email_key";

    public static final String PASSWORD_KEY = "password_key";

    SharedPreferences sharedpreferences;
    String email, password;

    EditText eTxtEmail;
    EditText eTxtPassword;
    Button btnLogin;
    ProgressBar pbloadingBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // connect semua komponen dengan xml nya
        eTxtEmail = (EditText) findViewById(R.id.et_email);
        eTxtPassword = (EditText) findViewById(R.id.et_password);
        pbloadingBar = findViewById(R.id.pbloadingBar);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eTxtEmail.getText().toString();
                String password = eTxtPassword.getText().toString();
                pbloadingBar.setVisibility(View.VISIBLE);
                btnLogin.setEnabled(false);

//                hit api logIn
                AndroidNetworking.post("https://mediadwi.com/api/latihan/login")
                        .addBodyParameter("username", username)
                        .addBodyParameter("password", password)
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Handle successful response
                                Log.d("LogIn Success", "onResponse: " + response.toString());
                                try {
                                    boolean status = response.getBoolean("status");
                                    String message = response.getString("message");
                                    if (status) {
                                        Toast.makeText(LogIn.this, message, Toast.LENGTH_SHORT).show();
                                        // atau silahkan buat dialog
                                        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedpreferences.edit();
                                        editor.putString(EMAIL_KEY, username.toString());
                                        editor.putString(PASSWORD_KEY, "");

                                        // to save our data with key and value.
                                        editor.apply();
                                        startActivity(new Intent(LogIn.this, ListMovieMain.class));
                                        finish();
                                    }else{
                                        Toast.makeText(LogIn.this, message, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                pbloadingBar.setVisibility(View.GONE);
                                btnLogin.setEnabled(true);
                            }

                            @Override
                            public void onError(ANError anError) {
                                // Handle error
                                Log.e("LogIn Error", "onError: " + anError.getErrorBody(), anError);
                                Toast.makeText(LogIn.this, "Error: " + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}