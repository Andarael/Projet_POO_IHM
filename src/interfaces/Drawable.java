package interfaces;

public interface Drawable extends Describable {

    default String draw() {
        System.out.println(getShortName().trim());
        return getShortName().trim();
    }
}
