// Developed by avdeshjadon (GitHub: avdeshjadon)
package com.ems.dao;

import com.ems.entity.Department;
import java.util.List;

public interface DepartmentDAO {

    void save(Department dept);

    Department findById(int id);

    List<Department> findAll();
}
