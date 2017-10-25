/**
 * 
 */
package cg.naatiz.batch.savings;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

import org.slf4j.Logger;

import cg.naatiz.batch.pop.Pop;
import cg.naatiz.batch.pop.Processor;
import cg.naatiz.batch.pop.util.Controller;
import cg.naatiz.batch.pop.util.ControllerType;

/**
 * Processing an amount in string type and compute its value plus 5-15 %
 * 
 * @author natiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.PROCESSOR)
@Interest
public class AcccountProcessor implements Processor<Account, Balance> {

	@Inject
	private Logger logger;

	@Override
	public Optional<Balance> process(Optional<Account> account) throws Exception {
		logger.debug("Processing String {} to Long value, plus 5-15 %", account);
		Balance balance = Pop.newInstance(Balance.class);
		balance.setAccountID(account.get().getAccountID());
		Long value = account.get().getAmount().longValue();
		value = (long) Math.ceil(value * (1 + (ThreadLocalRandom.current().nextInt(5, 15) / 100)));
		balance.setAmount(BigDecimal.valueOf(value));
		return Optional.of(balance);
	}
}
