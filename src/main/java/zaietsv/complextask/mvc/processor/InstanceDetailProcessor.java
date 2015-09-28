package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetail;

public interface InstanceDetailProcessor<E extends InstanceDetail> extends Processor {

    String process();
}