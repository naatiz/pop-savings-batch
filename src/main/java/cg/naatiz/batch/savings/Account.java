package cg.naatiz.batch.savings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;


@SuppressWarnings("serial")
public class Account implements Serializable {
	
	private Long accountID;
	private BigDecimal amount;
	private List<AccountPeriod> periods = Lists.newArrayList();

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

	public List<AccountPeriod> getPeriods() {
		return periods;
	}
	public void setPeriods(List<AccountPeriod> periods) {
		this.periods = periods;
	}
}
