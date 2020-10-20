package ir.javacup.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Copier {

	String[] params;

	public Copier (String... params) {
		this.params = params;
	}
	
	public void copy(Object o1, Object o2) {
		Field[] o1Fields = o1.getClass().getDeclaredFields();

		if (params.length ==  0) {
			for (int i = 0; i < o1Fields.length; i++) {
				try {

					String fieldName = o1Fields[i].getName();
					String setMethod = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1, fieldName.length());
					String getMethod = "get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1, fieldName.length());

					Method getValue = o1.getClass().getMethod(getMethod);
					Object value = getValue.invoke(o1);

					Method[] methods = o2.getClass().getMethods();
					for (Method method : methods) {
						if (method.getName().equals(setMethod)) {
							method.invoke(o2, value);
						}
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}

			}
		} else {
			for (String param : params) {
				for (int i = 0; i < o1Fields.length; i++) {
					String name = o1Fields[i].getName();
					if (param.equals(name)) {
						try {
							String fieldName = param;
							String setMethod = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1, fieldName.length());
							String getMethod = "get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1, fieldName.length());

							Method getValue = o1.getClass().getMethod(getMethod);
							Object value = getValue.invoke(o1);

							Method[] methods = o2.getClass().getMethods();
							for (Method method : methods) {
								if (method.getName().equals(setMethod)) {
									method.invoke(o2, value);
								}
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}


	}

//	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
//
//		Copier copier = new Copier("b");
//		Circle c1 = new Circle(5.5, 8, "Ali");
//		Circle c2 = new Circle();
//
//		System.out.println(c1.getRadius());
//		System.out.println(c2.getRadius());
//		System.out.println(c1.getA());
//		System.out.println(c2.getA());
//		System.out.println(c1.getB());
//		System.out.println(c2.getB());
//		copier.copy(c1, c2);
//		System.out.println(c1.getRadius());
//		System.out.println(c2.getRadius());
//		System.out.println(c1.getA());
//		System.out.println(c2.getA());
//		System.out.println(c1.getB());
//		System.out.println(c2.getB());
//
//		Circle circle = new Circle();
//		circle.radius = 2.5;
//		Class circleClass =
//				Class.forName("ir.javacup.reflection.Circle");
//		Field[] fields = circleClass.getFields();
//
//		System.out.println(circle.getClass().getFields()[0]);
//		for (Field field : fields)
//			if(field.getName().equals("radius")){
//				Object value = field.get(circle);
//				Double r = (Double) value;
//				System.out.println(r);
//				field.set(circle, r*2);
//				System.out.println(circle.radius);
//			}
//	}
}
