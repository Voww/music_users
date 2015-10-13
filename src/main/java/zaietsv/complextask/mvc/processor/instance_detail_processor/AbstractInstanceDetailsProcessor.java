package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.dao.data_access_object_detail.DataAccessObjectDetails;
import zaietsv.complextask.mvc.entity.instance_detail.AbstractInstanceDetails;
import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractInstanceDetailsProcessor<E extends AbstractInstanceDetails> implements InstanceDetailsProcessor {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String table;
    protected DataAccessObjectDetails daods;
    protected InstanceDetails instanceDetails;

    public AbstractInstanceDetailsProcessor() {
    }

    public AbstractInstanceDetailsProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, DataAccessObjectDetails daods, InstanceDetails instanceDetails) {
        this.request = servletRequest;
        this.response = servletResponse;
        this.table = table;
        this.daods = daods;
        this.instanceDetails = instanceDetails;
    }

    public abstract String process();

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
