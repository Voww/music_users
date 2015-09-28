package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.dao.data_acces_object.DataAccessObject;
import zaietsv.complextask.mvc.entity.instance.AbstractInstances;
import zaietsv.complextask.mvc.entity.instance.Instances;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractInstancesProcessor<E extends AbstractInstances> implements InstancesProcessor {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String table;
    protected DataAccessObject dao;
    protected Instances instances;

    public AbstractInstancesProcessor() {
    }

    public AbstractInstancesProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, DataAccessObject dao, Instances instances) {
        this.request = servletRequest;
        this.response = servletResponse;
        this.table = table;
        this.dao = dao;
        this.instances = instances;
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
