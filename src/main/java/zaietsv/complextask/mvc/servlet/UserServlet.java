package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			MusicUserConnector ct = new MusicUserConnector();
			UserDAO udao = new UserDAO(ct.getConnection(request));
			ArrayList<User> users = udao.readAll();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		String action = request.getParameter("action");
		switch (action) {
		case "insert":
			
			break;
		case "update":
			
			break;
		case "delete":
			
			break;

		default:
			writer.print("");
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
