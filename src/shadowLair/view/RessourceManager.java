package shadowLair.view;

import java.net.URL;

/**
 * This Interface aims to streamline the access to ressources in the application view
 * For the moment only css and png are managed
 */
public interface RessourceManager {

    String ressourcePath = "./ressources";

    /**
     * takes the name of a ressource and return the full url to it
     */
    static URL getRessource(String ressourceName, String ext) {
        String path = "";

        if (ext.equals(".png"))
            path = ressourcePath + "/images/" + ressourceName + ext;

        else if (ext.equals(".css"))
            path = ressourceName + "/css/" + ressourceName + ext;

        URL url = RessourceManager.class.getResource(path);

        if (url == null) {
            url = RessourceManager.class.getResource(ressourcePath + "/images/" + "error.png");
            if (url == null)
                throw new NullPointerException("url null");
        }

        return url;
    }


    /**
     * takes the name of a ressource and return the full url to it
     */
    static String getRessourceString(String ressourceName, String ext) {
        return getRessource(ressourceName, ext).toString();
    }
}
