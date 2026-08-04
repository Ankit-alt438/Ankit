// Developed by avdeshjadon (GitHub: avdeshjadon)
package com.ems.service;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void saveEmployee(Employee emp) {
        employeeDAO.save(emp);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeDAO.update(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
