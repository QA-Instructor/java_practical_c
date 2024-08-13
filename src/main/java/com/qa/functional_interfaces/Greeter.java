package com.qa.functional_interfaces;

// A functional interface is an interface that has only one abstract method
// Also called Single Abstract Method interfaces
// May contain default or static methods also but only one abstract method
// Instances of the interface can be created using:
//  - anonymous inner classes
//  - lambda expressions
//  - method references
//  - constructor references

//  A Java lambda expression allows us to define an anonymous method and treat it as an instance of
//  a functional interface

//  A Java method reference allows us to do the same thing but with an existing method. A method
//  reference refers to a method of an existing class or object
//  The '::' is a new operator called the method reference delimiter
//  Receiver :: methodName / constructorName


// Lambdas represent the implementation of a functional interface

// NOTE the use of the @FunctionalInterface annotation
@FunctionalInterface
public interface Greeter {

    public abstract void greet(String name);


// Uncomment / comment this method signature to see the annotation warning
//    public abstract void sayFarewell(String name);
}
