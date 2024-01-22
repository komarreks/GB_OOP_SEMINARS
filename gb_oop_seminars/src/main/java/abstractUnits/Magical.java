package abstractUnits;

import java.util.List;

public abstract class Magical extends Unit{
    public Magical(String unitName, int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        super(unitName, health, healthMax, armor, name, damage, x, y, enemyes);
        initiative = 1;
    }

    @Override
    public String toString() {
        return unitName + " " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }

    @Override
    public void step() {
        System.out.println(getCastName() + ": стоит и смотрит");
    }
}
