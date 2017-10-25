/**
 * 
 */
package cg.naatiz.batch.savings;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import org.slf4j.Logger;

import cg.naatiz.batch.pop.Container;
import cg.naatiz.batch.pop.Pop;
import cg.naatiz.batch.pop.Puller;
import cg.naatiz.batch.pop.util.Controller;
import cg.naatiz.batch.pop.util.ControllerType;

/**
 * @author natiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.PROVIDER)
@Interest
public class AccountProvider implements Puller<Account> {

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
	public Optional<Container<Account>> pull() throws Exception {

		if (!hasMoreData()) {
			logger.info("No data anymore...");
			return Optional.empty();
		}
		Container<Account> container = Pop.newInstance(Container.class);
		for (int i = 0; i < MAX_CONTAINER_SIZE; i++) {
			Account account = Pop.newInstance(Account.class);
			account.setAccountID(Long.valueOf(i));
			account.setAmount(BigDecimal.valueOf(ThreadLocalRandom.current().nextLong(MAX_CONTAINER_SIZE), BigDecimal.ROUND_HALF_UP));
			//"" + ThreadLocalRandom.current().nextInt(MAX_CONTAINER_SIZE);
			container.addItem(account);
		}
		CURRENT_CONTAINER_NUMBER.incrementAndGet();
		return Optional.of(container);
	}

	private boolean hasMoreData() {
		return CURRENT_CONTAINER_NUMBER.get() < MAX_CONTAINER_NUMBER;
	}
}
