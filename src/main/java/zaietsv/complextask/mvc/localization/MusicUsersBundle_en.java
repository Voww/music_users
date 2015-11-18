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
            {"indexPage", "Index page"},
            {"guestPage", "Guest's page"},
            {"guestPageText", "Common information for non-authorized visitors."},
            {"loginPageRedirect", "You can perform an authorization at "},
            {"atLoginPage", "login page"},
            {"logIn", "Log in"},
            {"musicTable", "Music styles"},

            //controls
            {"backwardButton", "Backward"},

            //headers
            {"idHeader", "Id.#"},
            {"nameHeader", "Name"},
            {"ratingHeader", "Rating"},
    };
}
