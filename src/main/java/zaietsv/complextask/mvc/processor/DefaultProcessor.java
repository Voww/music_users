package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.instance.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DefaultProcessor extends AbstractInstancesProcessor {
/*
    public UsersProcessor() {
    }*/

    public DefaultProcessor(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        super(request, response, "admin", new UserDAO(new MusicUserConnector().getConnection(request)), new Users());
        
    }

    @Override
    public String process() {
        return "admin.jsp";
    }
}
