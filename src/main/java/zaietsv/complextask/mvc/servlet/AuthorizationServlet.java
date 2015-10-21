package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.authorization.UserAuthorizationService;
import zaietsv.complextask.mvc.entity.UserAddressRoleMusics;
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
				UserAuthorizationService uls = new UserAuthorizationService(request);
				if (uls.logout()) {
					rd = request.getRequestDispatcher("GuestWorks");
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}
				break;
			case "unregister":

				break;
			default:
				rd = request.getRequestDispatcher("GuestWorks");
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
				if (login != null && password != null) {
					loggingUser.setLogin(login);
					loggingUser.setPassword(password);
					UserAuthorizationService uls = new UserAuthorizationService(request);
					if (uls.login(loggingUser)) {
						UserAddressRoleMusics uarm = uls.getLoggedUser();
						String roleName;
						if (uarm.getRole() == null) {
							roleName = "guest";
						} else {
							roleName = uarm.getRole().getName();
						}
						switch (roleName) {
							case "admin":
								rd = request.getRequestDispatcher("AdminWorks");
								break;
							case "mandator":
								rd = request.getRequestDispatcher("MandatorWorks");
								break;
							case "user":
								rd = request.getRequestDispatcher("UserWorks");
								break;
							default:
								rd = request.getRequestDispatcher("access_denied.jsp");
								break;
						}
					} else {
						rd = request.getRequestDispatcher("GuestWorks");
					}
				} else {
					rd = request.getRequestDispatcher("GuestWorks");
				}
				break;
			case "logout":
				UserAuthorizationService uls = new UserAuthorizationService(request);
				if (uls.logout()) {
					rd = request.getRequestDispatcher("GuestWorks");
				} else {
					rd = request.getRequestDispatcher("error.jsp");
				}
				break;
			case "register":
				break;
			default:
				rd = request.getRequestDispatcher("GuestWorks");
				break;
		}

		rd.forward(request, response);
	}
}
