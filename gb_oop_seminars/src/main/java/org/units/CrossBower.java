package org.units;

import abstractUnits.Shooter;
import abstractUnits.Unit;

import java.util.List;

public class CrossBower extends Shooter {
    public CrossBower(String name, int x, int y, List<Unit> enemyes) {
        super(75,
              75,
              2,
              name,
              new int[]{10,15},
             4,
             20,
             50,
             x,
             y,
             enemyes);
    }
    @Override
    public String toString() {
        return "Арбалетчик " +
                name +
                ", здоровье - " +
                health + "/"+healthMax +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y + ")"+
                ", ближ. соперник - " + nearEnemy(enemyes);
    }
}
