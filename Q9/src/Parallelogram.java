import java.util.Scanner;

public class Parallelogram {

	//Your code goes here.
	static boolean flag;
	static int breadth;
	static int height;

	static {
		Scanner input = new Scanner(System.in);
		breadth = input.nextInt();
		height = input.nextInt();

		if (breadth <= 0 || height <= 0) {
			flag = false;
			System.out.println("invalid");
		} else {
			flag = true;
			System.out.println("valid");
		}
	}
	
	public static void main(String[] args) { //don't change main body
		if (flag) {
			int area = breadth * height;
			System.out.print(area);
		}
	}
}
