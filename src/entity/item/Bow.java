package entity.item;

/**
 * A Bow is a special class of Weapon that can use Arrows
 *
 */
public class Bow extends Weapon {

    private int arrows;

    private static final int ARROW_POWER = new Arrow().getPower();

    public Bow(String name, String description, double weight, int value, int damage) {
        super(name, description, weight, value, damage);
    }


    public void addArrow() {
        this.arrows ++;
    }

    @Override
    public int getPower() {
        if (arrows < 1)
            return super.getPower();
        else
            arrows --;
            return super.getPower() + ARROW_POWER;
    }
}
