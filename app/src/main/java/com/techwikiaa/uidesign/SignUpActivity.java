package com.techwikiaa.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private static final Pattern name_pattern = Pattern.compile("^"+"(?=.*[A-Za-z])"+"$");
    private static final Pattern password_pattern = Pattern.compile("^"+"(?=.*[A-Z])"+"(?=.*[a-z])"+"(?=.*[0-9])"+"(?=.*[a-zA-Z0-9])"+"(?=.*[!@#%^&*])"+"(?=\\S+$)"+".{8,15}"+"$");


    // String name_pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z])$";
    // String password_pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#$@%^&*()=+])(?=.*[a-zA-Z0-9])(?=\\S+$).{8,20}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        ImageButton imagebtn = findViewById(R.id.imgbtn);
        Button singupbtn = findViewById(R.id.signup);
        Button signin = findViewById(R.id.signin);
        EditText nickname = findViewById(R.id.nickname);
        EditText email = findViewById(R.id.editText);
        EditText password = findViewById(R.id.editPassword);
        EditText confirmPass = findViewById(R.id.editConfirmpw);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        singupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nicknameinput = nickname.getText().toString();
                String emailinput = email.getText().toString();
                String passwordinput = password.getText().toString();
                String ConPassInp = confirmPass.getText().toString();

                if (nicknameinput.isEmpty() || name_pattern.matcher(nicknameinput).matches()){
                    nickname.setError("name can't be blank");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
                    email.setError("enter a valid email");
                } else if (!password_pattern.matcher(passwordinput).matches()) {
                    password.setError("please enter a valid password");
                } else if (ConPassInp.isEmpty()) {
                    confirmPass.setError("password can't be empty!");
                } else if (!ConPassInp.equals(passwordinput)) {
                    confirmPass.setError("password doesn't match!");
                }
                else {
                    Intent intent = new Intent(SignUpActivity.this, AfterSignUpActivity.class);
                    startActivity(intent);
                    Toast.makeText(SignUpActivity.this, "account created successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}