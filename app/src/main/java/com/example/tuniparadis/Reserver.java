package com.example.tuniparadis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Reserver extends AppCompatActivity {
    TextView name;
    final String EXTRA_TITLE = "title";
    String title = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);
        name=findViewById(R.id.nom_hotell);
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






        //check nbr adulte
        Spinner spinner = findViewById(R.id.Adulte);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Adultes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //check nbr enfants
        Spinner spinner_enfant=findViewById(R.id.enfant);
        ArrayAdapter<CharSequence> adapter_enfant=ArrayAdapter.createFromResource(this,R.array.Enfants,android.R.layout.simple_spinner_item);
        adapter_enfant.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_enfant.setAdapter(adapter_enfant);
        //check nbr chambre
        Spinner spinner_chambre=findViewById(R.id.Chambre);
        ArrayAdapter<CharSequence> adapter_chambre=ArrayAdapter.createFromResource(this,R.array.Chambres,android.R.layout.simple_spinner_item);
        adapter_chambre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_chambre.setAdapter(adapter_chambre);
        //configuration du buttton reserver
        findViewById(R.id.btn_reserver).setOnClickListener(new View.OnClickListener() {
            View view=findViewById(R.id.enfant);

            @Override
            public void onClick(View v) {
                Snackbar.make(view,"reservation envoyéé",Snackbar.LENGTH_LONG).show();

            }
        });

    }
}
