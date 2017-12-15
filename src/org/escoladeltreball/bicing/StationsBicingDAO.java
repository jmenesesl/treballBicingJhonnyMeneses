package org.escoladeltreball.bicing;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class StationsBicingDAO {

	JsonArray stations;
	ArrayList<StationBicing> listStations = new ArrayList<StationBicing>();

	/**
	 * @param stations
	 * @throws FileNotFoundException 
	 */
	public StationsBicingDAO() throws FileNotFoundException {
		this.stations = ReadFileJson.getJson();
		listStations = (ArrayList<StationBicing>) this.getStations(); // Inicio el arraylist de stations
	}

	/**
	 * @param stations the stations to set
	 */
	public void setStations(JsonArray stations) {
		this.stations = stations;
		
	}
	
	public List<StationBicing> getStations() {
		
		List<StationBicing> listStations = new ArrayList<StationBicing>();
		for (int i = 0; i < stations.getAsJsonArray().size(); i++) {
			JsonObject objeto = stations.getAsJsonArray().get(i).getAsJsonObject();
			
			int id = objeto.get("id").getAsInt();
			String type = objeto.get("type").getAsString();
			double latitude = objeto.get("latitude").getAsDouble();
			double longitude = objeto.get("longitude").getAsDouble();
			String streetName = objeto.get("streetName").getAsString();
			String streetNumber = objeto.get("streetNumber").getAsString();
			int altitude = objeto.get("altitude").getAsInt();
			int slots = objeto.get("slots").getAsInt();
			int bikes = objeto.get("bikes").getAsInt();
			String nearbyStations = objeto.getAsJsonObject().get("nearbyStations").getAsString();
			String status = objeto.getAsJsonObject().get("status").getAsString();
			
			StationBicing st = new StationBicing(id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStations, status);
			
			listStations.add(st);
		}
		
		return listStations;
	}
	
	public List<StationBicing> stationsUpThanLatitude(double latitude) {
		List<StationBicing> stationsUpThan = new ArrayList<StationBicing>();
		for(StationBicing st : this.listStations) {
			if(st.getLatitude() >= latitude) {
				stationsUpThan.add(st);
			}
		}
		return stationsUpThan;
	}
	public List<StationBicing> stationsUpThanAltitude(double altitude) {
		List<StationBicing> stationsUpThan = new ArrayList<StationBicing>();
		for(StationBicing st : this.listStations) {
			if(st.getAltitude() > altitude) {
				stationsUpThan.add(st);
			}
		}
		return stationsUpThan;
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        //double radioTierra = 3958.75;//en millas  
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }  
	
}
