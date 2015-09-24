package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.AbstractInstance;
import zaietsv.complextask.mvc.entity.instance.AbstractInstances;

public abstract class AbstractInstanceDetails<I extends AbstractInstance, D extends AbstractInstances> implements InstanceDetails<I, D> {

	/**
	 * an AbstractInstance numeric identifier.
	 */
	protected I instance;
	protected D details;

	/**
	 * Constructs an empty abstract entity
	 */
	public AbstractInstanceDetails() {

	}

	public AbstractInstanceDetails(I instance, D details) {
		this.instance = instance;
		this.details = details;
	}

	@Override
	public I getInstance() {
		return instance;
	}

	@Override
	public void setInstance(I instance) {
		this.instance = instance;
	}

	@Override
	public D getDetails() {
		return details;
	}

	@Override
	public void setDetails(D details) {
		this.details = details;
	}
}
