package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Period implements Serializable {
	
	private BigDecimal amount;
	private java.time.Period period;
	
	/* Annual interest rate */
	private BigDecimal rate;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public java.time.Period getPeriod() {
		return period;
	}
	public void setPeriod(java.time.Period period) {
		this.period = period;
	}
	
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
}
