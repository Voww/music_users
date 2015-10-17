package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.authorization.UserLoginService;
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
				if (login != null && password != null) {
					loggingUser.setLogin(login);
					loggingUser.setPassword(password);
					UserLoginService uls = new UserLoginService(request);
					if (uls.login(loggingUser)) {
						switch (uls.getLoggedUser().getRole().getName()) {
							case "admin":
								rd = request.getRequestDispatcher("admin.jsp");
								break;
							case "mandator":
								rd = request.getRequestDispatcher("mandator.jsp");
								break;
							case "user":
								rd = request.getRequestDispatcher("user.jsp");
								break;
							default:
								rd = request.getRequestDispatcher("index.jsp");
								break;
						}
					} else {
						rd = request.getRequestDispatcher("error.jsp");
					}
				}
				break;
			case "logout":
				UserLoginService uls = new UserLoginService(request);
				if (uls.logout()) {
					rd = request.getRequestDispatcher("index.jsp");
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}
				break;
			case "register":
				break;
			case "unregister":
				break;
			default:
				rd = request.getRequestDispatcher("index.jsp");
				break;
		}

		rd.forward(request, response);
	}
}
