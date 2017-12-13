package Lab5;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Driver {
	public List<FacultyMember> facultyMembers = new ArrayList<FacultyMember>();
	public List<Student> students = new ArrayList<Student>();
	public List<Course> courses = new ArrayList<Course>();

	public void monitor() {
		String[] choices = { "Quit", "Courses", "Faculty", "Students" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "(Main Menu)", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE,
					null, choices, "null");
			switch (choice) {
			case 1:
				String[] secChoices = { "Quit", "List Courses", "Add Course" };
				int userInput;
				do {
					userInput = JOptionPane.showOptionDialog(null, "(Main Menu)", "Main Menu", 0,
							JOptionPane.QUESTION_MESSAGE, null, secChoices, "null");
					switch (userInput) {
					case 1:
						listCourses();
						break;
					case 2:
						addCourseToCourse();
						break;
					}
				} while (userInput != 0);
				break;
			case 2:
				String[] thirdChoices = { "Quit", "List Faculty", "Add Faculty", "Delete Faculty" };
				int input;
				do {
					input = JOptionPane.showOptionDialog(null, "(Main Menu)", "Main Menu", 0,
							JOptionPane.QUESTION_MESSAGE, null, thirdChoices, "null");
					switch (input) {
					case 1:
						if (!(facultyMembers.isEmpty()))
							listFaculty();
						break;
					case 2:
						addFaculty();
						break;
					case 3:
						if (!(facultyMembers.isEmpty()))
							deleteFaculty();
						break;
					}
				} while (input != 0);
				break;
			case 3:
				String[] fourthChoices = { "Quit", "List Students", "Add Students", "Delete Students" };
				int in;
				do {
					in = JOptionPane.showOptionDialog(null, "(Main Menu)", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE,
							null, fourthChoices, "null");
					switch (in) {
					case 1:
						if (!(students.isEmpty()))
							listStudents();
						break;
					case 2:
						addStudent();
						break;
					case 3:
						if (!(students.isEmpty()))
							deleteStudent();
						break;
					}
				} while (in != 0);
				break;
			}
		} while (choice != 0);
	}

	public void listCourses() {

		StringBuilder sb = new StringBuilder(courses.toString());
		if (courses.isEmpty())
			sb.append("None");
		else
			for (@SuppressWarnings("unused") Course c : courses)
				JOptionPane.showMessageDialog(null, sb);
	}

	public void addCourseToCourse() {
		String courseIdentifier = JOptionPane.showInputDialog("Please enter the Id for the course");
		String courseTitle = JOptionPane.showInputDialog("Please enter the course title");
		courses.add(new Course(courseIdentifier, courseTitle));
	}

	public void addCourse() {
		FacultyMember f = getEmployeeIdFromInput();
		if (facultyMembers.contains(f)) {
			String courseIdentifier = JOptionPane.showInputDialog("Please enter the Id for the course");
			String courseTitle = JOptionPane.showInputDialog("Please enter the course title");
			f.addCourse(new Course(courseIdentifier, courseTitle));
		}
	}

	public void listFaculty() {
		FacultyMember fm = getEmployeeIdFromInput();
		if (facultyMembers.contains(fm)) {
			List<Course> facultyCourses = fm.getCourses();
			StringBuilder sb = new StringBuilder(fm.toString());
			if (facultyMembers.isEmpty())
				sb.append("None");
			else
				for (Course f : facultyCourses)
					sb.append(f + "\n");
			JOptionPane.showMessageDialog(null, sb);
		}
	}

	private FacultyMember getEmployeeIdFromInput() {
		int choice = JOptionPane.showOptionDialog(null, "Choose A Faculty", "Choose A Faculty Member", 0,
				JOptionPane.QUESTION_MESSAGE, null, facultyMembers.toArray(), "null");

		return facultyMembers.get(choice);
	}

	public void addFaculty() {
		long employeeId = Long.parseLong(JOptionPane.showInputDialog(null, "Please enter the ID# for Faculty"));
		String nameIn = JOptionPane.showInputDialog("Please enter the name of the Faculty Member");
		int streetNumberIn = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the street number for the Faculty member"));
		String streetNameIn = JOptionPane.showInputDialog("Please enter the name of the street");
		String cityIn = JOptionPane.showInputDialog("Please enter the name of the city the faculty resides");
		String stateIn = JOptionPane.showInputDialog("Please enter the state the faculty resides");
		String countryIn = JOptionPane.showInputDialog("Please enter the country the faculty resides");
		facultyMembers
				.add(new FacultyMember(employeeId, nameIn, streetNumberIn, streetNameIn, cityIn, stateIn, countryIn));
	}

	public void deleteFaculty() {

		int choice = JOptionPane.showOptionDialog(null, "Choose A Faculty Member to delete",
				"Choose A Faculty Member you would like to delete", 0, JOptionPane.QUESTION_MESSAGE, null,
				facultyMembers.toArray(), "null");

		facultyMembers.remove(choice);
	}

	public void listStudents() {
		Student s = getIdFromInput();
		if (students.contains(s)) {
			List<Course> facultyCourses = s.getCourses();
			StringBuilder sb = new StringBuilder(s.toString());
			if (students.isEmpty())
				sb.append("None");
			else
				for (Course f : facultyCourses)
					sb.append(f + "\n");
			JOptionPane.showMessageDialog(null, sb);
		}
	}

	private Student getIdFromInput() {
		int choice = JOptionPane.showOptionDialog(null, "Choose A Student", "Choose A Student", 0,
				JOptionPane.QUESTION_MESSAGE, null, students.toArray(), "null");

		return students.get(choice);
	}

	public void addStudent() {
		long cinNumberIn = Long.parseLong(JOptionPane.showInputDialog(null, "Please enter the CIN number"));
		String nameIn = JOptionPane.showInputDialog("Please enter the name of the student");
		int streetNumberIn = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the street number for the student"));
		String streetNameIn = JOptionPane.showInputDialog("Please enter the name of the street");
		String cityIn = JOptionPane.showInputDialog("Please enter the name of the city the student resides");
		String stateIn = JOptionPane.showInputDialog("Please enter the state the student resides");
		String countryIn = JOptionPane.showInputDialog("Please enter the country the  resides");
		students.add(new Student(cinNumberIn, nameIn, streetNumberIn, streetNameIn, cityIn, stateIn, countryIn));
	}

	public void deleteStudent() {

		int choice = JOptionPane.showOptionDialog(null, "Choose A Student to delete", "Choose A Student", 0,
				JOptionPane.QUESTION_MESSAGE, null, students.toArray(), "null");

		students.remove(choice);
	}

	public static void main(String[] args) {

		
		/* Person p1 = new FacultyMember(12345, "Dr. Bob", 135, "Jackson",
		 "los Angeles", "CA", "USA"); 
		 Course c1 = new Course("1","Figure-Drawing"); 
		 Person s1 = new Student(257489655,
		 "Nick", 145, "Sonora", "Glendale", "CA", "USA");
		 System.out.println(p1 + " Instructs: " + c1 + " With Students: " +
		 s1);
		 
		 FacultyMember f2 = new FacultyMember(118975, "Dr. Simon", 245, "Glenoaks",
		 "Glendale", "CA", "USA");
		 Course c2 = new Course("121", "Anatomy");
		 Student s2 = new Student(125784588, "Sam", 120, "Broadway", "Glendale", "CA", "USA");
		 System.out.println(f2 + " Instructs: " + c2 + " With Students: " +
				 s2);*/
		 
		 Driver d = new Driver();
		 d.monitor();
	}
}
