package zaietsv.complextask.mvc.processor.instance_detail_processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.data_access_object_detail.MusicUsersDAODs;
import zaietsv.complextask.mvc.entity.instance.Music;
import zaietsv.complextask.mvc.entity.instance.User;
import zaietsv.complextask.mvc.entity.instance.Users;
import zaietsv.complextask.mvc.entity.instance_detail.MusicUsers;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Voww on 18.09.2015.
 */
public class MusicUsersProcessor extends AbstractInstanceDetailsProcessor {

    public MusicUsersProcessor() {
    }

    public MusicUsersProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ConnectionException {
        super(servletRequest, servletResponse, "music_users", new MusicUsersDAODs(new MusicUserConnector().getConnection(servletRequest)), new MusicUsers());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "insert":
                String str_id = request.getParameter("id");

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                Users newUsers = new Users();
                newUsers.getInstances().add(new User(login, password, email));
                if (str_id == null) {
                    String name = request.getParameter("name");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    Music newMusic = new Music(name, rating);
                    MusicUsers musicUsers = new MusicUsers(newMusic, newUsers);
                    daods.insert(musicUsers);
                    daods.read(musicUsers);
                    request.getSession().setAttribute("musicUsers", musicUsers);
                } else {
                    Long id = Long.parseLong(str_id);
                    daods.insert(id, newUsers);
                }
                break;
            case "edit":
                System.out.println("case 'edit':");
                break;
            case "update":
                System.out.println("case 'update':");
                Music updateMusic = null;
                String str_music_id = request.getParameter("music_id");
                if (str_music_id != null) {
                    Long music_id = Long.parseLong(str_music_id);
                    String name = request.getParameter("name");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    updateMusic = new Music(music_id, name, rating);
                }
                Users updateUsers = new Users();
                String str_user_id = request.getParameter("user_id");
                if (str_user_id != null) {
                    Long user_id = Long.parseLong(str_user_id);
                    login = request.getParameter("login");
                    password = request.getParameter("password");
                    email = request.getParameter("email");

                    updateUsers.getInstances().add(new User(user_id, login, password, email));
                }
                System.out.println(daods.update(new MusicUsers(updateMusic, updateUsers)));
                break;
            case "unlink":
                System.out.println("case unlink:");
                str_id = request.getParameter("id");
                str_user_id = request.getParameter("user_id");
                if (str_id != null && str_user_id != null) {
                    daods.unlink(Long.parseLong(str_id), Long.parseLong(str_user_id));
                } else if (str_id != null) {
                    System.out.println(daods.unlink(Long.parseLong(str_id)));
                }
                break;
            case "delete":
                System.out.println("case delete:");
                str_id = request.getParameter("id");
                Long id = 0L;
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                }
                str_user_id = request.getParameter("user_id");
                Long user_id = 0L;
                if (str_user_id != null) {
                    user_id = Long.parseLong(str_user_id);
                }
                daods.delete(id, user_id);
                break;
            default:
                System.out.println("default:");
                break;
        }
        String str_id = request.getParameter("id");
        if (str_id != null) {
            instanceDetails = daods.read(Long.parseLong(str_id));
            System.out.println("instanceDetails=" + instanceDetails);
            if (instanceDetails == null) {
                request.getSession().removeAttribute("musicUsers");
            } else {
                request.getSession().setAttribute("musicUsers", instanceDetails);
            }
        }
        return "music_users_table.jsp";
    }
}
