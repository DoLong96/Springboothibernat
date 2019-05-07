package com.example.demo2.repository;

import com.example.demo2.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Query("select ee.name from Employee ee where ee.id= :id" )
    String getNameById(@Param("id") Integer id);

//    @Query("delete from Employee ee where ee.id= :id")
//    String remove(@Param("id") Integer id);
}//thao tac cac cau lenh csdl
