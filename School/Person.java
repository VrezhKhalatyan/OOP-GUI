package Lab5;

public class Person extends Address {
	protected String name;

	public Person() {
	}

	public Person(String nameIn, int streetNumberIn, String streetNameIn, String cityIn, String stateIn,
			String countryIn) {
		super(streetNumberIn, streetNameIn, cityIn, stateIn, countryIn);
		name = nameIn;

	}

	public String getName() {
		return name;
	}

	public void setName(String nameIn) {
		name = nameIn;
	}

	public String toString() {
		return "The Person " + name + " has an Address:" + streetNumber + streetName + city + ", " + state + country;
	}
}
