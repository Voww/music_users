package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetail;

/**
 * Created by Voww on 18.09.2015.
 */
public interface InstanceDetailProcessor<E extends InstanceDetail> {

    E process();
}