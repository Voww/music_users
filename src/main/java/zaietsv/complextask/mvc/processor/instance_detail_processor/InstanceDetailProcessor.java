package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetail;
import zaietsv.complextask.mvc.processor.Processor;

public interface InstanceDetailProcessor<E extends InstanceDetail> extends Processor<E> {

    String process();
}