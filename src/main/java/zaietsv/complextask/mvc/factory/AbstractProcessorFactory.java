package zaietsv.complextask.mvc.factory;

import zaietsv.complextask.mvc.processor.Processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 27.09.2015.
 */
public abstract class AbstractProcessorFactory implements Factory {

    @Override
    public abstract Processor getProcessor(HttpServletRequest request, HttpServletResponse response);
}
