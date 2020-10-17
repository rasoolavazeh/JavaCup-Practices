package ir.javacup.salary;

public abstract class SalaryListCreator {

	protected Encoder encoder;
	
	public SalaryListCreator(Encoder encoder) {
		this.encoder = encoder;
	}

	public String create(Employee[] employees) {
		String rawStr = doCreate(employees);
		return encoder.encode(rawStr);
	}
	
	protected abstract String doCreate(Employee[] employees);
	
	protected static String addZeroPrefix(String str, int length) {
		// TODO Implement
		String zero = "";
		if (str.length() < length) {
			for (int i = 0; i < length - str.length(); i++) {
				zero += "0";
			}
		}

		return zero + str;
	}
	
	protected String getRecordSeparator() {
		return System.lineSeparator();
	}
	
	protected String getItemSeparator() {
		return " ";
	}

}
