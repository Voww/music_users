package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetails;

public interface InstanceDetailsProcessor<E extends InstanceDetails> extends Processor {

    String process();
}