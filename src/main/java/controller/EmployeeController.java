package controller;

import java.util.Scanner;

import entity.Employee;

public class EmployeeController {

	private static final int size = 50; // set the size of array

	private Employee[] employees = new Employee[size]; // array

	private int count = 0;

	// Crud Operations

	// 1. create employee/ Add employee
	public void addEmployee(int empId, String empName, String gender, String role) {
		if (count >= size) {
			System.out.println("Cannot add more employees, maximum limit reached");
			return;
		}

		employees[count++] = new Employee(empId, empName, gender, role);
		System.out.println("Employee Added Successfully....");
	}

	// 2. Read/Display Employee Details
	public void displayEmployees() {
		if (count == 0) {
			System.out.println("No Employees to display...");
			return;
		}

		System.out.println("Employee List:");
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i]);
		}
	}

	// 3. update Employee details
	public void updateEmployee(int empId, String newEmpName, String newGender, String NewRole) {
		for (int i = 0; i < count; i++) {
			if (employees[i].getEmpId() == empId) {
				employees[i].setEmpName(newEmpName);
				employees[i].setGender(newGender);
				employees[i].setRole(NewRole);
				System.out.println("Employees Updated Successfully...");
				return;
			}
		}
		System.out.println("Employee with empId " + empId + " not found.");
	}

	// 4. delete Employee details
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
		System.out.println("Employee with empId " + empId + " not found.");
	}

	public static void main(String[] args) {
		EmployeeController employeeController = new EmployeeController();

		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("\n Menu:");
			System.out.println("1. Add Employee");
			System.out.println("2. Display Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter empId:");
				int empId = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Employee Name:");
				String empName = sc.nextLine();

				System.out.println("Enter Employee gender:");
				String gender = sc.nextLine();

				System.out.println("Enter Employee Role:");
				String role = sc.nextLine();

				employeeController.addEmployee(empId, empName, gender, role);
				break;

			case 2:
				employeeController.displayEmployees();
				break;

			case 3:
				System.out.println("Enter empId to update:");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Employee New Name:");
				String newEmpName = sc.nextLine();

				System.out.println("Enter Employee New gender:");
				String newGender = sc.nextLine();

				System.out.println("Enter Employee New Role:");
				String newRole = sc.nextLine();

				employeeController.updateEmployee(updateId, newEmpName, newGender, newRole);
				break;

			case 4:
				System.out.println("Enter empId to delete employee: ");
				int deleteId = sc.nextInt();
				employeeController.deleteEmployee(deleteId);
				break;

			case 5:
				System.out.println("Exiting, Thanks and visit again.");
				break;

			default:
				System.out.println("Invalid choice enterd!");
			}
		} while (choice != 5);
	}
}
