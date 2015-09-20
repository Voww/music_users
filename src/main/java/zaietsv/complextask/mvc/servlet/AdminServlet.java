package zaietsv.complextask.mvc.servlet;

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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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

		Processor processor;
		RequestDispatcher rd;

		try {
			switch (table) {
				case "user":
					System.out.println("user table process");
					processor = new UserProcessor(request, response);
					processor.process();
					rd = request.getRequestDispatcher("table/user_table.jsp");
					rd.forward(request, response);
					break;
				case "role":
					System.out.println("role table process");
					processor = new RoleProcessor(request,response);
					processor.process();
					rd = request.getRequestDispatcher("table/role_table.jsp");
					rd.forward(request, response);
					break;
				case "address":
					System.out.println("address table process");
					processor = new AddressProcessor(request,response);
					processor.process();
					rd = request.getRequestDispatcher("table/address_table.jsp");
					rd.forward(request, response);
					break;
				case "music":
					System.out.println("music table process");
					processor = new MusicProcessor(request,response);
					processor.process();
					rd = request.getRequestDispatcher("table/music_table.jsp");
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
