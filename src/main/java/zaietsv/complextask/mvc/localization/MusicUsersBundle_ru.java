package zaietsv.complextask.mvc.localization;

import java.util.ListResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersBundle_ru extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"indexPage", "Стартовая страница"},
            {"guestPage", "Гостевая страница"},
            {"guestPageText", "Общая информация для неавторизованных посетителей."},
            {"loginPageRedirect", "Вы можете выполнить авторизацию на "},
            {"atLoginPage", "странице входа"},
            {"logIn", "Войти"},
            {"langSelect", "Выбор языков"},
            {"musicTable", "Музыкальные стили"},

            //controls
            {"backwardButton", "Вернуться"},

            //headers
            {"idHeader", "Ид.№"},
            {"nameHeader", "Наименование"},
            {"ratingHeader", "Рейтинг"},
    };
}
