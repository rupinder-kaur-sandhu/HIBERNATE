package com.uttara.hib.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_persons3")
public class Person {
	
	@Id
	@GeneratedValue
	private Long sl;
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Person(String name) {
		super();
		this.name = name;
	}



	public Long getSl() {
		return sl;
	}
	private void setSl(Long sl) {
		this.sl = sl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vehicles == null) ? 0 : vehicles.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vehicles == null) {
			if (other.vehicles != null)
				return false;
		} else if (!vehicles.equals(other.vehicles))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [sl=" + sl + ", name=" + name + ", vehicles=" + vehicles + "]";
	}
	
	
	

}
