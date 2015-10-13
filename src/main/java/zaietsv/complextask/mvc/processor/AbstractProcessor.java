package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.dao.UserAddressRoleMusicsDAO;
import zaietsv.complextask.mvc.entity.Entity;
import zaietsv.complextask.mvc.entity.UserAddressRoleMusics;
import zaietsv.complextask.mvc.processor.instance_processor.InstancesProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractProcessor<E extends Entity> implements InstancesProcessor {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String table;
    protected UserAddressRoleMusicsDAO dao;
    protected UserAddressRoleMusics uarm;

    public AbstractProcessor() {
    }

    public AbstractProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, UserAddressRoleMusicsDAO dao, UserAddressRoleMusics uarm) {
        this.request = servletRequest;
        this.response = servletResponse;
        this.table = table;
        this.dao = dao;
        this.uarm = uarm;
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
