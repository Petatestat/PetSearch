package com.pisici.caini.petsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    EditText mEmailEt;
    EditText mPasswordEt;
    Button mLoginBtn;
    Button mSignupBtn;
    /*private FirebaseAuth mAuth;
    User user;*/
    ImageView gif;
    ImageView logo;
    Button mresend_verificationBtn;
    Button mreset_passwordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
