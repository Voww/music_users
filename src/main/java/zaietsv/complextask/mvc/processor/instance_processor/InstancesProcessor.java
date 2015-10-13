package zaietsv.complextask.mvc.processor.instance_processor;

import zaietsv.complextask.mvc.entity.instance.Instances;
import zaietsv.complextask.mvc.processor.Processor;

/**
 * Created by Voww on 18.09.2015.
 */
public interface InstancesProcessor<E extends Instances> extends Processor<E> {

    String process();
}