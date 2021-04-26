package com.uttara.hib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_actors")
public class Actor {
	
	@Id
	@GeneratedValue
	private Long sl;
	
	@Column(name = "aname")
	private String name;
	private String famousD;
	private Date dob;
	private String gender;
	
	public Actor() {
		System.out.println("in actor n0-arg co0nstructor");
	}
	
	
	public Actor(String name, String famousD, Date dob, String gender) {
		super();
		this.name = name;
		this.famousD = famousD;
		this.dob = dob;
		this.gender = gender;
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
	public String getFamousD() {
		return famousD;
	}
	public void setFamousD(String famousD) {
		this.famousD = famousD;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((famousD == null) ? 0 : famousD.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Actor other = (Actor) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (famousD == null) {
			if (other.famousD != null)
				return false;
		} else if (!famousD.equals(other.famousD))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Actor [sl=" + sl + ", name=" + name + ", famousD=" + famousD + ", dob=" + dob + ", gender=" + gender
				+ "]";
	}
	
	
	

}
