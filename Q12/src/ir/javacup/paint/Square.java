package ir.javacup.paint;


public class Square extends Shape {

	Integer length;

	public Square(Color c, Pattern p, int length) {
		super(c, p);
		this.length = length; // autoboxing

	}

	@Override
	public String toString() {
		String info = "Square[color:" + this.color + ", pattern:" + this.pattern + ", length:" + this.length + "]";
		return info;
	}

	public boolean equals(Square obj) {
		if (obj == null) {
			return false;
		}

		if (this.color == obj.color && this.pattern == obj.pattern && this.length == obj.length) {
			return true;
		}

		return false;
	}

//	public static void main(String[] args) {
//		Circle c = new Circle(Color.BLUE, Pattern.DOTTED, 10);
//		System.out.println(c);
//
//		Square s = new Square(Color.BLUE, Pattern.DOTTED, 10);
//		System.out.println(s);
//	}
}
