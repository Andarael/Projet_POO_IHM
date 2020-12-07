package interfaces;

public interface Lookable extends Descriptable{

    default String look() {
        System.out.println(getDisplay());
        return getDisplay();
    }

}
