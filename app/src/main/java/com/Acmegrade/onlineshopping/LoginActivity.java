package com.Acmegrade.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView register_text;
    TextInputLayout email_lay,pass_lay;
    EditText email_log,pass_log;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.LOGIN);

        register_text=findViewById(R.id.registerText);

        email_lay=findViewById(R.id.textInputEmail);
        pass_lay=findViewById(R.id.textInputPassword);

        email_log=findViewById(R.id.editTextEmail);
        pass_log=findViewById(R.id.editTextPassword);

        inputValidation = new InputValidation(LoginActivity.this);
        databaseHelper = new DatabaseHelper(LoginActivity.this);

        user = new User();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputValidation.isInputEditTextEmail(email_log, email_lay, "Enter Valid Email"))
                {
                    return;
                }

                if(!inputValidation.isInputEditTextFilled(pass_log, pass_lay, "Enter Password"))
                {
                    return;
                }

                if(databaseHelper.checkUser(email_log.getText().toString().trim(), pass_log.getText().toString().trim()))
                {

                    //The name attached to the given email will return
                    String NAME = databaseHelper.getNameFromEmail(email_log.getText().toString().trim());

                    Intent accountsIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    accountsIntent.putExtra("Name",NAME);
                    accountsIntent.putExtra("Email",email_log.getText().toString().trim());

                    startActivity(accountsIntent);
                }

                else
                {
                    //Toast to show success message that record is wrong
                    Toast.makeText(LoginActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(regIntent);
            }
        });

    }
}