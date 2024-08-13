package com.qa;

import com.qa.functional_interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("LAMBDA AND FUNCTIONAL INTERFACE EXAMPLES");

//        exampleA();
//        exampleB();
//        exampleC();
//        exampleD();
//        exampleE();

    }

    public static void exampleA(){
        System.out.println("##### Example A #####");
        // Create an anonymous inner class from an interface

        Greeter greeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name); // implement the abstract method
            }
        }; // end of anonymous inner class

        // Call the method of the anonymous class
        greeter.greet("Everyone");
        greeter.greet("Team");
    }

    public static void exampleB(){
        System.out.println("##### Example B #####");
        // Shorten the syntax by using a lambda
        // Lambdas provide a short and simple way to implement functional interfaces

        Greeter greeter = (String name) -> {
            System.out.println("Hello " + name);
        };

        // Call the method of the anonymous class
        greeter.greet("Everyone");
        greeter.greet("Team");
    }

    public static void exampleC() {
        System.out.println("##### Example C #####");
        // Method references are a shorthand way of writing a certain type of
        // lambda expression
        // A lambda that passes in a variable and then calls a method on that variable can
        // be replaced with a method reference
        // Method references use the :: operator (aka Method Reference Delimiter)
        // SYNTAX: target of reference (receiver) :: name of method (or constructor)

        // A method reference refers to the method but doesn't invoke it (the
        // forEach does the invocation here)
        // They refer to methods of existing classes or objects whereas a lambda
        // expression allows us to define an anonymous method and treat it as an
        // instance of a functional interface

        // Key Takeaway: the class the method belongs to does not have to implement an
        // interface or inherit from a specific class

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        // Iterate using a lambda expression
        arrayList.forEach(n -> System.out.println(n));

        // Iterate using a method reference to the static println method
        arrayList.forEach(System.out::println);
    }

    public static void exampleD() {
        System.out.println("##### Example D #####");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rod"));
        employees.add(new Employee("Jane"));
        employees.add(new Employee("Freddy"));
        System.out.println("##### Employees before sort:");
        employees.forEach(System.out::println);

        // No method reference is used here, just a lambda
        // The lambda derives an anonymous implementation of the
        // Comparator<Employee> interface
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("##### Employees after sort:");
        employees.forEach(System.out::println);

        // If you already had a class with a suitable method and implementation, you
        // can use a method reference even without implementing the Comparator<> interface
        // in that class
        System.out.println("##### Add Zippy and George");
        employees.add(new Employee("Zippy"));
        employees.add(new Employee("George"));

        System.out.println("##### Employees before second sort:");
        employees.forEach(System.out::println);

        // Use an existing class method for the comparison logic
        Utils utils = new Utils();

        employees.sort(utils::compareEmployees);
        System.out.println("##### Employees after second sort:");
        employees.forEach(System.out::println);

        System.out.println("##### Add Bungle");
        // The utils method could be a static method
        employees.add(new Employee("Bungle"));

        System.out.println("##### Employees before third sort:");
        employees.forEach(System.out::println);

        employees.sort(Utils::staticCompareEmployees); // staticCompareEmployees uses class name (no object instantiated)
        System.out.println("##### Employees after third sort:");
        employees.forEach(System.out::println);

    }

    public static void exampleE() {
        System.out.println("##### Example E #####");
        // Constructor references
        // A constructor reference is used to refer to a constructor without instantiating
        // the named class
        // SYNTAX: target of reference (receiver) :: name of method (or constructor)
        // A constructor / method reference refers to the method but doesn't invoke it
        // (the 'get' does the invocation here)
        // In constructor reference expressions, instead of specifying the exact
        // constructor, we just write 'new'
        // However, a class may have multiple constructors. In that case, the compiler
        // checks the type of the target functional interface with each of the
        // constructors in the class, and finally chooses the best match.

        // Key Takeaway: The Employee class does not implement either of the interfaces
        // referenced in this code but the Employee class does have 2 constructors that
        // match the functional interface methods

        // The get method within this functional interface matches the empty constructor
        EmployeeEmpty empEmpty = Employee::new;

        System.out.println("Constructor has yet to be called");
        // 'get' will create the object instance e.g. the get method is a factory method
        // for creating employees
        Employee emp1 = empEmpty.get(); // constructor called and employee instance is returned
        System.out.println(emp1); // toString is invoked by the print statement
        System.out.println(empEmpty); // the method reference expression has an implicit
        // lambda expression which uses the implementation of the referred method or
        // constructor at runtime.

        // The 'get' method within this functional interface matches the constructor that
        // takes a string
        EmployeeWithName empWithName = Employee::new;

        System.out.println("Constructor has yet to be called");
        System.out.println(empWithName.get("Lisa"));
    }
}