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
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Voww on 18.09.2015.
 */
public class UserAddressRoleMusicsProcessor extends AbstractProcessor {

    public UserAddressRoleMusicsProcessor() {
    }

    public UserAddressRoleMusicsProcessor(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ConnectionException {
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
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User newUser = new User(login, password, email);
                UserDAO udao = new UserDAO(connection);
                udao.insert(newUser);
                break;
            case "insert_address":
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
            case "insert_role":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    RoleDAO rdao = new RoleDAO(connection);
                    Role newRole = new Role(request.getParameter("name"));
                    rdao.insert(newRole);
                    rdao.read(newRole);
                    UserRoleLinkDAO urld = new UserRoleLinkDAO(connection);
                    urld.insertLink(id, newRole.getId());
                }
                break;
            case "insert_music":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    mdao = new MusicDAO(connection);
                    Music newMusic = new Music();
                    newMusic.setName(request.getParameter("name"));
                    newMusic.setRating(Integer.parseInt(request.getParameter("rating")));
                    mdao.insert(newMusic);
                    mdao.read(newMusic);
                    umld = new UserMusicLinkDAO(connection);
                    umld.insertLink(id, newMusic.getId());
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
                    login = request.getParameter("login");
                    password = request.getParameter("password");
                    email = request.getParameter("email");
                    User updateUser = new User(user_id, login, password, email);
                    udao = new UserDAO(connection);
                    udao.update(updateUser);
                }
                break;
            case "unlink":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    UserAddressLinkDAO uald = new UserAddressLinkDAO(connection);
                    uald.deleteLink(id);
                    UserRoleLinkDAO urld = new UserRoleLinkDAO(connection);
                    urld.deleteLink(id);
                    umld = new UserMusicLinkDAO(connection);
                    umld.deleteLink(id);
                }
                break;
            case "unlink_address":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    str_address_id = request.getParameter("address_id");
                    if (str_address_id != null) {
                        Long address_id = Long.parseLong(str_address_id);
                        UserAddressLinkDAO uald = new UserAddressLinkDAO(connection);
                        uald.deleteLink(id, address_id);
                    }
                }
                break;
            case "unlink_role":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    String str_role_id = request.getParameter("role_id");
                    if (str_role_id != null) {
                        Long role_id = Long.parseLong(str_role_id);
                        UserRoleLinkDAO urld = new UserRoleLinkDAO(connection);
                        urld.deleteLink(id, role_id);
                    }
                }
                break;
            case "unlink_music":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    String str_music_id = request.getParameter("music_id");
                    if (str_music_id != null) {
                        Long music_id = Long.parseLong(str_music_id);
                        umld = new UserMusicLinkDAO(connection);
                        umld.deleteLink(id, music_id);
                    }
                }
                break;
            case "delete":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    UserAddressLinkDAO uald = new UserAddressLinkDAO(connection);
                    ArrayList<Long> address_list = uald.readLink(id);
                    if (address_list.size() > 0) {
                        Long address_id = address_list.get(0);
                        AddressDAO adao = new AddressDAO(connection);
                        uald.deleteLink(id);
                        adao.delete(address_id);
                    }
                    UserRoleLinkDAO urld = new UserRoleLinkDAO(connection);
                    urld.deleteLink(id);
                    umld = new UserMusicLinkDAO(connection);
                    umld.deleteLink(id);
                    udao = new UserDAO(connection);
                    udao.delete(id);
                }
                break;
            case "delete_address":
                str_id = request.getParameter("id");
                if (str_id != null) {
                    id = Long.parseLong(str_id);
                    str_address_id = request.getParameter("address_id");
                    if (str_address_id != null) {
                        Long address_id = Long.parseLong(str_address_id);
                        UserAddressLinkDAO uald = new UserAddressLinkDAO(connection);
                        uald.deleteLink(id, address_id);
                        AddressDAO adao = new AddressDAO(connection);
                        adao.delete(address_id);
                    }
                }
                break;
            default:
                ;
                break;
        }

        String str_id = request.getParameter("id");
        if (str_id != null) {
            uarm = dao.read(Long.parseLong(str_id));
            if (uarm == null) {
                request.getSession().removeAttribute("userAddressRoleMusics");
            } else {
                request.getSession().setAttribute("userAddressRoleMusics", uarm);
            }
        }
    } catch (ConnectionException e) {
        e.printStackTrace();
    }
        return "user_address_role_musics_table.jsp";
    }
}
