// Developed by avdeshjadon (GitHub: avdeshjadon)
package com.ems.main;

import com.ems.dao.DepartmentDAO;
import com.ems.dao.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. List All Employees");
            System.out.println("6. Add Department");
            System.out.println("7. List All Departments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    addDepartment();
                    break;
                case 7:
                    listAllDepartments();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");

        List<Department> departments = departmentDAO.findAll();
        if (departments.isEmpty()) {
            System.out.println("No departments found. Please add a department first.");
            return;
        }

        System.out.println("Available Departments:");
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Department ID: ");
        int deptId = scanner.nextInt();
        scanner.nextLine();

        Department department = departmentDAO.findById(deptId);
        if (department == null) {
            System.out.println("Department not found!");
            return;
        }

        Employee emp = new Employee(name, email, salary, department);
        employeeService.saveEmployee(emp);
        System.out.println("Employee saved successfully!");
    }

    private static void viewEmployee() {
        System.out.print("\nEnter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = employeeService.getEmployee(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void updateEmployee() {
        System.out.print("\nEnter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = employeeService.getEmployee(id);
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter new Name (" + emp.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            emp.setName(name);
        }

        System.out.print("Enter new Email (" + emp.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            emp.setEmail(email);
        }

        System.out.print("Enter new Salary (" + emp.getSalary() + "): ");
        String salaryStr = scanner.nextLine();
        if (!salaryStr.isEmpty()) {
            emp.setSalary(Double.parseDouble(salaryStr));
        }

        employeeService.updateEmployee(emp);
        System.out.println("Employee updated successfully!");
    }

    private static void deleteEmployee() {
        System.out.print("\nEnter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = employeeService.getEmployee(id);
        if (emp != null) {
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    private static void listAllEmployees() {
        System.out.println("\n--- All Employees ---");
        List<Employee> employees = employeeService.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void addDepartment() {
        System.out.println("\n--- Add New Department ---");

        System.out.print("Enter Department Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Location: ");
        String location = scanner.nextLine();

        Department dept = new Department(name, location);
        departmentDAO.save(dept);
        System.out.println("Department saved successfully!");
    }

    private static void listAllDepartments() {
        System.out.println("\n--- All Departments ---");
        List<Department> departments = departmentDAO.findAll();

        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department dept : departments) {
            System.out.println(dept);
        }
    }
}
