/**
 * 
 */
package cg.naatiz.batch.savings;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;

import cg.naatiz.pop.Pop;
import cg.naatiz.pop.api.IProcessor;
import cg.naatiz.pop.util.Controller;
import cg.naatiz.pop.util.ControllerType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

/**
 * Processing an amount in string type and compute its value plus 5-15 %
 * 
 * @author naatiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.PROCESSOR)
@Interest
@Dependent
public class Processor implements IProcessor<Account, Balance> {

	@Inject
	private Logger logger;

	@Override
	public Optional<Balance> process(Optional<Account> account) throws Exception {
		logger.debug("Processing String {} to Long value, plus 5-15 %", account);
		Balance balance = Pop.newInstance(Balance.class);
		balance.setAccountID(account.get().getAccountID());
		Long value = ThreadLocalRandom.current().nextLong(45, 22950);
		value = (long) Math.ceil(value * (1 + (ThreadLocalRandom.current().nextInt(5, 15) / 100)));
		balance.setAmount(BigDecimal.valueOf(value));
		
		/*Annual Compounding: FV = $10,000 x (1 + (15% / 1)) ^ (1 x 1) = $11,500

		Semi-Annual Compounding: FV = $10,000 x (1 + (15% / 2)) ^ (2 x 1) = $11,556.25

		Quarterly Compounding: FV = $10,000 x (1 + (15% / 4)) ^ (4 x 1) = $11,586.50

		Monthly Compounding: FV = $10,000 x (1 + (15% / 12)) ^ (12 x 1) = $11,607.55

		Daily Compounding: FV = $10,000 x (1 + (15% / 365)) ^ (365 x 1) = $11,617.98

		Continuous Compounding: FV = $10,000 x 2.7183 ^ (15% x 1) = $11,618.34

		Read more: Continuous Compounding http://www.investopedia.com/terms/c/continuouscompounding.asp#ixzz4wkTsxL2s 
		Follow us: Investopedia on Facebook */
		
		return Optional.of(balance);
	}
}
