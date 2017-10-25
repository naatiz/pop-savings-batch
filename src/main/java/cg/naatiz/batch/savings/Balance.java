package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Balance implements Serializable {
	
	private Long accountID;
	private BigDecimal amount;
	private BigDecimal interest;
	
	public Long getAccountID() {
		return accountID;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getInterest() {
		return interest;
	}
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
}
