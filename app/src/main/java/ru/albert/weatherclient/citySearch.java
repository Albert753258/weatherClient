package ru.albert.weatherclient;

import java.util.HashMap;

public class citySearch {
    static HashMap<String, String> map = new HashMap<>();
    public static void inicialyze(){
        map.put("Москва", "https://www.foreca.ru/Russia/Moskva");
        map.put("Санкт-Петербург", "https://www.foreca.ru/Russia/Saint_Petersburg");
        map.put("Новосибирск", "https://www.foreca.ru/Russia/Novosibirsk");
        map.put("Екатеринбург", "https://www.foreca.ru/Russia/Yekaterinburg");
        map.put("Нижний Новгород", "https://www.foreca.ru/Russia/Nizhniy_Novgorod");
        map.put("Казань", "https://www.foreca.ru/Russia/Kazan'");
        map.put("Челябинск", "https://www.foreca.ru/Russia/Chelyabinsk");
        map.put("Омск", "https://www.foreca.ru/Russia/Omsk");
        map.put("Самара", "https://www.foreca.ru/Russia/Samara");
        map.put("Ростов-на-Дону", "https://www.foreca.ru/Russia/Rostov-na-Donu");
    }
    public static String getURL(String cityName){
        return map.get(cityName);
    }
}
