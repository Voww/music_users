package zaietsv.complextask.mvc.processor;

import zaietsv.complextask.mvc.connect.MusicUserConnector;
import zaietsv.complextask.mvc.dao.UserAddressRoleMusicsDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.AddressDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.MusicDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.RoleDAO;
import zaietsv.complextask.mvc.dao.data_acces_object.UserDAO;
import zaietsv.complextask.mvc.dao.data_access_link_object_detail.UserAddressLinkDAO;
import zaietsv.complextask.mvc.dao.data_access_link_object_detail.UserMusicLinkDAO;
import zaietsv.complextask.mvc.dao.data_access_link_object_detail.UserRoleLinkDAO;
import zaietsv.complextask.mvc.entity.UserAddressRoleMusics;
import zaietsv.complextask.mvc.entity.instance.*;
import zaietsv.complextask.mvc.exception.ConnectionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Voww on 18.09.2015.
 */
public class UserAddressRoleMusicsProcessor extends AbstractProcessor {

    public UserAddressRoleMusicsProcessor() {
    }

    public UserAddressRoleMusicsProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws SQLException, ConnectionException {
        super(servletRequest, servletResponse, "music_users", new UserAddressRoleMusicsDAO(new MusicUserConnector().getConnection(servletRequest)), new UserAddressRoleMusics());
    }

    @Override
    public String process() {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
    try {
        Connection connection = new MusicUserConnector().getConnection(request);
        switch (action) {
            case "change_role":
                try {
                    RoleDAO rdao = new RoleDAO(new MusicUserConnector().getConnection(request));
                    Roles roles = new Roles();
                    roles.setInstances(rdao.readAll());
                    request.getSession().setAttribute("roles", roles);
                } catch (ConnectionException e) {
                    e.printStackTrace();
                }
                break;
            case "change_music":
                String str_id = request.getParameter("id");
                    Long id = Long.parseLong(str_id);
                    MusicDAO mdao = new MusicDAO(connection);
                    Musics listed_musics = new Musics();
                    listed_musics.setInstances(mdao.readAll());
                    UserMusicLinkDAO umld = new UserMusicLinkDAO(connection);
                    String ref = request.getHeader("referer");
                    request.getSession().setAttribute("selected_musics", umld.readLink(id));
                    request.getSession().setAttribute("listed_musics", listed_musics);
                break;
            case "confirm_musics":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    String[] a_str_musics_id = request.getParameterValues("musics_id");
                    umld = new UserMusicLinkDAO(connection);
                    ArrayList<Music> musicList = new MusicDAO(connection).readAll();
                    if (a_str_musics_id == null) {
                        for (Music music : musicList) {
                            umld.deleteLink(id, music.getId());
                        }
                    } else {
                        Long[] a_musics_id = new Long[a_str_musics_id.length];
                        for (int i = 0; i < a_str_musics_id.length; i++) {
                            a_musics_id[i] = Long.parseLong(a_str_musics_id[i]);
                        }
                        for (Music music : musicList) {
                            int position = Arrays.binarySearch(a_musics_id, music.getId());
                            if (position < 0) {
                                umld.deleteLink(id, music.getId());
                            } else if (umld.insertLink(id, music.getId()) < 0) {
                                umld.updateLink(id, music.getId());
                            }
                        }
                    }
                }
                break;
            case "confirm_role":
                str_id = request.getParameter("id");
                    if (str_id != null) {
                        id = Long.parseLong(str_id);

                        String str_role_id = request.getParameter("role_id");
                        UserRoleLinkDAO urld = new UserRoleLinkDAO(connection);
                        if (str_role_id != null) {
                            Long role_id = Long.parseLong(str_role_id);
                            if (urld.insertLink(id, role_id) < 0) {
                                urld.updateLink(id, role_id);
                            }
                        }
                    }
                break;

            case "insert":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    int postcode = Integer.parseInt(request.getParameter("postcode"));
                    String city = request.getParameter("city");
                    String street = request.getParameter("street");
                    int house = Integer.parseInt(request.getParameter("house"));
                    int flat = Integer.parseInt(request.getParameter("flat"));
                    Address newAddress = new Address(postcode, city, street, house, flat);
                    AddressDAO adao = new AddressDAO(connection);
                    if (adao.insert(newAddress) >= 0) {
                        UserAddressLinkDAO uald = new UserAddressLinkDAO(connection);
                        uald.insertLink(id, adao.read(newAddress));
                    }
                }

                break;
            case "edit":
                ;
                break;
            case "update":
                String str_address_id = request.getParameter("address_id");
                if (str_address_id != null) {
                    Long address_id = Long.parseLong(str_address_id);
                    int postcode = Integer.parseInt(request.getParameter("postcode"));
                    String city = request.getParameter("city");
                    String street = request.getParameter("street");
                    int house = Integer.parseInt(request.getParameter("house"));
                    int flat = Integer.parseInt(request.getParameter("flat"));
                    Address updateAddress = new Address(address_id, postcode, city, street, house, flat);
                    AddressDAO adao = new AddressDAO(connection);
                    adao.update(updateAddress);
                }
                String str_user_id = request.getParameter("user_id");
                if (str_user_id != null) {
                    Long user_id = Long.parseLong(str_user_id);
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    String email = request.getParameter("email");
                    User updateUser = new User(user_id, login, password, email);
                    UserDAO udao = new UserDAO(connection);
                    udao.update(updateUser);
                }
            /*case "unlink":
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
                break;*/
            default:
                System.out.println("default:");
                break;
        }


        String str_id = request.getParameter("id");
        if (str_id != null) {
            uarm = dao.read(Long.parseLong(str_id));
            //System.out.println("instanceDetails=" + entity);
            if (uarm == null) {
                request.getSession().removeAttribute("userAddressRoleMusics");
            } else {
                Role role = uarm.getRole();
                if (role == null) {
                    role = new Role("user");
                    RoleDAO rdao = new RoleDAO(connection);
                    rdao.read(role);
                    uarm.setRole(role);
                }
                request.getSession().setAttribute("userAddressRoleMusics", uarm);
            }
        }
    } catch (ConnectionException e) {
        e.printStackTrace();
    }
        return "admin/user_address_role_musics_table.jsp";
    }
}
