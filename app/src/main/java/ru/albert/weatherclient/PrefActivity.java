package ru.albert.weatherclient;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class PrefActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        String[] cityes = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань", "Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа", "Красноярск", "Воронеж", "Пермь", "Волгоград"};
        InstantAutoComplete autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        List<String> cityesList = Arrays.asList(cityes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cityesList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.WHITE);
        TextView view = findViewById(R.id.textView10);
        view.setTextColor(Color.WHITE);
        Activity activity = this;
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                MainActivity.weatherView.setText(" ");
                MainActivity.weatherView1.setText(" ");
                MainActivity.weatherView2.setText(" ");
                MainActivity.weatherView3.setText(" ");
                MainActivity.weatherView4.setText(" ");
                MainActivity.weatherView5.setText(" ");
                MainActivity.weatherView6.setText(" ");
                MainActivity.weatherView7.setText(" ");
                MainActivity.weatherView8.setText(" ");
                MainActivity.date.setText(" ");
                MainActivity.textView.setText(" ");
                MainActivity.dateAndCity.setText(" ");
                MainActivity.view.setText(" ");
                Object item = parent.getItemAtPosition(position);
                weatherGetter.getWeather(MainActivity.textView, item.toString());
                SharedPreferences.Editor ed = MainActivity.sPref.edit();
                ed.putBoolean("isFirst", false);
                ed.putString("cityName", item.toString());
                ed.commit();
                activity.finish();
            }
        });
    }
}