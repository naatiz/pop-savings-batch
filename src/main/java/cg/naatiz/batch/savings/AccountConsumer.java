/**
 * 
 */
package cg.naatiz.batch.savings;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;

import cg.naatiz.batch.pop.Container;
import cg.naatiz.batch.pop.Pusher;
import cg.naatiz.batch.pop.util.Controller;
import cg.naatiz.batch.pop.util.ControllerType;

/**
 * @author natiz
 * 
 */
@SuppressWarnings("serial")
@Controller(ControllerType.CONSUMER)
@Interest
public class AccountConsumer implements Pusher<Balance> {

	@Inject
	private Logger logger;

	@Override
	public boolean push(Optional<Container<Balance>> container) throws Exception {
		if (container.isPresent() && container.get().getReference() == 5) {
			logger.warn("Rejecting : {}", container);
		}
		logger.debug(container.toString());
		return true;
	}
}
