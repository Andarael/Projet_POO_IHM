package interfaces;

public interface Lookable extends Describable {

    default String look() {
        System.out.println(getDisplay());
        return getDisplay();
    }

}
