package com.nt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Employee;

public interface EmpDao extends CrudRepository<Employee, Integer>{
	List<Employee> findAll();
	
	@Query(value = "select * from emp where sal=?",nativeQuery = true)
	List<Employee> xyz(int sal);

	List<Employee> findByNameAndSal(String name, int sal);
}
