package zaietsv.complextask.mvc.entity.instance_detail;

import zaietsv.complextask.mvc.entity.Entity;
import zaietsv.complextask.mvc.entity.instance.Instances;

/**
 * Describes M:M relations between instances being in question and instances related to them
 * @param <I> - an entity being in question
 * @param <D> - an entity related to the first one
 */
public interface InstancesDetails<I extends Instances, D extends Instances> extends Entity {

	I getInstances();

	void setInstances(I instances);

	D getDetails();

	void setDetails(D details);
}
