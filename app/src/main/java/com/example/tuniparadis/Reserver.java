package com.example.tuniparadis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserver extends AppCompatActivity {
    TextView name;
    final String EXTRA_TITLE = "title";
    String title = "";
    TextView date_deb,date_dep;
    private DatePickerDialog.OnDateSetListener mDateSetListener,mDateSetListener1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);
        //recuperer chaque nom de hotel de la liste
        name = findViewById(R.id.nom_hotell);
        Bundle oBundle = this.getIntent().getExtras();
        if (oBundle != null && oBundle.containsKey("title")) {
            title = getIntent().getStringExtra(EXTRA_TITLE);
        } else {
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
        Spinner spinner_enfant = findViewById(R.id.enfant);
        ArrayAdapter<CharSequence> adapter_enfant = ArrayAdapter.createFromResource(this, R.array.Enfants, android.R.layout.simple_spinner_item);
        adapter_enfant.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_enfant.setAdapter(adapter_enfant);
        //check nbr chambre
        Spinner spinner_chambre = findViewById(R.id.Chambre);
        ArrayAdapter<CharSequence> adapter_chambre = ArrayAdapter.createFromResource(this, R.array.Chambres, android.R.layout.simple_spinner_item);
        adapter_chambre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_chambre.setAdapter(adapter_chambre);
        //configuration du buttton reserver
        findViewById(R.id.btn_reserver).setOnClickListener(new View.OnClickListener() {
            View view = findViewById(R.id.enfant);

            @Override
            public void onClick(View v) {
                Snackbar.make(view, "reservation envoyéé", Snackbar.LENGTH_LONG).show();

            }
        });

        date_deb = findViewById(R.id.date_arrivé);
        date_deb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.YEAR);
                int day = calendar.get(Calendar.YEAR);
                DatePickerDialog dialog1 = new DatePickerDialog(Reserver.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year, month, day);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("", "onDateSet: mm/dd/yy " + day + "/" + month + "/" + year);
                String date = month + "/" + day + "/" + year;
                date_deb.setText(date);

            }
        };

        date_dep = findViewById(R.id.Date_départ);
        date_dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.YEAR);
                int day = calendar.get(Calendar.YEAR);
                DatePickerDialog dialog = new DatePickerDialog(Reserver.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("", "onDateSet: mm/dd/yy " + day + "/" + month + "/" + year);
                String date = month + "/" + day + "/" + year;
                date_dep.setText(date);
            }
        };


    }
}
