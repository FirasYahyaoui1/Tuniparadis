package com.example.tuniparadis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserver extends AppCompatActivity {
    TextView name;
    final String EXTRA_TITLE = "title";
    String title = "";
    TextView date_deb, date_dep;
    private DatePickerDialog.OnDateSetListener mDateSetListener, mDateSetListener1;
    private ReserverEntity reserverEntity;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);
        //bAR MENU

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("", "onDateSet: mm/dd/yy " + day + "/" + month + "/" + year);
                String date = month + "/" + day + "/" + year;
                date_dep.setText(date);
            }
        };

        findViewById(R.id.btn_prix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date dateAvant = sdf.parse(date_deb.getText().toString(), new ParsePosition(1));
                Date dateApres = sdf.parse(date_dep.getText().toString(), new ParsePosition(1));
                long diff = dateApres.getTime() - dateAvant.getTime();
                float res = (diff / (1000 * 60 * 60 * 24));
                Toast.makeText(Reserver.this, "durre" + res, Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Reserver.this);
                builder1.setMessage("le prix de votre vacances est :" + res * 150);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        findViewById(R.id.btn_reserver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView date=findViewById(R.id.date_arrivé);
                TextView datedep=findViewById(R.id.Date_départ);
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                String email=currentUser.getEmail();
                String datarr=date.getText().toString();
                String datdep=date_dep.getText().toString();
                String value=datarr+"==>"+datdep;
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Reserver");
                reserverEntity =new ReserverEntity(value,email);
                myRef.setValue(reserverEntity);
        Intent i=new Intent(Reserver.this,Confirmation.class);
        startActivity(i);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Français:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.Anglais:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                return  true;
            case R.id.se_décoonecter:
                finish();
                Intent intent=new  Intent(Reserver.this,Login.class);
                startActivity(intent);
                return true;
            case R.id.action_home:
                Intent i=new  Intent(Reserver.this,MainActivity.class);
                startActivity(i);




        }
        return super.onOptionsItemSelected(item);
    }
}
