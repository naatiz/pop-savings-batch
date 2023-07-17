package cg.naatiz.batch.savings;

import java.util.List;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import cg.naatiz.pop.Pop;
import cg.naatiz.pop.ReportingWorker;
import cg.naatiz.pop.api.IConsumer;
import cg.naatiz.pop.api.IProcessor;
import cg.naatiz.pop.api.IProducer;
import cg.naatiz.pop.util.Controller;
import cg.naatiz.pop.util.ControllerType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class SavingsApplication {

	@Inject
	private Logger logger;

	@Inject
	@Interest
	@Controller(ControllerType.PROVIDER)
	IProducer<Account> provider;

	@Inject
	@Interest
	@Controller(ControllerType.PROCESSOR)
	IProcessor<Account, Balance> processor;

	@Inject
	@Interest
	@Controller(ControllerType.CONSUMER)
	IConsumer<Balance> consumer;

	@Inject
	private Pop<Account, Balance> pop;

	/**
	 * 
	 * @param event
	 * @param parameters
	 * @throws Exception
	 */
	public void execute(@Observes ContainerInitialized event, @Parameters List<String> parameters) throws Exception {
		logger.info("Starting of Savings batch ... ");
		List<ReportingWorker<String>> reportings = this.pop.build(provider, processor, consumer).start();
		logger.info("End of Savings batch : {} workers completed successfully.", reportings.size());
	}
}