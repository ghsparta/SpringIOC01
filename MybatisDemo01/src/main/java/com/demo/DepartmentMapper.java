package com.demo;

import com.demo.domain.Department;

public interface DepartmentMapper {
    Department selectDepartmentById(int id);
    Department selectDepartmentById2(int id);
}
