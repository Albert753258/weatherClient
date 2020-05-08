package ru.albert.weatherclient;

import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class weatherGetter {
    public static void getWeather(TextView view, String url){
        class InternetDownloader extends AsyncTask<Void, Void, Void> {
            String title;
            @Override
            protected Void doInBackground(Void... params) {
                Document doc = null;
                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (doc!=null) {
                    title = doc.body().getElementById("wrap").getElementById("pagewrapper").getElementsByClass("content").get(0).getElementsByClass("content_2col").get(0).getElementById("webslice_content").getElementsByClass("entry-content").get(0).getElementsByClass("t_cond").get(0).getElementsByClass("c1").get(0).getElementsByClass("left").get(0).getElementsByClass("txt-xxlarge").text();
                }
                else{
                    title = "Ошибка";
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                view.setText(title);
            }
        }
        InternetDownloader downloader = new InternetDownloader();
        downloader.execute();
    }
}
