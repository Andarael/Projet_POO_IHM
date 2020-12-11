// Fichier par Josué Raad

package interfaces;

import utils.Shortener;

import static utils.StringUtils.stringFill;

public interface Drawable extends Describable {

    default String draw() {
        int MAX_LENGTH = Shortener.SHORT_NAME_SIZE;
        return (getShortName() +  stringFill(MAX_LENGTH,' ')).substring(0,MAX_LENGTH);
    }
}
