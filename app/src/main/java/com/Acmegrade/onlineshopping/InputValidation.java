package com.Acmegrade.onlineshopping;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {

    private Context context;

    public InputValidation(Context context)
    {
        this.context = context;
    }

    //You give any name method...here we give isInputEditTextFilled
    //return false is used to indicate that a function or method has finished executing and that the outcome was not successful. The false value is typically used as a return value when a function or method encounters an error or exception
    public boolean isInputEditTextFilled(EditText textInputEditText, TextInputLayout textInputLayout, String message)
    {
        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty())
        {
            textInputLayout.setError(message);
            //hideKeyboardFrom(textInputEditText);
            return false;
        }
        else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextEmail(EditText textInputEditText, TextInputLayout textInputLayout, String message)
    {
        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches())
        {
            textInputLayout.setError(message);
            return false;
        }
        else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    //isInputEditTextMatches
    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2, TextInputLayout textInputLayout, String message)
    {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();

        if(!value1.contentEquals(value2))
        {
            textInputLayout.setError(message);
            return false;
        }
        else
        {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
}
