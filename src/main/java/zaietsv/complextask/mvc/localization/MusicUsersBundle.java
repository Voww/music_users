package zaietsv.complextask.mvc.localization;

import java.util.ListResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"ukrainian", "українська"},
            {"french", "français"},
            {"english", "english"},
            {"russian", "русский"},
            {"langSelect", "Вибір мови"},
    };
}
