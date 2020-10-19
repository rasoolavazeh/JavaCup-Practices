package ir.javacup.io;

import java.io.ByteArrayOutputStream;

public interface CourseUtil {

	void setOutputStream(ByteArrayOutputStream out);
	
	Grade load(int lineNumber);

	void save(Grade score);

	double calcCourseAverage(int courseCode);

	double calcStudentAverage(String studentId);

	int count();

}
