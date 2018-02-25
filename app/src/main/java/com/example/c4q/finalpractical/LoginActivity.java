package com.example.c4q.finalpractical;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by c4q on 2/25/18.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText fieldUsername, fieldPassword;
    private Button buttonSubmit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        init();


        //TODO save login to sharedpref
        //TODO check sharedpref before coming to login activity

    }

    public void init(){
        fieldUsername = findViewById(R.id.field_username);
        fieldPassword = findViewById(R.id.field_password);
        buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login(){
        String userInput = fieldUsername.getText().toString(), passInput = fieldPassword.getText().toString();
        if(userInput.equals("")|| passInput.equals("")){
            Toast.makeText(this, "Missing username or password",Toast.LENGTH_LONG).show();
        } else if(!noNameInPass(userInput, passInput)){
            Toast.makeText(this,"Password cannot contain username!", Toast.LENGTH_LONG).show();
        }
    }

    public boolean noNameInPass(String username, String password){
        for(int i = 0; i < password.length();i++){
            if(username.charAt(0) == password.charAt(i) && username.length()-1<password.length()-i){
                if(username.equals(password.substring(i,i+username.length()))){
                    return false;
                }
            }
        }
        return true;
    }
}
