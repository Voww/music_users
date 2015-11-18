package zaietsv.complextask.mvc.localization;

/**
 * Created by Voww on 17.11.2015.
 */
public interface Localization {

    void setLocale(String localeId);

    String getLanguageId();

   Object tr(String trKey);
}
