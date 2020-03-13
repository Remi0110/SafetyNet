package com.safetynet.model;

import java.util.List;
import java.util.Map;

public class PersonInfo {
	
	 private Map<Integer, List <String>> adults;
	 private Map<Integer, List <String>> childs;
	 
	public PersonInfo(Map<Integer, List<String>> adults, Map<Integer, List<String>> childs) {
		super();
		this.adults = adults;
		this.childs = childs;
	}

	public Map<Integer, List<String>> getAdults() {
		return adults;
	}

	public void setAdults(Map<Integer, List<String>> adults) {
		this.adults = adults;
	}

	public Map<Integer, List<String>> getChilds() {
		return childs;
	}

	public void setChilds(Map<Integer, List<String>> childs) {
		this.childs = childs;
	}
	 
	

	 

	 
	 
}
