package Lab5;

public class Course {
	protected String courseIdentifier;
	protected String courseTitle;

	public Course(String courseIndentifierIn, String courseTitleIn) {
		courseIdentifier = courseIndentifierIn;
		courseTitle = courseTitleIn;
	}

	public String getCourseId() {
		return courseIdentifier;
	}

	public void setCourseID(String courseIndentifierIn) {
		courseIdentifier = courseIndentifierIn;
	}
	public String getCourseTitle(){
		return courseTitle;
	}
	public void setCourseTitle(String courseTitleIn){
		courseTitle = courseTitleIn;
	}
	public String toString(){
		return "Course: " + courseIdentifier + "/ " + courseTitle;
	}
}
