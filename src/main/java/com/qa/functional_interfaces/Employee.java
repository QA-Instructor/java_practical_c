package com.qa.functional_interfaces;
// The Employee class has 2 constructors: one empty, one with a name
// Note: no interfaces are implemented in this class (EmployeeEmpty or EmployeeWithName)

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Employee(){
        System.out.println("Empty constructor is invoked");
    }

    public Employee(String name){
        System.out.println("Name constructor is invoked");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee name is " + name;
    }
}
