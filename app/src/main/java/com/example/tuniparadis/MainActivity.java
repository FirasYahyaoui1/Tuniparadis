package com.example.tuniparadis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final int CODE_DE_MON_ACTIVITE = 1;
    private final String EXTRA_TITLE = "title";
    private final String EXTRA_PRIX = "lieu";
    private final String EXTRA_LIEU = "prix";


    private ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bAR MENU

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ListView
        // Récupération de la "ListView" créée dans le fichier activity_main.xml
        maListViewPerso = findViewById(R.id.listviewperso);

        // Création de la "ArrayList" qui nous permettra de remplir la "ListView"
        ArrayList<HashMap<String, String>> listItems = new ArrayList<>();

        // On déclare la "HashMap" qui contiendra les informations pour un item
        HashMap<String, String> item;

        // Titre des items
        String[] title = new String[]{
                getString(R.string.n_hotel),
                getString(R.string.no_hotel),
                getString(R.string.nom_hotel),
                getString(R.string.nomhotel),
                getString(R.string.nom_hote),
                getString(R.string.nomhotels)};
        // lieu des items
        String[] lieu = new String[]{
                getString(R.string.Tabarka),
                getString(R.string.Hammamet),
                getString(R.string.Djerba),
                getString(R.string.Tunis),
                getString(R.string.Gammarth),
                getString(R.string.Tunis)};
        //prix des item
        String[] prix = new String[]{"150", "150", "150", "150", "150", "150"};
        
        // Icones (images) des items
        String[] icon = new String[]{
                String.valueOf(R.drawable.laico),
                String.valueOf(R.drawable.hamm),
                String.valueOf(R.drawable.movenpick),
                String.valueOf(R.drawable.gamarth),
                String.valueOf(R.drawable.movenpic),
                String.valueOf(R.drawable.laico)};
        // Creation des items de la liste
        for (int i = 0; i < title.length; i++) {
            item = new HashMap<>();
            // Titre
            item.put("title", title[i]);
            // lieu
            item.put("lieu", lieu[i]);
            //prix
            item.put("prix", prix[i]);
            // Icone
            item.put("icon", icon[i]);
            listItems.add(item);
        }

        // Creation d l’Adapter
        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItems,
                R.layout.activity_listview,
                new String[]{"title", "lieu", "prix", "icon"},
                new int[]{R.id.title, R.id.blasa, R.id.flous, R.id.icon});
        // Association de l’adapter à la liste
        maListViewPerso.setAdapter(adapter);
        // Interaction avec les items de la liste
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> item = (HashMap) maListViewPerso.getItemAtPosition(position);

                // On crée un objet Bundle, c'est ce qui va nous permettre d'envoyer des données
                // à l'autre activité
                Bundle oBundle = new Bundle();

                // Cela fonctionne plus ou moins comme une HashMap,
                // on entre une clef et sa valeur en face
                oBundle.putString(EXTRA_TITLE, item.get("title"));
                oBundle.putString(EXTRA_LIEU, item.get("lieu"));
                oBundle.putString(EXTRA_PRIX, item.get("prix"));

                // On crée l'Intent qui va nous permettre d'afficher l'autre activité
                Intent intent = new Intent(MainActivity.this, Reserver.class);

                // On affecte à l'Intent le Bundle que l'on a créé
                intent.putExtras(oBundle);
                // On démarre l'autre activité
                startActivityForResult(intent, CODE_DE_MON_ACTIVITE);
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
                onDestroy();
                Intent intent=new  Intent(MainActivity.this,Login.class);
                startActivity(intent);
                return true;



        }
        return super.onOptionsItemSelected(item);
    }

}

