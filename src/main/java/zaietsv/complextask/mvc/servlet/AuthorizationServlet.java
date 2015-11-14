package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.authorization.UserAuthorizationService;
import zaietsv.complextask.mvc.entity.instance.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		description = "Performs authorization procedures",
		urlPatterns = { "/AuthorizationService" },
		initParams = { 
				@WebInitParam(name = "login", value = "2", description = "dfdsf")
		})
public class AuthorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		String action = request.getParameter("action");
		action = action == null ? "" : action;
		switch (action) {
			case "logout":
				UserAuthorizationService uas = new UserAuthorizationService(request);
				if (uas.logout()) {
					rd = request.getRequestDispatcher("AdminWorks");
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}
				break;
			case "unregister":

				break;
			default:
				rd = request.getRequestDispatcher("AdminWorks");
				break;
		}

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		String action = request.getParameter("action");
		action = action == null ? "" : action;
		switch (action) {
			case "login":
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				User loggingUser = new User();
				if (!login.isEmpty() && !password.isEmpty()) {
					loggingUser.setLogin(login);
					loggingUser.setPassword(password);
					UserAuthorizationService uas = new UserAuthorizationService(request);
					if (uas.login(loggingUser)) {
						rd = request.getRequestDispatcher("AdminWorks");
					} else {
						rd = request.getRequestDispatcher("access_denied.jsp");
					}
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}
				break;
			case "register":
				break;
			default:
				rd = request.getRequestDispatcher("AdminWorks");
				break;
		}

		rd.forward(request, response);
	}
}
