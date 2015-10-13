package zaietsv.complextask.mvc.processor.instance_processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.instance.Users;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultProcessor extends AbstractInstancesProcessor {
/*
    public UsersProcessor() {
    }*/

    public DefaultProcessor(HttpServletRequest request, HttpServletResponse response) throws ConnectionException {
        super(request, response, "admin", new UserDAO(new MusicUserConnector().getConnection(request)), new Users());
        
    }

    @Override
    public String process() {
        return "admin.jsp";
    }
}
