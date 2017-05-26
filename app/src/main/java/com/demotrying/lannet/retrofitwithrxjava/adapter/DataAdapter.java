package com.demotrying.lannet.retrofitwithrxjava.adapter;


import android.content.Context;
import android.util.Log;

import com.demotrying.lannet.retrofitwithrxjava.model.Fixtures;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DataAdapter implements JsonDeserializer<List<Fixtures>> {
    Calendar caldate;


    public DataAdapter(Context applicationContext) {

    }

    @Override
    public List<Fixtures> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = json.getAsJsonObject().getAsJsonArray("fixtures");
int a=array.size();
        List<Fixtures> list = new ArrayList<>();
        for (JsonElement element : array){
            extractFixture(list,element);
        }

        return list;
    }

    private void extractFixture(List<Fixtures> list, JsonElement element) {
        JsonObject j = element.getAsJsonObject();
String goalsAwayTeam="0",goalsHomeTeam="0";
        String  matchday =j.get("matchday").getAsString();
        String  homeTeamName = j.get("homeTeamName").getAsString();
        String  awayTeamName = j.get("awayTeamName").getAsString();
        String  status = j.get("status").getAsString();
       JsonObject j1=j.getAsJsonObject("result");
        try {

            goalsAwayTeam = j1.get("goalsAwayTeam").getAsString();
            goalsHomeTeam = j1.get("goalsHomeTeam").getAsString();

        }catch (Exception e){
            e.printStackTrace();
        }

        list.add(new Fixtures(matchday,homeTeamName,awayTeamName,status,goalsAwayTeam,goalsHomeTeam));
    }

}


