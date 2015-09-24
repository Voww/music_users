package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_acces_instance.MusicDAI;
import zaietsv.complextask.mvc.entity.instance.Music;
import zaietsv.complextask.mvc.entity.instance.Musics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class MusicsProcessor extends AbstractInstancesProcessor {

    public MusicsProcessor() {
    }

    public MusicsProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException {
        super(servletRequest, servletResponse, "music", new MusicDAI(new MusicUserConnector().getConnection()), new Musics());
    }

    @Override
    public Musics process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        System.out.println(this.getClass().getName() + " > action = " + action);

        switch (action) {
            case "insert":
                System.out.println("case 'insert':");
                String name = request.getParameter("name");
                int rating = Integer.parseInt(request.getParameter("rating"));
                Music newMusic = new Music(name, rating);
                dai.insert(newMusic);

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
                System.out.println(dai.update(updateMusic));
                break;
            case "delete":
                System.out.println("case delete:");
                id = Long.parseLong(request.getParameter("id"));
                System.out.println(dai.delete(id));
                break;
            case "details":
                System.out.println("case details:");
                //id = Long.parseLong(request.getParameter("id"));
                //System.out.println(dao.delete(id));
                break;
            default:
                System.out.println("default:");
                break;
        }

        this.instances.setInstances(dai.readAll());
        request.getSession().setAttribute("musics", this.instances);
        return (Musics)this.instances;
    }
}
