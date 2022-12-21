import java.util.*;

public class Airport {
	private String airportID;
	private String name;
	private String city;
	private String country;
	private String IATACode;
	private String ICAOCode;


	static HashMap<String, String> airportCodeLocation = new HashMap<>();
	static HashMap<String, ArrayList<String>> cityAirportsMap = new HashMap<>();

	public Airport(String airportID, String name, String city, String country, String IATACode, String ICAOCode) {
		this.airportID = airportID;
		this.name = name;
		this.city = city;
		this.country = country;
		this.IATACode = IATACode;
		this.ICAOCode = ICAOCode;
	}

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIATACode() {
		return IATACode;
	}

	public void setIATACode(String IATACode) {
		this.IATACode = IATACode;
	}

	public String getICAOCode() {
		return ICAOCode;
	}

	public void setICAOCode(String ICAOCode) {
		this.ICAOCode = ICAOCode;
	}

	@Override
	public boolean equals(Object obj) {
        Airport airport = (Airport) obj;
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		return Objects.equals(airportID, airport.airportID) && Objects.equals(name, airport.name) &&
        Objects.equals(city, airport.city) && Objects.equals(country, airport.country) &&
        Objects.equals(IATACode, airport.IATACode) && Objects.equals(ICAOCode, airport.ICAOCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airportID, name, city, country, IATACode, ICAOCode);
	}

	@Override
	public String toString() {
		return "Airport{" + "airportID='" + airportID + '\'' + ", name='" + name + '\'' + ", city='" + city + '\'' +
        ", country='" + country + '\'' + ", IATACode='" + IATACode + '\'' + ", ICAOCode='" + ICAOCode + '\'' + '}';
	}
}