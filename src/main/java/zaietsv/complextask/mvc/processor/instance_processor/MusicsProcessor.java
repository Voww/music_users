package zaietsv.complextask.mvc.processor.instance_processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_object.MusicDAO;
import zaietsv.complextask.mvc.entity.instance.Music;
import zaietsv.complextask.mvc.entity.instance.Musics;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicsProcessor extends AbstractInstancesProcessor {

    public MusicsProcessor() {
    }

    public MusicsProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ConnectionException {
        super(servletRequest, servletResponse, "music", new MusicDAO(new MusicUserConnector().getConnection(servletRequest)), new Musics());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "insert":
                String name = request.getParameter("name");
                int rating = Integer.parseInt(request.getParameter("rating"));
                Music newMusic = new Music(name, rating);
                dao.insert(newMusic);

                break;
            case "edit":
                break;
            case "update":
                Long id = Long.parseLong(request.getParameter("id"));
                name = request.getParameter("name");
                rating = Integer.parseInt(request.getParameter("rating"));
                Music updateMusic = new Music(id, name, rating);
                dao.update(updateMusic);
                break;
            case "delete":
                id = Long.parseLong(request.getParameter("id"));
                dao.delete(id);
                break;
            case "details":
                //id = Long.parseLong(request.getParameter("id"));
                //dao.delete(id);
                break;
            default:
                break;
        }

        this.instances.setInstances(dao.readAll());
        request.getSession().setAttribute("musics", this.instances);
        return "musics_table.jsp";
    }
}
