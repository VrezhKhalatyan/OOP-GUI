package Lab5;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	protected long cinNumber;
	protected List<Course> courses;

	public Student(long cinNumberIn, String nameIn, int streetNumberIn, String streetNameIn, String cityIn,
			String stateIn, String countryIn) {
		super(nameIn, streetNumberIn, streetNameIn, cityIn, stateIn, countryIn);
		cinNumber = cinNumberIn;
		courses = new ArrayList<Course>();
	}

	public long getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(long cinNumberIn) {
		cinNumber = cinNumberIn;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course courseIn) {
		courses.add(courseIn);
	}

	public void dropCourse(Course course) {
		courses.remove(course);
	}

	public String toString() {
		return "CIN#" + cinNumber + " " + name + " " + " has an Address: " + streetNumber + " " + streetName + " "
				+ city + ", " + state + " " + country;
	}
}
