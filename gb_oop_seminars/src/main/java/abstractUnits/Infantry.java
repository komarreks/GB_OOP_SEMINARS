package abstractUnits;

import java.util.List;
import java.util.Random;

public abstract class Infantry extends Unit{
    public Infantry(String unitName, int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        super(unitName, health, healthMax, armor, name, damage, x, y, enemyes);
        isDodging = true;
        initiative = 2;
    }
    @Override
    public String toString() {
        return unitName + " " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - " + armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }

    @Override
    public void step() {

    }
}
