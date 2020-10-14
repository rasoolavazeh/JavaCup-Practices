

public class Course {
	private String name;
	private Student[] students = new Student[10];
	private int numOfStudents = 0;


	public boolean register(Student s) {
		if (students.length == numOfStudents) {
			return false;
		}

		students[numOfStudents] = s;
		numOfStudents++;
		return true;
	}

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public Student[] getStudents() {
		Student[] registeredStudents = new Student[numOfStudents];
		for (int i = 0; i < numOfStudents; i++) {
			registeredStudents[i] = students[i];
		}
		return registeredStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

