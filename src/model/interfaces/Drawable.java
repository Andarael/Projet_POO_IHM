// Fichier par Josué Raad

package model.interfaces;

import model.utils.Shortener;

import static model.utils.StringUtils.stringFill;

public interface Drawable extends Describable {

    default String draw() {
        int MAX_LENGTH = Shortener.SHORT_NAME_SIZE;
        return (getShortName() + stringFill(MAX_LENGTH, ' ')).substring(0, MAX_LENGTH);
    }
}
