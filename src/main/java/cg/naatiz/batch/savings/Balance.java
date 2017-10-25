package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;

@SuppressWarnings("serial")
public class Balance implements Serializable {
	
	private Long accountID;
	private BigDecimal amount;
	private BigDecimal interest;
	private Period period;
	private BigDecimal averageRate;
	
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
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public BigDecimal getAverageRate() {
		return averageRate;
	}
	public void setAverageRate(BigDecimal averageRate) {
		this.averageRate = averageRate;
	}
}
