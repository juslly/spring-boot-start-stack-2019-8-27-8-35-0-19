package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	//@GetMapping(path = "/")
//	public ResponseEntity<List<Employee>> getEmployee(){
//		
//		List<Employee> employeeInf = new ArrayList<Employee>();
//		employeeInf.add(new Employee(0,"Xiaoming",20,"Male"));
//		employeeInf.add(new Employee(1,"Xiaohong",18,"Female"));
//		employeeInf.add(new Employee(2,"Xiaolan",21,"Female"));
//	
//		return ResponseEntity.ok(employeeInf);
//		
//	}
	
	

	List<Employee> employees = new ArrayList<Employee>();
	@GetMapping(path = "/")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployee(){
		employees.add(new Employee(0,"Xiaoming",10,"Male"));
		return employees;
	}
	
	@PostMapping(path = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Employee> addEmployee(@RequestBody Employee employee){
		employees.add(employee);
		return employees;
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getDetatilEmployee(@PathVariable int id){
		
		for(Employee employee:employees) {
			if(employee.getId() == id) {
				return ResponseEntity.ok(employee);
				
			}
			
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id){
		
		for(Employee employee:employees) {
			if(employee.getId() == id) {
				employee.setAge(50);
				employee.setGender("FeMale");
				employee.setName("zhangsan");
				
				return ResponseEntity.ok(employee);
			}
			
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@DeleteMapping(path ="/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		for(Employee employee:employees) {
			if(employee.getId() == id) {
				employees.remove(employee);
				return new ResponseEntity<Employee>(HttpStatus.OK);
				
			}
			
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		
	}
	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable ){
//		
////		//ResponseEntity addEmployee = getEmployee();
////		List<Employee> employeeInf = new ArrayList<Employee>();
////		
////		employeeInf = (List<Employee>) getEmployee();
////		employeeInf.add(new Employee(3,"zhanglan",20,"Male"));
////		
////		return ResponseEntity.ok(employeeInf);
//		
//	}

}
