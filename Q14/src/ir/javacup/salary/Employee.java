package ir.javacup.salary;

public class Employee {

	private String code;
	private long salary;

	public Employee(String code, long salary) {
		this.code = code;
		this.salary = salary;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
