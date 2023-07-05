package com.techwikiaa.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
       EditText editmail,editpassword1,getEditpassword2;
    Button loginbtn,signup;
    ImageButton imgbtn;

    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[A-Z])"+         // at least 1 uppercase
                    "(?=.*[a-zA-Z0-9])"+
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{9,20}" +                // at least 8 characters
                    "$");

    // String EmailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+"; // email regex
    String PasswordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$"; // password regex

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        editmail = findViewById(R.id.editText);
        editpassword1 =findViewById(R.id.editPassword);
        imgbtn = findViewById(R.id.back);
        loginbtn = findViewById(R.id.loginbtn2);
        signup = findViewById(R.id.signupbtn2);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailinput = editmail.getText().toString();
                String passinput = editpassword1.getText().toString();

                if(emailinput.isEmpty()){
                    Toast.makeText(LoginActivity.this, " please enter an email ", Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
                    Toast.makeText(LoginActivity.this,"please enter a valid email", Toast.LENGTH_SHORT).show();
                }else if (passinput.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please enter a password", Toast.LENGTH_SHORT).show();
                }else if (!PASSWORD_PATTERN.matcher(passinput).matches()) {
                    Toast.makeText(LoginActivity.this, "please enter valid keywords", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "login successed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AfterLoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}