package entity;

public class Employee {

	private int empId;

	private String empName;

	private String gender;

	private String role;

	public Employee(int empId, String empName, String gender, String role) {
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", role=" + role + "]";
	}

}
