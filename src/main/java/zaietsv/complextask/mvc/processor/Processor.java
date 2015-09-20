package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.holder.Holder;

/**
 * Created by Voww on 18.09.2015.
 */
public interface Processor<E extends Holder> {

    E process();
}