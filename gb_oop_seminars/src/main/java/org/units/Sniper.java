package org.units;

import abstractUnits.Shooter;
import abstractUnits.Unit;

import java.util.List;

public class Sniper extends Shooter {
    public Sniper(String name, int x, int y, List<Unit> enemyes) {
        super(100,
                100,
                5,
                name,
                new int[]{40,60},
                4,
                20,
                40,
                x,
                y,
                enemyes);
    }
    @Override
    public String toString() {
        return "Снайпер " +
                name +
                ", здоровье - " +
                health + "/"+healthMax +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y + ")"+
                ", ближ. соперник - " + nearEnemy(enemyes);
    }
}
