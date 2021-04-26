package com.uttara.hib.inh;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_ccAcc")
@DiscriminatorValue("cc")
public class CreditCardAccount extends Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ccNum;
	private BigDecimal maxLimit;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfExp;
	
	public CreditCardAccount()
	{
		System.out.println("in ccAcc no-arg constructor");
	}

	public CreditCardAccount(String owner, BigDecimal balance, String ccNum, BigDecimal maxLimit, Date dateOfExp) {
		super(owner,balance);
		this.ccNum = ccNum;
		this.maxLimit = maxLimit;
		this.dateOfExp = dateOfExp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ccNum == null) ? 0 : ccNum.hashCode());
		result = prime * result + ((dateOfExp == null) ? 0 : dateOfExp.hashCode());
		result = prime * result + ((maxLimit == null) ? 0 : maxLimit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardAccount other = (CreditCardAccount) obj;
		if (ccNum == null) {
			if (other.ccNum != null)
				return false;
		} else if (!ccNum.equals(other.ccNum))
			return false;
		if (dateOfExp == null) {
			if (other.dateOfExp != null)
				return false;
		} else if (!dateOfExp.equals(other.dateOfExp))
			return false;
		if (maxLimit == null) {
			if (other.maxLimit != null)
				return false;
		} else if (!maxLimit.equals(other.maxLimit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCardAccount [ccNum=" + ccNum + ", maxLimit=" + maxLimit + ", dateOfExp=" + dateOfExp + "]";
	}
	
	

}
