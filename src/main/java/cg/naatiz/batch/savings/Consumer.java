/**
 * 
 */
package cg.naatiz.batch.savings;

import java.util.Optional;

import org.slf4j.Logger;

import cg.naatiz.pop.Container;
import cg.naatiz.pop.api.IConsumer;
import cg.naatiz.pop.util.Controller;
import cg.naatiz.pop.util.ControllerType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

/**
 * @author naatiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.CONSUMER)
@Interest
@Dependent
public class Consumer implements IConsumer<Balance> {

	@Inject
	private Logger logger;

	@Override
	public boolean consume(Optional<Container<Balance>> container) throws Exception {
		logger.debug(container.toString());
		return true;
	}
}
