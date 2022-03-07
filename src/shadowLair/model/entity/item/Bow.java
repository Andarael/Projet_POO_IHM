// Fichier par Josué Raad

package shadowLair.model.entity.item;

/**
 * A Bow is a special class of Weapon that can use Arrows
 */
public class Bow extends Weapon {

    public static final double DEFAULT_WEIGHT = 2.0;
    public static final int DEFAULT_VALUE = 8;
    public static final int DEFAULT_DAMAGE = 3;
    private static final int ARROW_POWER = new Arrow().getPower();
    private int arrows;

    public Bow(String name,
               String shortName,
               String description,
               double weight,
               int value,
               int damage) {
        super(name, shortName, description, weight, value, damage);

        arrows = 0;
    }

    public Bow(int damage) {
        this("Bow", "Bow", "a wooden bow", DEFAULT_WEIGHT, DEFAULT_VALUE, damage);
    }

    public Bow() {
        this(DEFAULT_DAMAGE);
    }

    @Override
    public String getPrefix() {
        return "BOW  : ";
    }

    public void addArrow() {
        this.arrows++;
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
               + ", arrows : " + arrows;
    }
}
