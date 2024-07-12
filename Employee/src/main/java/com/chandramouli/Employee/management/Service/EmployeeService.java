package com.chandramouli.Employee.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandramouli.Employee.management.Entity.employee;
import com.chandramouli.Employee.management.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository er;
	public employee getemplyee(long id) {
		Optional<employee> emp=er.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}
	public employee saveemployee(employee e) {
		return er.save(e);
	}
	public List<employee> getallemployee(){
		return er.findAll();
	}
	public void deleteemp(long id) {
		
		System.out.println(er.findById(id));
		er.deleteById(id);
	}
	
	
}
