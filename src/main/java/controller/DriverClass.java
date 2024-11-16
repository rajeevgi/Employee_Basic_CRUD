package controller;

import java.util.Scanner;

import entity.Employee;

public class DriverClass {

	private static final int size = 50;

	private Employee[] employees = new Employee[size];

	private int count = 0;

	// Crud operations

	public void addEmployee(int empId, String empName, String gender, String role) {

		if (count >= size) {
			System.out.println("Cannot added more employee, Maximum limit reached!");
			return;
		}

		employees[count++] = new Employee(empId, empName, gender, role);
		System.out.println("Employee Added Successfully...");
	}

	public void displayEmployeeById(int empId, String empName, String gender, String role) {

		for (int i = 0; i < count; i++) {
			if (employees[i].getEmpId() != empId) {
				System.out.println("Employee with empId" + empId + " not found!");
				return;
			} else {
				System.out.println("Employee details are: ");
				System.out.println("Employee Id: " + employees[i].getEmpId());
				System.out.println("Employee Name: " + employees[i].getEmpName());
				System.out.println("Employee Gender: " + employees[i].getGender());
				System.out.println("Employee Role: " + employees[i].getRole());
			}
		}
	}

	public void displayEmployee() {
		if (count == 0) {
			System.out.println("No employees to display");
			return;
		}

		System.out.println("Employees List:");
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i]);
		}
	}

	public void updateEmployee(int empId, String newEmpName, String newGender, String newRole) {

		for (int i = 0; i < count; i++) {
			if (employees[i].getEmpId() == empId) {
				employees[i].setEmpName(newEmpName);
				employees[i].setGender(newGender);
				employees[i].setRole(newRole);
				System.out.println("Employee updated successfully...");
				return;
			}
		}
		System.out.println("Employee with empId " + empId + " not found!!!");
	}

	public void deleteEmployee(int empId) {
		for (int i = 0; i < count; i++) {
			if (employees[i].getEmpId() == empId) {
				for (int j = i; j < count - 1; j++) {
					employees[j] = employees[j + 1];
				}
				employees[--count] = null;
				System.out.println("Employee deleted successfully...");
				return;
			}
		}
		System.out.println("Employee with empId: " + empId + " not found!!!");
	}

	public static void main(String[] args) {
		DriverClass class1 = new DriverClass();

		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("\n Menu:");
			System.out.println("1. Add Employee");
			System.out.println("2. Display Employee By Id");
			System.out.println("3. Display Employees");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter a empId:");
				int empId = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter a employee Name:");
				String name = sc.nextLine();

				System.out.println("Enter a employee Gender:");
				String gender = sc.nextLine();

				System.out.println("Enter a employee Role:");
				String role = sc.nextLine();

				class1.addEmployee(empId, name, gender, role);
				break;

			case 2:
				System.out.println("Enter a empId to display:");
				int EmpId = sc.nextInt();
				sc.nextLine();

				break;

			case 3:
				class1.displayEmployee();
				break;

			case 4:
				System.out.println("Enter empId to update:");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Employee New Name:");
				String newEmpName = sc.nextLine();

				System.out.println("Enter Employee New gender:");
				String newGender = sc.nextLine();

				System.out.println("Enter Employee New Role:");
				String newRole = sc.nextLine();

				class1.updateEmployee(updateId, newEmpName, newGender, newRole);
				break;

			case 5:
				System.out.println("Enter empId to delete employee:");
				int deleteId = sc.nextInt();

				class1.deleteEmployee(deleteId);
				break;
			case 6:
				System.out.println("Exiting, Thanks and visit again.");
				break;

			default:
				System.out.println("Invalid choice enterd!");
			}
		} while (choice != 6);
	}
}
