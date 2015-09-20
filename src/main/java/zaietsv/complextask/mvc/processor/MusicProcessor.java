package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.MusicDAO;
import zaietsv.complextask.mvc.holder.MusicHolder;
import zaietsv.complextask.mvc.instance.Music;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Voww on 18.09.2015.
 */
public class MusicProcessor extends AbstractProcessor {

    public MusicProcessor() {
    }

    public MusicProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "music", new MusicDAO(new MusicUserConnector().getConnection()), new MusicHolder());
    }

    @Override
    public MusicHolder process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                System.out.println("case 'insert':");
                String name = request.getParameter("name");
                int rating = Integer.parseInt(request.getParameter("rating"));
                Music newMusic = new Music(name, rating);
                dao.insert(newMusic);

                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Long id = Long.parseLong(request.getParameter("id"));
                name = request.getParameter("name");
                rating = Integer.parseInt(request.getParameter("rating"));
                Music updateMusic = new Music(id, name, rating);
                System.out.println(updateMusic);
                System.out.println(dao.update(updateMusic));
                break;
            case "delete":
                System.out.println("case delete:");
                id = Long.parseLong(request.getParameter("id"));
                System.out.println(dao.delete(id));
                break;

            default:
                System.out.println("default:");
                break;
        }

        this.holder.setList(dao.readAll());
        request.getSession().setAttribute("musicHolder", this.holder);
        return (MusicHolder)this.holder;
    }
}
