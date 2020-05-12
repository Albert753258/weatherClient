package ru.albert.weatherclient;

import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class weatherGetter {
    public static void getWeather(TextView view, String cityName){
        String url = citySearch.getURL(cityName);
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        MainActivity.dateAndCity.setText(cityName);
        MainActivity.date.setText(dateFormat.format(currentDate));
        class InternetDownloader extends AsyncTask<Void, Void, Void> {
            String temperature;
            String weather;
            @Override
            protected Void doInBackground(Void... params) {
                Document doc = null;
                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (doc!=null) {
                    weather = doc.body().getElementById("wrap").getElementById("pagewrapper").getElementsByClass("content").get(0).getElementsByClass("content_2col").get(0).getElementById("webslice_content").getElementsByClass("entry-content").get(0).getElementsByClass("t_cond").get(0).getElementsByClass("c1").get(0).getElementsByClass("txt-tight").get(0).text();
                    temperature = doc.body().getElementById("wrap").getElementById("pagewrapper").getElementsByClass("content").get(0).getElementsByClass("content_2col").get(0).getElementById("webslice_content").getElementsByClass("entry-content").get(0).getElementsByClass("t_cond").get(0).getElementsByClass("c1").get(0).getElementsByClass("left").get(0).getElementsByClass("txt-xxlarge").text();
                }
                else{
                    temperature = "Ошибка";
                    weather = "Ошибка";
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                if(weather.equals("Ошибка")){
                    view.setText("Ошибка");
                    MainActivity.weatherView.setText("Ошибка");
                    MainActivity.weatherView1.setText("");
                    MainActivity.weatherView2.setText("");
                    MainActivity.weatherView3.setText("");
                    MainActivity.weatherView4.setText("");
                    MainActivity.weatherView5.setText("");
                    MainActivity.weatherView6.setText("");
                    MainActivity.weatherView7.setText("");
                    MainActivity.weatherView8.setText("");
                    return;
                }
                String arr[] = weatherAnalyzer(weather);
                MainActivity.weatherView.setText(arr[0]);
                MainActivity.weatherView1.setText(arr[1]);
                MainActivity.weatherView2.setText(arr[2]);
                MainActivity.weatherView3.setText(arr[3]);
                MainActivity.weatherView4.setText(arr[4]);
                MainActivity.weatherView5.setText(arr[5]);
                MainActivity.weatherView6.setText(arr[6]);
                MainActivity.weatherView7.setText(arr[7]);
                MainActivity.weatherView8.setText(arr[8]);
                super.onPostExecute(result);
                view.setText(temperature);
            }
        }
        InternetDownloader downloader = new InternetDownloader();
        downloader.execute();
        int o = 0;
    }
    public static String[] weatherAnalyzer(String weather){
        String str[] = new String[9];
        String arr[] = weather.split("Ощущается");
        str[0] = arr[0];
        String arr1[] = arr[1].split("Барометр");
        str[1] = "Ощущается" + arr1[0];
        String arr2[] = arr1[1].split("Точка");
        str[2] = "Давление" + arr2[0];
        String arr3[] = arr2[1].split("От. влажность");
        str[3] = "Точка" + arr3[0];
        String arr4[] = arr3[1].split("Видимость");
        str[4] = "От. влажность" + arr4[0];
        String arr5[] = arr4[1].split("Восход");
        str[5] = "Видимость" + arr5[0];
        String arr6[] = arr5[1].split("Закат");
        str[6] = "Восход" + arr6[0];
        String arr7[] = arr6[1].split("Долгота");
        str[7] = "Закат" + arr7[0];
        str[8] = "Долгота" + arr7[1];
        System.out.println(str);
        return str;
    }
}