package com.salmaabdulhai.cse486fall2020quiz2;


import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PrefConfig {

    private static final String LIST_KEY = "list_key100";
    private static final String LIST_KEY1 = "list_key1100";

    public static void writeListInPref(Context context, List<TaskModel> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static List<TaskModel> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<TaskModel>>() {}.getType();
        List<TaskModel> list = gson.fromJson(jsonString, type);
        return list;
    }
public static void writeListInPref1 (Context context, ArrayList<String> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY1, jsonString);
        editor.apply();
    }

    public static ArrayList<String> readListFromPref1 (Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY1, "");

        Gson gson = new Gson();
        //Type type = new TypeToken<List<String>>() {}.getType();
        ArrayList<String> list = gson.fromJson(jsonString, new TypeToken<ArrayList<String>>() {
        }.getType());
        return list;
    }

}
