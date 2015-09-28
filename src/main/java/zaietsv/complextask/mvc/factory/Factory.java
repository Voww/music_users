package zaietsv.complextask.mvc.factory;

import zaietsv.complextask.mvc.processor.Processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 26.09.2015.
 */
public interface Factory {

    Processor getProcessor(HttpServletRequest request, HttpServletResponse response);
}
