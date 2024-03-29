package com.example.tuniparadis;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Confirmation extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);
       // getUser email
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
       //creation de msg avec parametre de firebase
        String message="On vous contacte cher client sur votre email=";
        String email=currentUser.getEmail();
        msg=findViewById(R.id.Confirmation);
        msg.setText(message+email);
        //bAR MENU

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Français:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.Anglais:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.se_décoonecter:
                onDestroy();
                Intent intent=new  Intent(Confirmation.this,Login.class);
                startActivity(intent);
                return true;
            case R.id.action_home:
                Intent i=new  Intent(Confirmation.this,MainActivity.class);
                startActivity(i);



        }
        return super.onOptionsItemSelected(item);
    }
}
