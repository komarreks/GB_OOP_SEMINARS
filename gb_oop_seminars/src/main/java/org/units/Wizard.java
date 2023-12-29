package org.units;

import abstractUnits.Magical;
import abstractUnits.Unit;

import java.util.List;

public class Wizard extends Magical {
    public Wizard(String name, int x, int y, List<Unit> enemyes) {
        super(100,
                100,
                5,
                name,
                new int[]{-10,-30},
                x,
                y,
                enemyes);
    }
    @Override
    public String toString() {
        return "Колдун " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
