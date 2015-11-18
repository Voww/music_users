package zaietsv.complextask.mvc.servlet;

import zaietsv.complextask.mvc.localization.Localization;
import zaietsv.complextask.mvc.localization.MusicUsersLocalization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Voww on 17.11.2015.
 */
@WebServlet("/LocalizationWorks")
public class LocalizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String langID = request.getParameter("langID");
        Localization localization =(Localization)request.getSession().getAttribute("l");
        if (localization == null) {
            localization = new MusicUsersLocalization();
            request.getSession().setAttribute("l", localization);
        }
        if (langID != null) {
            localization.setLocale(langID);
        }
    }
}
