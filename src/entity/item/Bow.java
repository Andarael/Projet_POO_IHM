package entity.item;

/**
 * A Bow is a special class of Weapon that can use Arrows
 *
 */
public class Bow extends Weapon {

    private int arrows;

    public static final double DEFAULT_WEIGHT = 3.0;

    private static final int ARROW_POWER = new Arrow().getPower();

    public Bow(String name, String description, double weight, int value, int damage) {
        super(name, description, weight, value, damage);
        PREFIX = "BOW  ";
        arrows = 0;
    }

    public Bow(String name, String description, int damage) {
        this(name, description, DEFAULT_WEIGHT, damage, damage);
    }

    public void addArrow() {
        this.arrows ++;
    }

    public int getArrows() {
        return arrows;
    }

    public int getPowerNoConsume() {
        if (arrows < 1)
            return super.getPower();
        else
            return super.getPower() + ARROW_POWER;
    }

    @Override
    public int getPower() {
        int result;
        result = getPowerNoConsume();
        if (arrows > 0)
            arrows--;
        return result;
    }

    @Override
    public String getDisplay() {
        return super.getDisplay()
                + "arrows : " + arrows;
    }
}
