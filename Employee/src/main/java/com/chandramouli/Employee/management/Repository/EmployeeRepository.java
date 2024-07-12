package com.chandramouli.Employee.management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandramouli.Employee.management.Entity.employee;
@Repository
public interface EmployeeRepository extends JpaRepository<employee,Long> {
	Optional<employee> findById(long id);
	

}
