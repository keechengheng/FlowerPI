package com.makeinfo.flowerpi;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.makeinfo.flowerpi.API.lumiapi;
import com.makeinfo.flowerpi.model.lumimodel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    Button click;
    TextView tv;
    EditText edit_user;
    EditText user;
    EditText pw;
    ProgressBar pbar;
    String API = "http://apilumi.azurewebsites.net/api";

    Button nextPage;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        edit_user = (EditText) findViewById(R.id.edit);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);

        nextPage = (Button) findViewById(R.id.nextPage);


        send = (Button) findViewById(R.id.send);
        user = (EditText) findViewById(R.id.userT);
        pw = (EditText) findViewById(R.id.pwT);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = edit_user.getText().toString();

                pbar.setVisibility(View.VISIBLE);

                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(API).build();
                lumiapi lumi = restAdapter.create(lumiapi.class);

                lumi.getFeed(login, new Callback<lumimodel>() {
                    @Override
                    public void success(lumimodel lumimodel, Response response) {
                        tv.setText("Lumi UserName :" + lumimodel.getUserID() + "\nPassword :" + lumimodel.getPassword());
                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        tv.setText(error.getMessage());
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, registerActivity.class);
                startActivity(i);

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String use = user.getText().toString();
                String pass = pw.getText().toString();

                lumimodel reg = new lumimodel();


                pbar.setVisibility(View.VISIBLE);

                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(API).build();
                lumiapi lumi = restAdapter.create(lumiapi.class);

                lumi.sendFeed(reg, new Callback<lumimodel>() {
                    @Override
                    public void success(lumimodel lumimodel, Response response) {
                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });



            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
