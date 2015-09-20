package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.dao.DataAccessObject;
import zaietsv.complextask.mvc.holder.AbstractHolder;
import zaietsv.complextask.mvc.holder.Holder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 18.09.2015.
 */
public abstract class AbstractProcessor<E extends AbstractHolder> implements Processor {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String table;
    protected DataAccessObject dao;
    protected Holder holder;

    public AbstractProcessor() {
    }

    public AbstractProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String table, DataAccessObject dao, Holder holder) {
        this.request = servletRequest;
        this.response = servletResponse;
        this.table = table;
        this.dao = dao;
        this.holder = holder;
    }

    public abstract E process();

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
