package org.units;

import abstractUnits.Magical;
import abstractUnits.Unit;

import java.util.List;

public class Monk extends Magical {
    public Monk(String name, int x, int y, List<Unit> enemyes) {
        super(50,
                50,
                1,
                name,
                new int[]{0,0},
                x,
                y,
                enemyes);
    }
    @Override
    public String toString() {
        return "Монах " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
