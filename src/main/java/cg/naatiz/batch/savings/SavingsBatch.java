package cg.naatiz.batch.savings;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import cg.naatiz.batch.pop.Pop;
import cg.naatiz.batch.pop.Processor;
import cg.naatiz.batch.pop.Puller;
import cg.naatiz.batch.pop.Pusher;
import cg.naatiz.batch.pop.Reporting;
import cg.naatiz.batch.pop.util.Controller;
import cg.naatiz.batch.pop.util.ControllerType;
import cg.naatiz.batch.pop.util.ExecutionOption;
import cg.naatiz.batch.pop.util.PopProperties;

public class SavingsBatch {

	@Inject
	private Logger logger;

	@Inject
	// @PopConfig({"/pop.cfg"})
	private PopProperties popProperties;

	private Pop<Account, Balance> savings;

	@Inject
	@SuppressWarnings("unchecked")
	public void init(@Interest @Controller(ControllerType.PROVIDER) final Puller<Account> provider,
			@Interest @Controller(ControllerType.PROCESSOR) final Processor<Account, Balance> processor,
			@Interest @Controller(ControllerType.CONSUMER) final Pusher<Balance> consumer) {

		this.savings = Pop.newInstance(Pop.class).addConfiguration(popProperties, ExecutionOption.NONE).build(provider,
				processor, consumer);
	}

	/**
	 * 
	 * @param event
	 * @param parameters
	 * @throws Exception
	 */
	public void execute(@Observes ContainerInitialized event, @Parameters List<String> parameters) throws Exception {

		// Revival = relance ou reprise
		logger.debug("Running options : -M=Monitoring -R=Revival");
		if (parameters.isEmpty() || !parameters.get(0).contains("-MR")) {
			throw new IllegalStateException("M or R option parameter is missing!");
		}

		logger.info("Interest batch starting ... ");
		List<Reporting> reportings = savings.start();
		logger.info("Reportings size: " + reportings.size());
		logger.info("Interest batch ends successfully!");
	}
}