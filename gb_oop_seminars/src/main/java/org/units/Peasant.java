package org.units;

import abstractUnits.Unit;

import java.util.List;

public class Peasant extends Unit {
    public Peasant(String name, int x, int y, List<Unit> enemyes) {
        super(100,
                100,
                0,
                name,
                new int[]{-10,-30},
                x,
                y,
                enemyes);
    }
    @Override
    public String toString() {
        return "Крестьянин " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
