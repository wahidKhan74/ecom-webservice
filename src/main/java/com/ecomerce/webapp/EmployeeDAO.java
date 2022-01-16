package com.ecomerce.webapp;

import org.springframework.stereotype.Repository;
 
import com.ecomerce.webapp.Employee;
import com.ecomerce.webapp.Employees;
 
@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
     
    static
    {
        list.getEmployeeList().add(new Employee(1, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "David", "Kameron", "titanic@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Sam", "Kameron", "sam@gmail.com"));
        list.getEmployeeList().add(new Employee(4, "John", "Smith", "john@gmail.com"));
        list.getEmployeeList().add(new Employee(5, "William", "Smith", "william@gmail.com"));
    }
     
    public Employees getAllEmployees() 
    {
        return list;
    }
     
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
