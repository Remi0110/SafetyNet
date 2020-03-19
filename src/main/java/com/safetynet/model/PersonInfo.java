package com.safetynet.model;

import java.util.List;

public class PersonInfo {

	private int nbAdults;
	private List<Person> adults;
	private int nbChilds;
	private List<Person> childs;

	public PersonInfo(List<Person> adults, int nbAdults, List<Person> childs, int nbChilds) {
		this.nbAdults = nbAdults;
		this.adults = adults;
		this.nbChilds = nbChilds;
		this.childs = childs;
	}

	public List<Person> getAdults() {
		return adults;
	}

	public void setAdults(List<Person> adults) {
		this.adults = adults;
	}

	public List<Person> getChilds() {
		return childs;
	}

	public void setChilds(List<Person> childs) {
		this.childs = childs;
	}

	public int getNbAdults() {
		return nbAdults;
	}

	public void setNbAdults(int nbAdults) {
		this.nbAdults = nbAdults;
	}

	public int getNbChilds() {
		return nbChilds;
	}

	public void setNbChilds(int nbChilds) {
		this.nbChilds = nbChilds;
	}

	@Override
	public String toString() {
		return "PersonInfo [nbAdults=" + nbAdults + ", adults=" + adults + ", nbChilds=" + nbChilds + ", childs="
				+ childs + "]";
	}

}
