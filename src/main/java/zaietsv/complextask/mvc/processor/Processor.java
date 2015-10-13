package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.entity.Entity;

/**
 * Created by Voww on 27.09.2015.
 */
public interface Processor<E extends Entity> {

    String process();
}
