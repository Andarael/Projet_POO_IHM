package controller;

import java.net.URL;

public interface RessourceManager {

    static URL getRessource(String ressourceName, String ext, Object caller) {

        String ressourcePath = "../view/images/";

        URL url = caller.getClass().getResource(ressourcePath + ressourceName + ext);

        if (url == null)
            return caller.getClass().getResource("../view/images/error.png");

        return url;
    }

    static String getRessourceString(String ressourceName, String ext, Object caller) {
        return getRessource(ressourceName, ext, caller).toString();
    }
}
