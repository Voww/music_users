package zaietsv.complextask.mvc.servlet.admin;

import zaietsv.complextask.mvc.processor.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AdminInstancesServlet
 */
@WebServlet("/AdminInstancesServlet")
public class AdminInstancesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInstancesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DOGET");
		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DOPOST");
		String table = request.getParameter("table");
		table = table == null ? "" : table;

		InstancesProcessor instancesProcessor;
		RequestDispatcher rd;

		try {
			switch (table) {
				case "user":
					System.out.println("user table process");
					instancesProcessor = new UsersProcessor(request, response);
					instancesProcessor.process();
					rd = request.getRequestDispatcher("admin/users_table.jsp");
					rd.forward(request, response);
					break;
				case "role":
					System.out.println("role table process");
					instancesProcessor = new RolesProcessor(request,response);
					instancesProcessor.process();
					rd = request.getRequestDispatcher("admin/roles_table.jsp");
					rd.forward(request, response);
					break;
				case "address":
					System.out.println("address table process");
					instancesProcessor = new AddressesProcessor(request,response);
					instancesProcessor.process();
					rd = request.getRequestDispatcher("admin/addresses_table.jsp");
					rd.forward(request, response);
					break;
				case "music":
					System.out.println("music table process");
					instancesProcessor = new MusicsProcessor(request,response);
					instancesProcessor.process();
					rd = request.getRequestDispatcher("admin/musics_table.jsp");
					rd.forward(request, response);
					break;
				default:
					System.out.println("default table process");
					rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
