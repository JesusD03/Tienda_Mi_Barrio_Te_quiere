package model;

import java.time.LocalDateTime;

import exceptions.DayAndIDException;
import exceptions.Under18YearsOldException;

public class Customer {
	
	private int today = LocalDateTime.now().getDayOfMonth();
	private String id;
	private String idType;
	
	public Customer(String id, String idType) throws Under18YearsOldException, DayAndIDException {
		if(idType.equals("TI")) {
			throw new Under18YearsOldException();
		}else if(dayAndID(id)){
			this.id = id;
			this.idType = idType;
		}
	}

	public int penultimo(String id) {
		String[] p = id.split("");
		return Integer.parseInt(p[(p.length-2)]);
	}
	
	public boolean dayAndID(String id) throws DayAndIDException {
		if(today%2 == 0 && penultimo(id)%2 != 0) {
			return true;
		} else if(today%2 != 0 && penultimo(id)%2 == 0) {
			return true;
		} else {
			throw new DayAndIDException();
		}
	}
	
	public String getId() {
		return id;
	}

	public String getIdType() {
		return idType;
	}
	
}
