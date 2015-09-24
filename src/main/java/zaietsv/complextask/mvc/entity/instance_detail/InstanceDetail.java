package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Instance;

/**
 * Describes 1:1 relations between an entity being in question and an entity related to it.
 * @param <I> - an entity being in question
 * @param <D> - an entity related to the first member
 */
public interface InstanceDetail<I extends Instance, D extends Instance> {

	I getInstance();

	void setInstance(I instance);

	D getDetail();

	void setDetail(D detail);
}
