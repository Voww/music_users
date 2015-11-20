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

            //pages
            {"indexPage", "Стартова сторінка"},
            {"guestPage", "Гостьова сторінка"},
            {"userPage", "Сторінка користувача"},
            {"mandatorPage", "Сторінка персонала"},
            {"adminPage", "Сторінка адміністратора"},

            {"guestPageText", "Загальна інформація для неавторизованих відвідувачів."},
            {"userPageText", "Загальна інформація для авторизованих користувачів."},
            {"mandatorPageText", "Спеціальна інформація для авторизованого персонала."},
            {"adminPageText", "Спеціальна інформація для авторизованих адміністраторів."},

            {"loginPageRedirect", "Ви можете виконати авторизацію на "},
            {"atLoginPage", "сторінці входу"},
            {"logIn", "Увійти"},
            {"langSelect", "Вибір мов"},

            //controls
            {"backwardButton", "Повернутися"},
            {"detailsButton", "деталі"},
            {"editButton", "редагувати"},
            {"changeButton", "змінити"},
            {"unlinkButton", "відірвати"},
            {"deleteButton", "видалити"},
            {"cancelButton", "відмінити"},

            //headers
            {"musicTable", "Таблиця музичних стилей"},
            {"addressTable", "Таблиця адрес"},
            {"roleTable", "Таблиця ролей"},
            {"userTable", "Таблиця користувачів"},
            {"userAccountTable", "Таблиця акаунта користувача"},

            {"addressUserTable", "Таблиця адрес користувачів"},
            {"musicUsersTable", "Таблиця музичних стилів користувачів"},
            {"roleUsersTable", "Таблиця ролей користувачів"},
            {"userAddressRoleMusicsTable", "Таблиця адреси, ролі й музичних стилів користувача"},

            {"userHeader", "Користувач"},
            {"usersHeader", "Користувачі"},
            {"roleHeader", "Роль"},
            {"rolesHeader", "Ролі"},
            {"addressHeader", "Адреса"},
            {"musicHeader", "Музичний стиль"},
            {"musicsHeader", "Музичні стилі"},

            {"actionHeader", "Дія"},
            {"idHeader", "Ід.№"},
            {"nameHeader", "Назва"},
            {"ratingHeader", "Популярність"},
            {"postcodeHeader", "Поштовий індекс"},
            {"cityHeader", "Місто"},
            {"streetHeader", "Вулиця"},
            {"houseHeader", "Будинок"},
            {"flatHeader", "Помешкання"},
            {"loginHeader", "Псевдо"},
            {"passwordHeader", "Гасло"},
            {"emailHeader", "Адреса електронної пошти"},
            {"regDateHeader", "Дата реєстрації"},
    };
}
