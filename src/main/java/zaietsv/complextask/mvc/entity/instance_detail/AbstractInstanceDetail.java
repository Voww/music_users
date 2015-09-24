package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.AbstractInstance;

public abstract class AbstractInstanceDetail<I extends AbstractInstance, D extends AbstractInstance> implements InstanceDetail<I, D> {

	protected I instance;
	protected D detail;
	
	/**
	 * Constructs an empty abstract entity
	 */
	public AbstractInstanceDetail() {

	}

	public AbstractInstanceDetail(I instance, D detail) {
		this.instance = instance;
		this.detail = detail;
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
	public D getDetail() {
		return detail;
	}

	@Override
	public void setDetail(D detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "AbstractInstanceDetail{" +
				"entity=" + instance +
				", detail=" + detail +
				'}';
	}
}
