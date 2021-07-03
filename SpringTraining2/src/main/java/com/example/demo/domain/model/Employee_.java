package com.example.demo.domain.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile SingularAttribute<Employee, String> email;

	public static final String ID = "id";
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String EMAIL = "email";

}
