package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;

@SuppressWarnings("serial")
public class AccountPeriod implements Serializable {
	
	private BigDecimal amount;
	private Period period;
	
	/* Annual interest rate */
	private BigDecimal rate;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
}
