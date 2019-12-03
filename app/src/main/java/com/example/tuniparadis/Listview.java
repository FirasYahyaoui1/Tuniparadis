package com.example.tuniparadis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Listview extends AppCompatActivity {
    private static final int CODE_DE_MON_ACTIVITE = 1;
    private final String EXTRA_TITLE = "title";
    private final String EXTRA_PRIX = "lieu";
    private final String EXTRA_LIEU = "prix";


    private ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
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
        String [] prix=new String[]{"150","150","150","150","150","150"};

        // Icones (images) des items
        String[] icon = new String[]{
                String.valueOf(R.drawable.four),
                String.valueOf(R.drawable.four),
                String.valueOf(R.drawable.four),
                String.valueOf(R.drawable.four),
                String.valueOf(R.drawable.four),
                String.valueOf(R.drawable.four)};
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
                new String[]{"title", "lieu","prix", "icon"},
                new int[]{R.id.title, R.id.blasa,R.id.flous, R.id.icon});
        // Association de l’adapter à la liste
        maListViewPerso.setAdapter(adapter);



    }
}
