package com.demo;

import com.demo.domain.Emp;

public interface EmpMapper {
    Emp selectEmpById(int id);
    Emp selectEmpByName(String name);
}
