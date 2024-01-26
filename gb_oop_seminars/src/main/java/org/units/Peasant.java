package org.units;

import abstractUnits.Unit;

import java.util.List;

public class Peasant extends Unit {
    public boolean isReady;
    public Peasant(String name, int x, int y, List<Unit> enemyes) {
        super("Деревещина",
                100,
                100,
                0,
                name,
                new int[]{-10,-30},
                x,
                y,
                enemyes);
        isReady = true;
    }
    @Override
    public String toString() {

        String localHealth = health + "/"+healthMax;
        if (health <=0){localHealth = "умер";}

        return unitName + " " +
                name +
                ", здоровье - " + localHealth +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }

    @Override
    public void step() {
        isReady = true;
        System.out.println(getCastName() + ": снова готов");
    }

    @Override
    public String getCastName(String add) {
        return "Деревещин" + add + getName();
    }
}
