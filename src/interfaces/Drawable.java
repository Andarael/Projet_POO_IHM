package interfaces;

public interface Drawable extends Describable {

    default String draw() {
        System.out.println(getDisplay());
        return getShortName();
    }
}
