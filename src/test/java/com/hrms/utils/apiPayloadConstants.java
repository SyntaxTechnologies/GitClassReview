package com.hrms.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class apiPayloadConstants {

    public static String createEmployeeBody(){


        File input=new File("C:/Users/IT USER/Desktop/cucumber/CucumberFrameWorkBatch8/src/test/resources/JsonData/createUser.json");
        JsonObject CreateUserData=null;
        try {
            //parsing the input file
            JsonElement fileElement= JsonParser.parseReader(new FileReader(input));
            CreateUserData = fileElement.getAsJsonObject();
        }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  CreateUserData.toString();
    }
}
