package com.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonManager {

    public static JsonArray getFieldOrNAa(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            return value.getAsJsonArray();
        } else {
            return null;
        }
    }

    public static String getFieldOrNA(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            return value.getAsString();
        } else {
            return "N/A";
        }
    }

    public static int getItemlength(int Number) {
        int lenght = (JsonManager.getFieldOrNA("Value" + Number,
                folder.readGame("/Counter Files\\settings.txt"))).length();
        return lenght;
    }

    public static JsonElement getObjectNumX(int num, JsonArray array) {
        JsonElement value = array.get(num);
        if (value != null) {
            return value;
        } else {
            return null;
        }
    }

    public static JsonObject StringToJsonObject(String string) {
        return JsonParser.parseString(string).getAsJsonObject();
    }

}
