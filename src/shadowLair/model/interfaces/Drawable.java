// Fichier par Josué Raad

package shadowLair.model.interfaces;

import shadowLair.model.utils.Shortener;

import static shadowLair.model.utils.StringUtils.stringFill;

public interface Drawable extends Describable {

    default String draw() {
        int MAX_LENGTH = Shortener.SHORT_NAME_SIZE;
        return (getShortName() + stringFill(MAX_LENGTH, ' ')).substring(0, MAX_LENGTH);
    }
}
