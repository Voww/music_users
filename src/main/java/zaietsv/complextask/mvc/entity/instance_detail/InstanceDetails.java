package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.instance.Instance;
import zaietsv.complextask.mvc.entity.instance.Instances;

/**
 * Describes 1:M relations between an entity being in question and instances related to it
 * @param <I> - an entity being in question
 * @param <D> - an entity related to the first member
 */
public interface InstanceDetails<I extends Instance, D extends Instances> {

	I getInstance();

	void setInstance(I instance);

	D getDetails();

	void setDetails(D details);
}
