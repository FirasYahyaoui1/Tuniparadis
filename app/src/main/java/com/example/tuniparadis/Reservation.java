package com.example.tuniparadis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reservation extends AppCompatActivity {
    TextView name;
    final String EXTRA_TITLE = "title";
    String title = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        //EditText  editText= findViewById(R.id.editText6);
        //editText.setText(Calendar.getInstance().getTime().toString());
        name=findViewById(R.id.recuperer_nom_hotel);
        Bundle oBundle=this.getIntent().getExtras();
        if (oBundle != null && oBundle.containsKey("title")){
            title=getIntent().getStringExtra(EXTRA_TITLE);
        }
        else
        {
            // Erreur
            title = "Error";
        }

     name.setText(title);
    }
}
