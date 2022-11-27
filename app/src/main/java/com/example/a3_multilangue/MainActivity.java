package com.example.a3_multilangue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.textView);
        registerForContextMenu(txtView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lang_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.kab_lang:
                setLang("kab");
                break;
            case R.id.ar_lang:
                setLang("ar");
                break;
            case R.id.fr_lang:
                setLang("fr");
                break;
            case R.id.en_lang:
                setLang("en");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setLang(String lang){
        Locale myLocale = new Locale(lang);//créer un locale(lang est le code de la langue)
        Locale.setDefault(myLocale);// choisir locale par défaut
        Configuration config = new Configuration();// récupérer la configuration
        config.locale = myLocale; // choisir la configuration locale
        // Mettre à jour la configuration
        Resources ressources=this.getResources();
        ressources.updateConfiguration(config, ressources.getDisplayMetrics());

        // Mettre à jour le texte selon la nouvelle option
        TextView txtView = findViewById(R.id.textView),
            srcView =findViewById(R.id.sourceView);
        setTitle(R.string.app_name);
        txtView.setText(R.string.text);
        srcView.setText(R.string.sourceName);

        // refresh the activity
//        Intent i = new Intent(MainActivity.this, MainActivity.class);
//        finish();
//        overridePendingTransition(0, 0);
//        startActivity(i);
//        overridePendingTransition(0, 0);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.style_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TextView txtView = findViewById(R.id.textView);
        switch (item.getItemId()){
            case R.id.style1:
                txtView.setTextAppearance(R.style.style1);
                break;
            case R.id.style2:
                txtView.setTextAppearance(R.style.style2);
                break;
            case R.id.style3:
                txtView.setTextAppearance(R.style.style3);
                break;
        }
        return super.onContextItemSelected(item);
    }
}