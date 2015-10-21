package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.authorization.UserAuthorizationService;
import zaietsv.complextask.mvc.exception.ConnectionException;
import zaietsv.complextask.mvc.factory.ProcessorFactory;
import zaietsv.complextask.mvc.processor.Processor;
import zaietsv.complextask.mvc.processor.UserAddressRoleMusicsProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserWorks")
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
		UserAuthorizationService uas = new UserAuthorizationService(request);
		String viewName;
		if (uas.checkAuthorized()) {
			ProcessorFactory factory = new ProcessorFactory();
			Processor processor = factory.getProcessor(request, response);

			viewName = "user/" + processor.process();
		} else {
			viewName = "guest.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAuthorizationService uas = new UserAuthorizationService(request);
		String viewName;
		if (uas.checkAuthorized()) {
			Processor processor = null;
			try {
				processor = new UserAddressRoleMusicsProcessor(request, response);
			} catch (ConnectionException e) {
				e.printStackTrace();
			}

			viewName = "user/" + processor.process();
		} else {
			viewName = "GuestWorks";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}

}
