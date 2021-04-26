package com.uttara.hib.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vehicles3")
public class Vehicle {
	
	@Id
	@GeneratedValue
	private Long sl;
	private String name;
	private String vin;
	
	@ManyToMany(mappedBy="vehicles")
	List<Person> owners = new ArrayList<Person>();
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Vehicle(String name, String vin) {
		super();
		this.name = name;
		this.vin = vin;
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
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public List<Person> getOwners() {
		return owners;
	}
	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owners == null) ? 0 : owners.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owners == null) {
			if (other.owners != null)
				return false;
		} else if (!owners.equals(other.owners))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicle [sl=" + sl + ", name=" + name + ", vin=" + vin + ", owners=" + owners + "]";
	}
	
	

}
