package zaietsv.complextask.mvc.servlet.admin;

import zaietsv.complextask.mvc.factory.ProcessorFactory;
import zaietsv.complextask.mvc.processor.Processor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminInstancesServlet
 */
@WebServlet("/AdminWorks")
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

		ProcessorFactory factory = new ProcessorFactory();
		Processor processor = factory.getProcessor(request, response);

		String viewName = processor.process();
		System.out.println("viewName=" + viewName);
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DOPOST");

		ProcessorFactory factory = new ProcessorFactory();
		Processor processor = factory.getProcessor(request, response);

		String viewName = processor.process();
		System.out.println("viewName=" + viewName);
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
}
