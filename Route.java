import java.util.*;

public class Route {
	private String airlineCode;
	private String airlineID;
	private String destinationAirportCode;
	private int stops;
	static HashMap<String, ArrayList<Route>> routesMap = new HashMap<>(); 

	public Route(String airlineCode, String airlineID, String destinationAirportCode, int stops) {
		this.airlineCode = airlineCode;
		this.airlineID = airlineID;
		this.destinationAirportCode = destinationAirportCode;
		this.stops = stops;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	@Override
	public boolean equals(Object obj) {
		Route route = (Route) obj;
        if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		return stops == route.stops && Objects.equals(airlineCode, route.airlineCode) &&
        Objects.equals(airlineID, route.airlineID) && Objects.equals(destinationAirportCode, route.destinationAirportCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airlineCode, airlineID, destinationAirportCode, stops);
	}

	@Override
	public String toString() {
		return "Route{" + "airlineCode='" + airlineCode + '\'' + ", airlineID='" + airlineID + '\'' +
        ", destinationAirportCode='" + destinationAirportCode + '\'' + ", stops=" + stops + '}';
	}
}