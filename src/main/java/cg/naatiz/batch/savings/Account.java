package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;


@SuppressWarnings("serial")
public class Account implements Serializable {
	
	private Long accountID;
	private List<AccountPeriod> periods = Lists.newArrayList();
	
	/* Annual interest rate */
	private BigDecimal rate;

	public Long getAccountID() {
		return accountID;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public List<AccountPeriod> getPeriods() {
		return periods;
	}
	public void setPeriods(List<AccountPeriod> periods) {
		this.periods = periods;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
