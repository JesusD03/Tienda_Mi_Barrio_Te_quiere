package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.DayAndIDException;
import exceptions.Under18YearsOldException;

public class Tienda {
	
	private List<Customer> customers;
	private  int count;
	
	public Tienda() {
		customers = new ArrayList<Customer>();
		count = 0;
	}
	
	public void addCustomer(String id, String idType) throws Under18YearsOldException, DayAndIDException {
		count++;
		customers.add(new Customer(id, idType));
	}

	public int getCount() {
		return count;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	
	
		
}
