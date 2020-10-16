package ir.javacup.paint;

public class Circle extends Shape {
	Double radius;

	public Circle(Color c, Pattern p, double r) {
		super(c, p);
		this.radius = r;
	}

	@Override
	public String toString() {
		String info = "Circle[color:" + this.color + ", pattern:" + this.pattern + ", radius:" + this.radius.intValue() + "]";
		return info;
	}

	public boolean equals(Circle obj) {
		if (obj == null) {
			return false;
		}

		if (this.color == obj.color && this.pattern == obj.pattern && this.radius.intValue() == obj.radius.intValue()) {
			return true;
		}

		return false;
	}
}
