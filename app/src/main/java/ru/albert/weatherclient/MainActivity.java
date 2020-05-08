package ru.albert.weatherclient;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        citySearch.inicialyze();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mi = menu.add(0, 1, 0, "Настройки");
        mi.setIntent(new Intent(this, PrefActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
