/**
 * 
 */
package cg.naatiz.batch.savings;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;

import cg.naatiz.pop.Container;
import cg.naatiz.pop.Pop;
import cg.naatiz.pop.api.IProducer;
import cg.naatiz.pop.util.Controller;
import cg.naatiz.pop.util.ControllerType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

/**
 * @author naatiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.PROVIDER)
@Interest
@Dependent
public class AccountProvider implements IProducer<Account> {

	/* maximum number of containers */
	private static final long MAX_CONTAINER_NUMBER = 1000;
	/* maximum number of elements inside a container */
	private static final int MAX_CONTAINER_SIZE = 1000;

	/* current container number */
	private static final AtomicLong CURRENT_CONTAINER_NUMBER = new AtomicLong(0);

	@Inject
	private Logger logger;

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Container<Account>> produce() throws Exception {

		if (!hasMoreData()) {
			logger.info("No data anymore...");
			return Optional.empty();
		}
		
		List<Account> items = new ArrayList<>();
		int size = ThreadLocalRandom.current().nextInt(500, MAX_CONTAINER_SIZE);
		for (int i = 0; i < size; i++) {
			Account account = Pop.newInstance(Account.class);
			account.setAccountID(1 + i * CURRENT_CONTAINER_NUMBER.get());
			
			BigDecimal rate = new BigDecimal(
					ThreadLocalRandom.current().nextLong(100L, MAX_CONTAINER_SIZE),
					new MathContext(3, RoundingMode.HALF_UP));
			account.setRate(rate);
			items.add(account);
		}
		Container<Account> container = Pop.newInstance(Container.class)
				.addItems(items);
		return Optional.of(container);
	}

	private boolean hasMoreData() {
		return CURRENT_CONTAINER_NUMBER.incrementAndGet() < MAX_CONTAINER_NUMBER;
	}
}
