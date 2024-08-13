package com.qa.functional_interfaces;

public class Utils {
    public int compareEmployees(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }

    public static int staticCompareEmployees(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
