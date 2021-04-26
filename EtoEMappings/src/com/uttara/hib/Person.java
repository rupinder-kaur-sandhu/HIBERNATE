package com.uttara.hib;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_person")
public class Person {
	
	@Id
	@GeneratedValue
	private Long sl;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	Vehicle vehicle;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Person(String name, Vehicle vehicle) {
		super();
		this.name = name;
		this.vehicle = vehicle;
	}



	private Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	@Override
	public String toString() {
		return "Person [sl=" + sl + ", name=" + name + ", vehicle=" + vehicle + "]";
	}
	
	
	
	
}
