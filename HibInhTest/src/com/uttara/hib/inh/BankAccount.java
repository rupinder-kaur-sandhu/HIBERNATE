package com.uttara.hib.inh;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_bankAcc")
@DiscriminatorValue("ba")
public class BankAccount extends Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String bankName;
	private BigDecimal minBalance;
	
	public BankAccount()
	{
		System.out.println("in ban acc no-arg constructor");
	}
	
	public BankAccount(String owner, BigDecimal balance, String bankName, BigDecimal minBalance) {
		super(owner,balance);
		this.bankName = bankName;
		this.minBalance = minBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((minBalance == null) ? 0 : minBalance.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (minBalance == null) {
			if (other.minBalance != null)
				return false;
		} else if (!minBalance.equals(other.minBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [bankName=" + bankName + ", minBalance=" + minBalance + "]";
	}
	
	

}
