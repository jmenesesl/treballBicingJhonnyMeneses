package org.escoladeltreball.bicing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ReadFileJson {

	public static JsonArray getJson() throws FileNotFoundException {
		ArrayList<StationBicing> estaciones = new ArrayList<StationBicing>();

		InputStreamReader in = new InputStreamReader(new FileInputStream("bicing.json"));
	    JsonReader jreader = new JsonReader(in);
	    
	    Gson gson = new Gson();
	    
	    JsonParser jsonParser = new JsonParser();
	    JsonElement element = jsonParser.parse(jreader);
//	    System.out.println("Element: " + element);
//	    System.out.println();
	    JsonObject obj = element.getAsJsonObject();  
//	    System.out.println("obj: " + obj);
	    JsonArray jsonArray = obj.get("stations").getAsJsonArray();
//	    System.out.println("jsonArray" + jsonArray);
//	    System.out.println(jsonArray.get(0).getAsJsonObject().get("streetName").getAsString());
	    
		return jsonArray;
	}
}
