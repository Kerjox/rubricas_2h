import java.util.Map;

public class Department {

	private int departmentId;
	private String departmentName;
	private Map<String, String> employee;

	public Department() {
	}

	public Department(int dept_id, String dept_name, Map<String, String> dept_employee) {
		this.departmentId = dept_id;
		this.departmentName = dept_name;
		this.employee = dept_employee;
	}

	public void showResult() {
		System.out.println("Department Details? Id= " + departmentId + ", Name= " + departmentName);
		System.out.println("\nEmployee Details?\n");
		for (Map.Entry<String, String> mapValue : employee.entrySet()) {
			System.out.println("Designation= " + mapValue.getKey() + ", Name= " + mapValue.getValue());
		}
	}
}
