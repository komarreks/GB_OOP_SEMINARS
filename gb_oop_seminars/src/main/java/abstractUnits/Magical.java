package abstractUnits;

import java.util.List;

public abstract class Magical extends Unit{
    public Magical(int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        super(health, healthMax, armor, name, damage, x, y, enemyes);
    }
}
