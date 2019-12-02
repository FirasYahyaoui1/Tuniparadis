package com.example.tuniparadis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.Normalizer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Formulaire extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btn_enregistrer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verif()==false){
                    Toast.makeText(Formulaire.this, R.string.verif, Toast.LENGTH_LONG).show();
                }
                else
                creeCompte();


            }
        });

    }

    public void creeCompte() {

        EditText mail = findViewById(R.id.user_emailform);
        String email = mail.getText().toString();
        EditText pwd = findViewById(R.id.user_passwordform);
        String password = pwd.getText().toString();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Formulaire.this, LaunchlList.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Formulaire.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    public boolean verif() {
        EditText fName = findViewById(R.id.user);
        EditText lName = findViewById(R.id.Prénom);
        EditText Email = findViewById(R.id.user_emailform);
        EditText country = findViewById(R.id.ville);
        EditText number = findViewById(R.id.telephone);
        EditText pwd = findViewById(R.id.user_passwordform);
        EditText Cpwd = findViewById(R.id.confirm_pass);
        String nom = fName.getText().toString();
        String prenom = lName.getText().toString();
        String email = Email.getText().toString();
        String ville = country.getText().toString();
        String numero = number.getText().toString();
        String password = pwd.getText().toString();
        String Cpassword = Cpwd.getText().toString();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || ville.isEmpty() || numero.isEmpty() || password.isEmpty() || Cpassword.isEmpty() || password != Cpassword) {
            return false;
        } else


            return true;


    }
}