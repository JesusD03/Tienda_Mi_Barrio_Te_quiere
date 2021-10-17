package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.DayAndIDException;
import exceptions.Under18YearsOldException;

public class Tienda {
	
	private List<Customer> customers;
	
	public Tienda() {
		customers = new ArrayList<Customer>();
	}
	
	public void addCustomer(String id, String idType) throws Under18YearsOldException, DayAndIDException {
		customers.add(new Customer(id, idType));
	}
		
}
