package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.dao.data_access_object_detail.DataAccessObjectDetail;
import zaietsv.complextask.mvc.entity.instance_detail.AbstractInstanceDetail;
import zaietsv.complextask.mvc.entity.instance_detail.InstanceDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractInstanceDetailProcessor<E extends AbstractInstanceDetail> implements InstanceDetailProcessor {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String table;
    protected DataAccessObjectDetail daod;
    protected InstanceDetail instanceDetail;

    public AbstractInstanceDetailProcessor() {
    }

    public AbstractInstanceDetailProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, DataAccessObjectDetail daod, InstanceDetail instanceDetail) {
        this.request = servletRequest;
        this.response = servletResponse;
        this.table = table;
        this.daod = daod;
        this.instanceDetail = instanceDetail;
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
