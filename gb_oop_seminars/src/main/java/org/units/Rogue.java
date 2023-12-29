package org.units;

import abstractUnits.Infantry;
import abstractUnits.Unit;

import java.util.List;

public class Rogue extends Infantry {
    public Rogue(String name, int x, int y, List<Unit> enemyes) {
        super(100,
                100,
                5,
                name,
                new int[]{20,30},
                x,
                y,
                enemyes);
    }
    @Override
    public String toString() {
        return "Разбойник " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - " + armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
