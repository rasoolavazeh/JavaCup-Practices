package ir.javacup.io;

import java.io.*;
import java.util.Scanner;

public class CourseUtilImpl implements CourseUtil {
    @Override
    public void setOutputStream(ByteArrayOutputStream out) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("file")) {
            fileOutputStream.write(out.toByteArray());
            fileOutputStream.write('\n');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Grade load(int lineNumber) {
        try (Scanner in = new Scanner(new FileInputStream("file"))) {
            String[] s;
            int i = 1;
            while (in.hasNextLine()) {
                if (lineNumber == i) {
                    s = in.nextLine().split(" ");
                    Grade grade = new Grade();
                    grade.setStudentId(s[0]);
                    grade.setCourseCode(Integer.parseInt(s[1]));
                    grade.setScore(Double.parseDouble(s[2]));
                    return grade;
                }
                in.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Grade score) {
        boolean flag = false;
        try (Scanner in = new Scanner(new FileInputStream("file"))) {
            Grade grade;
            String[] s;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                grade = new Grade();
                grade.setStudentId(s[0]);
                grade.setCourseCode(Integer.parseInt(s[1]));
                if (s[2] != null) {
                    grade.setScore(Double.parseDouble(s[2]));
                }

                if (score.equals(grade)) {
                    flag = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!flag) {
            try (FileOutputStream outputStream = new FileOutputStream("file", true)) {
                String grade = score.getStudentId() + " " + score.getCourseCode() + " " + score.getScore() + "\n";
                outputStream.write(grade.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double calcCourseAverage(int courseCode) {
        try (Scanner in = new Scanner(new FileInputStream("file"))) {
            String[] s;
            double sum = 0;
            int count = 0;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                if (Integer.parseInt(s[1]) == courseCode && s[2] != null) {
                    sum += Double.parseDouble(s[2]);
                    count++;
                }
            }

            if (count != 0) {
                return sum / count;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public double calcStudentAverage(String studentId) {
        try (Scanner in = new Scanner(new FileInputStream("file"))) {
            String[] s;
            double sum = 0;
            int count = 0;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                if (s[0].equals(studentId) && s[2] != null) {
                    sum += Double.parseDouble(s[2]);
                    count++;
                }
            }

            if (count != 0) {
                return sum / count;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int count() {
        int count = 0;
        try (Scanner in = new Scanner(new FileInputStream("file"))) {
            String[] s;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                if (s[2] != null) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        final String content = "777777777 111 13.5"
                + System.lineSeparator() + "888888888 333 19.5";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(content.getBytes());
        } catch (IOException e) {
        }

        CourseUtilImpl util = new CourseUtilImpl();
        util.setOutputStream(out);

        Grade grade = util.load(1);
        System.out.println("id: " + grade.getStudentId() + " code: " + grade.getCourseCode() + " score: " + grade.getScore());

        Grade g = new Grade();
        g.setCourseCode(313);
        g.setScore(13);
        g.setStudentId("1111111");
        util.save(g);

        System.out.println("count: " + util.count());
        grade = util.load(3);
        System.out.println("id: " + grade.getStudentId() + " code: " + grade.getCourseCode() + " score: " + grade.getScore());
    }
}
