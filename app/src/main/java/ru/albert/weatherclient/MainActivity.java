package ru.albert.weatherclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static SharedPreferences sPref;
    public static TextView textView;
    public static TextView dateAndCity;
    public static TextView weatherView;
    public static TextView weatherView1;
    public static TextView weatherView2;
    public static TextView weatherView3;
    public static TextView weatherView4;
    public static TextView weatherView5;
    public static String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citySearch.inicialyze();
        textView = findViewById(R.id.textView);
        dateAndCity = findViewById(R.id.dateAndCity);
        weatherView = findViewById(R.id.weather);
        weatherView1 = findViewById(R.id.weather1);
        weatherView2= findViewById(R.id.weather2);
        weatherView3 = findViewById(R.id.weather3);
        weatherView4 = findViewById(R.id.weather4);
        weatherView5 = findViewById(R.id.weather5);
        dateAndCity.setTextColor(Color.WHITE);
        weatherView1.setTextColor(Color.WHITE);
        weatherView2.setTextColor(Color.WHITE);
        weatherView3.setTextColor(Color.WHITE);
        weatherView4.setTextColor(Color.WHITE);
        weatherView5.setTextColor(Color.WHITE);
        weatherView.setTextColor(Color.WHITE);
        textView.setTextColor(Color.WHITE);
        TextView view = findViewById(R.id.textView2);
        view.setTextColor(Color.WHITE);
        sPref = getSharedPreferences("prefs", MODE_PRIVATE);
        if(isFirst()){
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
        }
        cityName = cityName();
        String url = citySearch.getURL(cityName);
        weatherGetter.getWeather(MainActivity.textView, cityName);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mi = menu.add(0, 1, 0, "Настройки");
        mi.setIntent(new Intent(this, PrefActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
    public static boolean isFirst(){
        return sPref.getBoolean("isFirst", true);
    }
    public static String cityName(){
        String str = sPref.getString("cityName", "Казань");
        return str;
    }
}
