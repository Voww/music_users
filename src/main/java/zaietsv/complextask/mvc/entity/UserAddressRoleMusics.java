package zaietsv.complextask.mvc.entity;

import zaietsv.complextask.mvc.entity.instance.Address;
import zaietsv.complextask.mvc.entity.instance.Musics;
import zaietsv.complextask.mvc.entity.instance.Role;
import zaietsv.complextask.mvc.entity.instance.User;

public class UserAddressRoleMusics implements Entity {
	User user;
	Address address;
	Role role;
	Musics musics;

    public UserAddressRoleMusics() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Musics getMusics() {
        return musics;
    }

    public void setMusics(Musics musics) {
        this.musics = musics;
    }
}
