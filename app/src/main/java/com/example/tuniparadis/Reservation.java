package com.example.tuniparadis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        TextView nom=findViewById(R.id.recuperer_nom_hotel);
        Bundle extras=getIntent().getExtras();
        String s  = extras.getString("nom");
        nom.setText(s);
    }
}
