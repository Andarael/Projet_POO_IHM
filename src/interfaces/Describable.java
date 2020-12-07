package interfaces;

public interface Describable extends Shortenable {
    String getName();

    String getDescription();

    default String getSimpleDisplay() {
        String output = "(" + getShortName().trim() + ") " + getName();
        if (getDescription() != null)
            return output + " : " + getDescription();
        return output;
    }

    String getDisplay();

    default String print() {
        return getDisplay();
    }

    void updateDescription(String update);

}
