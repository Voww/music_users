package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetails;
import zaietsv.complextask.mvc.processor.Processor;

public interface InstanceDetailsProcessor<E extends InstanceDetails> extends Processor<E> {

    String process();
}