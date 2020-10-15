package ir.javacup.convention;


public class CodeConventionUtil {
	
	public String getFieldsName(String... params){
		String field = "";
		String param;
		for (int i = 0; i < params.length; i++) {
			if (i == 0) {
				field += params[i].toLowerCase();
			} else {
				param = params[i].toUpperCase();
				field += param.charAt(0);
				param = param.toLowerCase();
				for (int j = 1; j < param.length(); j++) {
					field += param.charAt(j);
				}
			}
		}

		return field;
	}
	
	public String getMethodsName(String... params){
		String method = "";
		String param;
		for (int i = 0; i < params.length; i++) {
			if (i == 0) {
				method += params[i].toLowerCase();
			} else {
				param = params[i].toUpperCase();
				method += param.charAt(0);
				param = param.toLowerCase();
				for (int j = 1; j < param.length(); j++) {
					method += param.charAt(j);
				}
			}
		}

		return method;
	}
	
	public String getClassName(String... params){
		String className = "";
		String param;
		for (int i = 0; i < params.length; i++) {
			param = params[i].toUpperCase();
			className += param.charAt(0);
			param = param.toLowerCase();
			for (int j = 1; j < param.length(); j++) {
				className += param.charAt(j);
			}
		}

		return className;
	}
	
	public String getConstantsName(String... params){
		String constant = "";
		for (int i = 0; i < params.length; i++) {
			if (i != 0) {
				constant += "_";
			}
			constant += params[i].toUpperCase();
		}

		return constant;
	}


//	public static void main(String[] args) {
//		CodeConventionUtil c = new CodeConventionUtil();
//		System.out.println("Field: " + c.getFieldsName("print", "name"));
//		System.out.println("Method: " + c.getMethodsName("get", "family"));
//		System.out.println("Class: " + c.getClassName("car", "factory"));
//		System.out.println("Constant: " + c.getConstantsName("const", "num"));
//	}
	

}
