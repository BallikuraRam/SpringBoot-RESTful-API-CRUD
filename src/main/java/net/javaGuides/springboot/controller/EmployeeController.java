package net.javaGuides.springboot.controller;

import net.javaGuides.springboot.exception.ResourceNotFoundException;
import net.javaGuides.springboot.model.Employee;
import net.javaGuides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository ;

    // building get ALL Employess REST API
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createemployee (@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    // build get employye by id REST API
    @GetMapping("{id}")
    public ResponseEntity <Employee> getemployeebyid(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee does not exist with id "+id));
        return ResponseEntity.ok(employee);
    }

    // build get upadate an employe by REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateemployee(@PathVariable long id , @RequestBody Employee updateDeatails)
    {
        Employee updateEmployee = employeeRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("employee dose not exist eith id "+id));

        updateEmployee.setFirstName(updateDeatails.getFirstName());
        updateEmployee.setLastName(updateEmployee.getLastName());
        updateEmployee.setEmailId(updateEmployee.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee by REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("employee dose not exist eith id "+id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
