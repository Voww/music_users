package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.entity.instance.Instances;

/**
 * Created by Voww on 18.09.2015.
 */
public interface InstancesProcessor<E extends Instances> {

    E process();
}