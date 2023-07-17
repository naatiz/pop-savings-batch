package cg.naatiz.batch.savings;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cg.naatiz.pop.Pop;

public class SavingsApplicationTest {

	private static final Logger logger = LoggerFactory.getLogger(SavingsApplicationTest.class);

	@Test
	public void execute() throws Exception {
		Pop.main(new String[] { });
		logger.debug("No thrown exception means : OK");
		assertTrue(true);
	}
}