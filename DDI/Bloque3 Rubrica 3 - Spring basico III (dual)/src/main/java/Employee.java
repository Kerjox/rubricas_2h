public class Employee {

	private int emp_id;
	private String emp_fname;
	private String emp_city;

	// Dependency Injection By Setter Methods
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	public void showResult() {
		System.out.println("\nEmployee Details? Id= " + emp_id + ", Name= " + emp_fname + ", City= " + emp_city);
	}
}
