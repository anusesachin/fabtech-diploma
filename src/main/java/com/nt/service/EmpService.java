package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmpDao;
import com.nt.entity.Employee;

@Service
public class EmpService {

	private static final Logger logger =
            LoggerFactory.getLogger(EmpService.class);
	
	@Autowired
	private EmpDao dao;

	public List<Employee> getByNamendSalary(String name, int sal) {
		return dao.findByNameAndSal(name,sal);
	}


	public List<Employee> allRecords() {
		logger.info("just info msg");
		logger.warn("just warining msg");
		logger.error("just error msg");
		logger.debug("just debug msg");
		List<Employee> list = dao.findAll();
		return list;
	}

	public Employee getById(int id) {
		Optional<Employee> opt = dao.findById(id);
		return opt.get();
	}
	
	public void add(Employee e) {
		//bonus add 100
		System.out.println("info - save started");
		dao.save(e);
		System.out.println("saved successfully");
	}

	public void update(Employee e) {
		dao.save(e);
	}

	public List<Employee> getBySalary(int sal) {
		
		return dao.xyz(sal);
	}


}
