package com.safetynet.model;

import java.util.Map;

public class PersonInfo {
	
	 private Map<Integer, Person> adults;
	 private Map<Integer, Person> childs;
	 
	public PersonInfo(Map<Integer, Person> adults, Map<Integer, Person> childs) {
		super();
		this.adults = adults;
		this.childs = childs;
	}

	public Map<Integer, Person> getAdults() {
		return adults;
	}

	public void setAdults(Map<Integer, Person> adults) {
		this.adults = adults;
	}

	public Map<Integer, Person> getChilds() {
		return childs;
	}

	public void setChilds(Map<Integer, Person> childs) {
		this.childs = childs;
	}
	 

	 

	 
	 
}
