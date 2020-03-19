package com.safetynet.model;

import java.util.List;

public class ChildAlert {

	 private List <Person> childs;
	 private List <Person> membersOfFamily;
	 
	 
	 
	public ChildAlert(List<Person> childs, List<Person> membersOfFamily) {
		this.childs = childs;
		this.membersOfFamily = membersOfFamily;
	}
	
	public List<Person> getChilds() {
		return childs;
	}
	public void setChilds(List<Person> childs) {
		this.childs = childs;
	}
	public List<Person> getMembersOfFamily() {
		return membersOfFamily;
	}
	public void setMembersOfFamily(List<Person> membersOfFamily) {
		this.membersOfFamily = membersOfFamily;
	}

	@Override
	public String toString() {
		return "ChildAlert [childs=" + childs + ", membersOfFamily=" + membersOfFamily + "]";
	}
	 
	 
	
}
