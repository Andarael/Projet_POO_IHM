package view;

import java.net.URL;

public interface RessourceManager {

    String ressourcePath = "./ressources";

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

    static String getRessourceString(String ressourceName, String ext) {
        return getRessource(ressourceName, ext).toString();
    }
}
