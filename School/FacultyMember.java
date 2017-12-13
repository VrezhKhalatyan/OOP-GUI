package Lab5;

import java.util.ArrayList;
import java.util.List;

public class FacultyMember extends Person {
	protected long employeeId;
	protected List<Course> courses;

	public FacultyMember(long employeeIdIn, String nameIn, int streetNumberIn, String streetNameIn, String cityIn,
			String stateIn, String countryIn) {
		super(nameIn, streetNumberIn, streetNameIn, cityIn, stateIn, countryIn);
		courses = new ArrayList<Course>();
		employeeId = employeeIdIn;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeIdIn) {
		employeeId = employeeIdIn;
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
		return "EMPLOYEE ID# " + employeeId + " " + name + " " + " has an Address:" + " " + streetNumber + " " + streetName + " " + city + ", "
				+ state + " " + country;
	}

}
