package zaietsv.complextask.mvc.localization;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersLocalization implements Localization {

    private Locale locale;
    private String src = "zaietsv.complextask.mvc.localization.MusicUsersBundle";
    private ResourceBundle translator = ResourceBundle.getBundle(src);

    public static Localization getInstance(HttpServletRequest request) {
        String langID = request.getParameter("langID");
        Localization localization =(Localization)request.getSession().getAttribute("l");
        if (localization == null) {
            localization = new MusicUsersLocalization();
            request.getSession().setAttribute("l", localization);
        }
        if (langID != null) {
            localization.setLocale(langID);
        }
        return localization;
    }

    public MusicUsersLocalization() {
        locale = new Locale("ua");
        Locale.setDefault(locale);
    }

    @Override
    public void setLocale(String localeId) {
        locale = new Locale(localeId);
        translator = ResourceBundle.getBundle(src, locale);
    }

    @Override
    public String getLanguageId() {
        return locale.getLanguage();
    }

    @Override
    public Object tr(String translationKey) {
        return translator.getObject(translationKey);
    }
}
