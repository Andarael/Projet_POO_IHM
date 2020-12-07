package interfaces;

public interface Descriptable extends Shortable {

    String getName();

    String getDescription();

    default String getSimpleDisplay() {
        String output = "(" + getShortName().trim() + ") " + getName();
        if (getDescription() != null)
            return output + " : " + getDescription();
        return  output;
    }

    String getDisplay();


    default String print() {
        return getClass().getSimpleName() + " {" +
               getDisplay() +
               "}";
    }

}
