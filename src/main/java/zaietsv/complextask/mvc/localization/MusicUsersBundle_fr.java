package zaietsv.complextask.mvc.localization;

import java.util.ListResourceBundle;

/**
 * Created by Voww on 17.11.2015.
 */
public class MusicUsersBundle_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"indexPage", "Page d'accueil"},
            {"guestPage", "Page d'visiteurs"},
            {"guestPageText", "Informations communes pour les visiteurs non autorisés."},
            {"loginPageRedirect", "Vous pouvez effectuer une autorisation à la "},
            {"atLoginPage", "page de login"},
            {"logIn", "Identifiant"},
            {"langSelect", "langues sélectionner"},
            {"musicTable", "Styles de musique"},

            //controls
            {"backwardButton", "Arrière"},

            //headers
            {"idHeader", "Id.#"},
            {"nameHeader", "Nom"},
            {"ratingHeader", "Évaluation"},
    };
}
