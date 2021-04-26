package com.uttara.hib;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_Emps")
public class Employee {
	
	@Id
	@GeneratedValue
	private Long sl;
	
	@Column(nullable=false)
	private String name;
	//mutable state
	private Date dob;
	
	@Embedded
	private Address homeAddress;
	
	@ElementCollection
	private List<String> emails = new ArrayList<String>();
	
	@ElementCollection
	private List<PhoneNumber> phoneNum = new ArrayList<PhoneNumber>();
	
	
	
	public Employee(String name, Date dob, Address homeAddress) {
		super();
		this.name = name;
		this.dob = new Date(dob.getTime());
		this.homeAddress = new Address(homeAddress);
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
	public Date getDob() {
		return new Date(dob.getTime());
	}
	public void setDob(Date dob) {
		this.dob = new Date(dob.getTime());
	}
	public Address getHomeAddress() {
		return new Address(homeAddress);
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = new Address(homeAddress);
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<PhoneNumber> getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(List<PhoneNumber> phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
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
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [sl=" + sl + ", name=" + name + ", dob=" + dob + ", homeAddress=" + homeAddress + ", emails="
				+ emails + ", phoneNum=" + phoneNum + "]";
	}
	
	
}
