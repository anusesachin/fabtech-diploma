 package com.nt.cntrl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.service.EmpService;

@RestController
@PropertySource(value = "classpath:email.properties")
@RequestMapping("/employees")
public class HomeController {
	
	@Autowired
	private EmpService service;        
	
	@Value("${sender.email}")
	private String email;
	
	@GetMapping("/name/{name}/sal/{sal}")
	public List<Employee> getByNameAndSalary(@PathVariable String name,@PathVariable int sal){
		List<Employee> list = service.getByNamendSalary(name,sal);
		return list;
	}
	
	@GetMapping("/sal/{sal}")
	public List<Employee> getBySalary(@PathVariable int sal){
		List<Employee> list = service.getBySalary(sal);
		return list;
	}
	
	//employees
	@GetMapping
	public List<Employee> allRecords(){
		List<Employee> list = service.allRecords();
		return list;
	}
	
	@PutMapping
	public String update(@RequestBody Employee e) {
		service.update(e);
		return "updated";
	}
	
	//employees POST
	@PostMapping
	public String add(@Valid @RequestBody Employee e) {
		service.add(e);
		return "added";
	}

	// 7171/emp/id/2
	@RequestMapping(value = "/emp/id/{i}", method = RequestMethod.GET)
	public Employee getById(@PathVariable("i") int id) {
		Employee e = service.getById(id);
		return e;
	}
}
