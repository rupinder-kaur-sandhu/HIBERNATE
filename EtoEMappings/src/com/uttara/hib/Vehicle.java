package com.uttara.hib;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue
	private Long id;
	private String vin;
	private Vtype type;
	
	@OneToOne(mappedBy="vehicle")
	private Person owner;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
		System.out.println("in vehicle no arg constructor");
	}
	
	
	
	public Vehicle(String vin, Vtype type) {
		super();
		this.vin = vin;
		this.type = type;
	}



	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Vtype getType() {
		return type;
	}
	public void setType(Vtype type) {
		this.type = type;
	}
	
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (type != other.type)
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
		return "Vehicle [id=" + id + ", vin=" + vin + ", type=" + type + ", owner=" + owner + "]";
	}



	
	

}

enum Vtype
{
	TWOW,THREEW,FORW,SIXTEENW
}
