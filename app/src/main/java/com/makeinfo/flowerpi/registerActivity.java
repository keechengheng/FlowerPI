package com.makeinfo.flowerpi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;




/**
 * Created by keechengheng on 20/7/15.
 */
public class registerActivity extends ActionBarActivity{
    Button register;
    EditText nameET;
    EditText emailET;
    EditText pwET;
    EditText cpwET;
    ProgressBar pbar;
    String API = "http://apilumi.azurewebsites.net/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        register = (Button) findViewById(R.id.regBtn);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);
        nameET = (EditText) findViewById(R.id.nameTxt);
        emailET = (EditText) findViewById(R.id.emailTxt);
        pwET = (EditText) findViewById(R.id.PwTxt);
        cpwET = (EditText) findViewById(R.id.cPwTxt);

        register.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                pbar.setVisibility(View.VISIBLE);





            }
        });

    }




}
