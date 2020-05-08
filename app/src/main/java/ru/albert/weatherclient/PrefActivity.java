package ru.albert.weatherclient;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class PrefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        String[] cityes = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань", "Челябинск", "Омск", "Самара", "Ростов-на-Дону"};
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        List<String> cityesList = Arrays.asList(cityes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, cityesList);
        autoCompleteTextView.setAdapter(adapter);
    }
    public void saveButtonClicked(View view) {
        AutoCompleteTextView cityView = findViewById(R.id.autoCompleteTextView);
        weatherGetter.getWeather(MainActivity.textView, citySearch.getURL(cityView.getText().toString()));
    }
}