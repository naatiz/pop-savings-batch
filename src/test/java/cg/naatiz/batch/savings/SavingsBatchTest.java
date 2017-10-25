package cg.naatiz.batch.savings;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cg.naatiz.batch.pop.Pop;
import cg.naatiz.batch.savings.SavingsBatchTest;

public class SavingsBatchTest {
	private static final Logger logger = LoggerFactory.getLogger(SavingsBatchTest.class);

	@Test
	public void execute() throws Exception {
		// Revival = relance ou reprise
		logger.debug("Running options : -M=Monitoring -R=Revival");
		assertTrue(Pop.main(new String[] { "-MR" }));
	}
}