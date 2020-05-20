package com.example.runnable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserLogin extends AppCompatActivity {


    public EditText editEmail, editPassword;
   public TextView textEmail, textPassword,textError;
    Button buttonEditPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        buttonEditPassword = findViewById(R.id.buttonEditPassword);
        textError = findViewById(R.id.textError);

    }


    Runnable loginTask = new Runnable() {
        @Override
        public void run() {
            LoginValidator.validatePasswordLenght(editPassword.getText().toString());
            runOnUiThread(new Runnable() { @Override  public void run() {
                textError.setText(LoginValidator.error);
                LoginValidator.error = "" ;
            } });

//            LoginValidator.validatePassword(editPassword.getText().toString());
//            runOnUiThread(new Runnable() { @Override  public void run() {
//                textError.setText(LoginValidator.error);
//                LoginValidator.error = "" ;
//            } });

        }
    };

    public void execute(View view) {

        Thread runOnUiThread = new Thread(loginTask);
        runOnUiThread.start();

    }


}
