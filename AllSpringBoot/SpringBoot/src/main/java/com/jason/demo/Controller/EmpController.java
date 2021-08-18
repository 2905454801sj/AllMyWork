package com.jason.demo.Controller;

import com.jason.demo.dao.DepartmentDao;
import com.jason.demo.dao.EmployeeDao;
import com.jason.demo.entities.Department;
import com.jason.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }
    @GetMapping("/emp")
    public String add(Model model){
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
