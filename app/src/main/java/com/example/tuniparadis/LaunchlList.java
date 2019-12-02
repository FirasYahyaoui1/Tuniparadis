package com.example.tuniparadis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LaunchlList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_recycle);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdaptater();
        recyclerView.setAdapter(adapter);

//check CustumRecyclerVieww on e-formation ;)
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        final TextView nom=findViewById(R.id.nom_hotel);
        TextView place=findViewById(R.id.lieu);
        TextView prix=findViewById(R.id.prix);
        final String nom_hotel=nom.getText().toString();
        final String lieu=place.getText().toString();
        final String prix_hotel=prix.getText().toString();

        findViewById(R.id.btn_reserver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Reservation.class);
                intent.putExtra("nom",nom.getText().toString());

                startActivity(intent);

            }
        });

    }*/
}
