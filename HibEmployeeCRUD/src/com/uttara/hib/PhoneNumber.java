package com.uttara.hib;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
	
	private String areaCode;
	private String ISDCode;
	private String number;
	
	public PhoneNumber() {
		System.out.println("in phonenumber no arg constructor");
	}
	
	public PhoneNumber(String areaCode, String iSDCode, String number) {
		super();
		this.areaCode = areaCode;
		ISDCode = iSDCode;
		this.number = number;
	}
	
	public PhoneNumber(PhoneNumber ph) {
		this.areaCode = ph.areaCode;
		this.ISDCode = ph.ISDCode;
		this.number = ph.number;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getISDCode() {
		return ISDCode;
	}
	public void setISDCode(String iSDCode) {
		ISDCode = iSDCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISDCode == null) ? 0 : ISDCode.hashCode());
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		PhoneNumber other = (PhoneNumber) obj;
		if (ISDCode == null) {
			if (other.ISDCode != null)
				return false;
		} else if (!ISDCode.equals(other.ISDCode))
			return false;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return ISDCode+" "+areaCode+" "+number;
	}

}
