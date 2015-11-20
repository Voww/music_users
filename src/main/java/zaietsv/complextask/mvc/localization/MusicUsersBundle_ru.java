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

            //pages
            {"indexPage", "Стартовая страница"},
            {"guestPage", "Гостевая страница"},
            {"userPage", "Страница пользователя"},
            {"mandatorPage", "Страница персонала"},
            {"adminPage", "Страница администратора"},

            {"guestPageText", "Общая информация для неавторизованных посетителей."},
            {"userPageText", "Общая информация для авторизованных пользователей."},
            {"mandatorPageText", "Специальная информация для авторизованного персонала."},
            {"adminPageText", "Специальная информация для авторизованных администраторов."},

            {"loginPageRedirect", "Вы можете выполнить авторизацию на "},
            {"atLoginPage", "странице входа"},
            {"logIn", "Войти"},
            {"langSelect", "Выбор языков"},

            //controls
            {"backwardButton", "Вернуться"},
            {"detailsButton", "детали"},
            {"editButton", "редактировать"},
            {"changeButton", "изменить"},
            {"unlinkButton", "оторвать"},
            {"deleteButton", "удалить"},
            {"cancelButton", "отменить"},

            //headers
            {"musicTable", "Таблица музыкальных стилей"},
            {"addressTable", "Таблица адресов"},
            {"roleTable", "Таблица ролей"},
            {"userTable", "Таблица пользователей"},
            {"userAccountTable", "Таблица аккаунта пользователя"},

            {"addressUserTable", "Таблица адресов пользователей"},
            {"musicUsersTable", "Таблица музыкальных стилей пользователей"},
            {"roleUsersTable", "Таблица ролей пользователей"},
            {"userAddressRoleMusicsTable", "Таблица адреса, роли и музыкальных стилей пользователя"},

            {"userHeader", "Пользователь"},
            {"usersHeader", "Пользователи"},
            {"roleHeader", "Роль"},
            {"rolesHeader", "Роли"},
            {"addressHeader", "Адрес"},
            {"musicHeader", "Музыкальный стиль"},
            {"musicsHeader", "Музыкальные стили"},

            {"actionHeader", "Действие"},
            {"idHeader", "Ид.№"},
            {"nameHeader", "Наименование"},
            {"ratingHeader", "Рейтинг"},
            {"postcodeHeader", "Почтовый индекс"},
            {"cityHeader", "Город"},
            {"streetHeader", "Улица"},
            {"houseHeader", "Дом"},
            {"flatHeader", "Квартира"},
            {"loginHeader", "Логин"},
            {"passwordHeader", "Пароль"},
            {"emailHeader", "Адрес электронной почты"},
            {"regDateHeader", "Дата регистрации"},
    };
}
