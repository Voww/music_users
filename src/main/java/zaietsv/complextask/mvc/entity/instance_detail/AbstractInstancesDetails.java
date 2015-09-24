package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.AbstractInstances;

public abstract class AbstractInstancesDetails<I extends AbstractInstances, D extends AbstractInstances> implements InstancesDetails<I, D> {

	/**
	 *
	 */
	protected I instances;
	protected D details;

	public AbstractInstancesDetails() {

	}

	public AbstractInstancesDetails(I instances, D details) {
		this.instances = instances;
		this.details = details;
	}

	@Override
	public I getInstances() {
		return instances;
	}

	@Override
	public void setInstances(I instances) {
		this.instances = instances;
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
