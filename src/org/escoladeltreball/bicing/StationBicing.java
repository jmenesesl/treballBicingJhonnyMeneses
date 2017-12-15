/**
 * 
 */
package org.escoladeltreball.bicing;

/**
 * @author iaw26068632
 *
 */
public class StationBicing {

	// Id de la estación
	private int id;
	// Tipo de estacion: BIKE
	private String type;
	// latitud
	private double latitude;
	// Longitud
	private double longitude;
	// nombre de calle
	private String streetName;
	// Numero de la direccion
	private String streetNumber;
	// Altitud
	private int altitude;
	// plazas de bicis
	private int slots;
	// Bicis disponibles actualmente
	private int bikes;
	// Estaciones cercanas
	private String nearbyStations;
	// Estado de la estación
	private String status;
	
	private double distance;

	
	//******************************* Constructor ****************************
	public StationBicing(int id, String type, double latitude, double longitude, String streetName, String streetNumber,
			int altitude, int slots, int bikes, String nearbyStations, String status) {
		
		this.id = id;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.altitude = altitude;
		this.slots = slots;
		this.bikes = bikes;
		this.nearbyStations = nearbyStations;
		this.status = status;
		this.distance = 0;
	}

	//******************************* Getter & Setter ****************************
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the altitude
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	/**
	 * @return the slots
	 */
	public int getSlots() {
		return slots;
	}

	/**
	 * @param slots the slots to set
	 */
	public void setSlots(int slots) {
		this.slots = slots;
	}

	/**
	 * @return the bikes
	 */
	public int getBikes() {
		return bikes;
	}

	/**
	 * @param bikes the bikes to set
	 */
	public void setBikes(int bikes) {
		this.bikes = bikes;
	}

	/**
	 * @return the nearbyStations
	 */
	public String getNearbyStations() {
		return nearbyStations;
	}

	/**
	 * @param nearbyStations the nearbyStations to set
	 */
	public void setNearbyStations(String nearbyStations) {
		this.nearbyStations = nearbyStations;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getDistance() {
		return distance;
	}

	/**
	 * @param status the status to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	//******************************* hashCode & Equals ****************************
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationBicing other = (StationBicing) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	//******************************* toString ****************************
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"StationBicing [id=%s, type=%s, latitude=%s, longitude=%s, streetName=%s, streetNumber=%s, altitude=%s, slots=%s, bikes=%s, nearbyStations=%s, status=%s]",
				id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStations,
				status);
	}
	
	

}
