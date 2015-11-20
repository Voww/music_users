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

            //pages
            {"indexPage", "Page d'accueil"},
            {"guestPage", "Page d'visiteurs"},
            {"userPage", "La page de l'utilisateur"},
            {"mandatorPage", "La page de mandant"},
            {"adminPage", "La page de l'administrateur"},

            {"guestPageText", "Informations communes pour les visiteurs non autorisés."},
            {"userPageText", "Informations communes pour les utilisateurs autorisés."},
            {"mandatorPageText", "Information spécial pour mandants autorisés."},
            {"adminPageText", "Information spécial pour administrateurs autorisés."},

            {"loginPageRedirect", "Vous pouvez effectuer une autorisation à la "},
            {"atLoginPage", "page de login"},
            {"logIn", "Identifiant"},
            {"langSelect", "langues sélectionner"},

            //controls
            {"backwardButton", "Arrière"},
            {"detailsButton", "détails"},
            {"editButton", "éditer"},
            {"changeButton", "changer"},
            {"unlinkButton", "supprimer le lien"},
            {"deleteButton", "effacer"},
            {"cancelButton", "annuler"},

            //headers
            {"musicTable", "Styles de musique"},
            {"addressTable", "Table des adresses"},
            {"roleTable", "Table de Rôle"},
            {"userTable", "Table de l'utilisateur"},
            {"userAccountTable", "Table de compte d'utilisateur"},

            {"addressUserTable", "Table d'adresses des utilisateurs"},
            {"musicUsersTable", "Table d'styles musicaux des utilisateurs"},
            {"roleUsersTable", "Table d'rôles des utilisateurs"},
            {"userAddressRoleMusicsTable", "Table d'adresses, d'rôles et d'styles musicaux des utilisateurs"},

            {"userHeader", "Utilisateur"},
            {"usersHeader", "Utilisateurs"},
            {"roleHeader", "Rôle"},
            {"rolesHeader", "Rôles"},
            {"addressHeader", "Adresse"},
            {"musicHeader", "Musique"},
            {"musicsHeader", "Musiques"},

            {"actionHeader", "Action"},
            {"idHeader", "Id.#"},
            {"nameHeader", "Nom"},
            {"ratingHeader", "Évaluation"},
            {"postcodeHeader", "Code postale"},
            {"cityHeader", "Ville"},
            {"streetHeader", "Rue"},
            {"houseHeader", "Maison"},
            {"flatHeader", "Appartement"},
            {"loginHeader", "S'identifier"},
            {"passwordHeader", "Mot de passe"},
            {"emailHeader", "Courriel"},
            {"regDateHeader", "Date d'enregistrement"},
    };
}
