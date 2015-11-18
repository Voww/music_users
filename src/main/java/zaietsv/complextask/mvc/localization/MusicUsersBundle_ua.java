package zaietsv.complextask.mvc.localization;

import java.util.ListResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersBundle_ua extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"indexPage", "Стартова сторінка"},
            {"guestPage", "Гостьова сторінка"},
            {"guestPageText", "Загальна інформація для неавторизованих відвідувачів."},
            {"loginPageRedirect", "Ви можете виконати авторизацію на "},
            {"atLoginPage", "сторінці входу"},
            {"logIn", "Увійти"},
            {"langSelect", "Вибір мов"},
            {"musicTable", "Музичні стилі"},

            //controls
            {"backwardButton", "Повернутися"},

            //headers
            {"idHeader", "Ід.№"},
            {"nameHeader", "Назва"},
            {"ratingHeader", "Популярність"},

    };
}
