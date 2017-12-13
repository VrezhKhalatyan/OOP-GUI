package Lab5;

public class Address {
	protected int streetNumber;
	protected String streetName;
	protected String city;
	protected String state;
	protected String country;

	public Address() {
	}

	public Address(int streetNumberIn, String streetNameIn, String cityIn, String stateIn, String countryIn) {
		streetNumber = streetNumberIn;
		streetName = streetNameIn;
		city = cityIn;
		state = stateIn;
		country = countryIn;
	}

	public int getStreetNum() {
		return streetNumber;
	}

	public void setStreetNum(int streetNumberIn) {
		streetNumber = streetNumberIn;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetNameIn) {
		streetName = streetNameIn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String cityIn) {
		city = cityIn;
	}

	public String getState() {
		return state;
	}

	public void setState(String stateIn) {
		state = stateIn;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String countryIn) {
		country = countryIn;
	}

	public String toString() {
		return "The Address is: " + streetNumber + streetName + city + ", " + state + country;
	}

}
