package zaietsv.complextask.mvc.localization;

import java.util.ListResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersBundle_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {

            //pages
            {"indexPage", "Index page"},
            {"guestPage", "Guest's page"},
            {"userPage", "User's page"},
            {"mandatorPage", "Mandator's page"},
            {"adminPage", "Administrator's page"},

            {"guestPageText", "Common information for non-authorized visitors."},
            {"userPageText", "Common information for authorized users."},
            {"mandatorPageText", "Special information for authorized mandators."},
            {"adminPageText", "Special information for authorized administrators."},

            {"loginPageRedirect", "You can perform an authorization at "},
            {"atLoginPage", "login page"},
            {"logIn", "Log in"},
            {"langSelect", "languages selector"},

            //controls
            {"backwardButton", "Backward"},
            {"detailsButton", "details"},
            {"editButton", "edit"},
            {"changeButton", "change"},
            {"unlinkButton", "unlink"},
            {"deleteButton", "delete"},
            {"cancelButton", "cancel"},

            //headers
            {"musicTable", "Music styles"},
            {"addressTable", "Address table"},
            {"roleTable", "Role table"},
            {"userTable", "User table"},
            {"userAccountTable", "User account table"},

            {"addressUserTable", "Address To User table"},
            {"musicUsersTable", "Music To Users table"},
            {"roleUsersTable", "Role To Users table"},
            {"userAddressRoleMusicsTable", "User to Address, Role, Musics table"},

            {"userHeader", "User"},
            {"usersHeader", "Users"},
            {"roleHeader", "Role"},
            {"rolesHeader", "Roles"},
            {"addressHeader", "Address"},
            {"musicHeader", "Music"},
            {"musicsHeader", "Musics"},

            {"actionHeader", "Action"},
            {"idHeader", "Id.#"},
            {"nameHeader", "Name"},
            {"ratingHeader", "Rating"},
            {"postcodeHeader", "Postcode"},
            {"cityHeader", "City"},
            {"streetHeader", "Street"},
            {"houseHeader", "House"},
            {"flatHeader", "Flat"},
            {"loginHeader", "Login"},
            {"passwordHeader", "Password"},
            {"emailHeader", "Email"},
            {"regDateHeader", "Registration date"},
    };
}
