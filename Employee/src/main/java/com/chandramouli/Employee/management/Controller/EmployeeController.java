package com.chandramouli.Employee.management.Controller;

import java.util.List;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandramouli.Employee.management.Entity.employee;
import com.chandramouli.Employee.management.Service.EmployeeService;


import jakarta.servlet.http.HttpSession;

@Controller


  @RequestMapping("/")

public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	
	  @GetMapping("/")
	  public String index(Model m) { 
		  List<employee> emp=es.getallemployee(); m.addAttribute("emp",emp); 
	  return "index";
	  }
	 
	/*
	 * @GetMapping("/home") public String index(Model m) { List<employee>
	 * emp=es.getallemployee(); m.addAttribute("emp",emp); return "home"; }
	 */
	@GetMapping("/add_emp")
	public String add_emp() {
		
		return "add_emp";
	}
	@PostMapping("/register")
	public String empregister(@ModelAttribute employee e,HttpSession session) {
		
		System.out.println("success");
		session.setAttribute("msg", "successfully added");
		es.saveemployee(e);
		return "redirect:/index";
		
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id,Model m) {
		employee e=es.getemplyee(id);
		m.addAttribute("emp",e);
		
		return "edit_emp";
	}
	@PostMapping("/update")
	public String editemp(@ModelAttribute employee e) {
		es.saveemployee(e);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteemp(@PathVariable long id) {
		es.deleteemp(id);
		return "redirect:/";
	}
	

	/*
	 * @PostMapping public employee saveemployee(@RequestBody employee e) { return
	 * es.saveemployee(e); }
	 * 
	 * @GetMapping("/{id}") public employee getemployee(@PathVariable long id) {
	 * return es.getemplyee(id).orElseThrow(() -> new
	 * RuntimeException("employee not found")); }
	 */

}
