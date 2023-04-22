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

public class MainActivity extends AppCompatActivity {

    TextInputLayout name_lay,email_lay,pass_lay,confirmPass_lay;
    EditText name_reg,email_reg,pass_reg, confirmPass_reg;
    Button register;
    TextView already_ac;

    User user;
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_lay = findViewById(R.id.textInputName);
        email_lay = findViewById(R.id.textInputEmail);
        pass_lay = findViewById(R.id.textInputPassword);
        confirmPass_lay = findViewById(R.id.textInputConfirmPassword);

        name_reg = findViewById(R.id.editTextName);
        email_reg = findViewById(R.id.editTextEmail);
        pass_reg = findViewById(R.id.editTextPassword);
        confirmPass_reg = findViewById(R.id.editTextConfirmPassword);

        register = findViewById(R.id.REGISTER);
        already_ac = findViewById(R.id.loginText);

        inputValidation = new InputValidation(MainActivity.this);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        user = new User();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if in isInputEditTextFilled produce error then it return false and to return user...we make if condition true...that's why we use not operator(!)
                //Same if isInputEditTextFilled return true then here because of not operator(!) if condition (false and true) = false...so,now we check second if condition
                if(!inputValidation.isInputEditTextFilled(name_reg, name_lay, "Enter Full Name"))
                {
                    return;
                }

                //for email two validation...we combine both validation in isInputEditTextEmail() method
//                if(!inputValidation.isInputEditTextFilled(email_reg, email_lay, "Enter Valid Email"))
//                {
//                    return;
//                }

                if(!inputValidation.isInputEditTextEmail(email_reg, email_lay, "Enter Valid Email"))
                {
                    return;
                }

                if(!inputValidation.isInputEditTextFilled(pass_reg, pass_lay, "Enter Password"))
                {
                    return;
                }

                if(!inputValidation.isInputEditTextMatches(pass_reg, confirmPass_reg, confirmPass_lay, "Password Does Not Matches"))
                {
                    return;
                }

                if(!databaseHelper.checkUser(email_reg.getText().toString().trim()))
                {
                    user.setName(name_reg.getText().toString().trim());
                    user.setEmail(email_reg.getText().toString().trim());
                    user.setPassword(pass_reg.getText().toString().trim());
                    databaseHelper.addUser(user);

                    //Toast to show success message that record saved successfully
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

                else
                {
                    //2nd way to show Toast message by string instead of 1st way in which we directly write Toast message
                    //Toast to show error message that record already exists
                    //we make this string error_email_exists in strings.xml file

                    //If you not write getString() then it is ok....there are no any error or issue
                    //Toast.makeText(MainActivity.this, R.string.error_email_exists, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, getString(R.string.error_email_exists), Toast.LENGTH_SHORT).show();
                }
            }
        });

        already_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}