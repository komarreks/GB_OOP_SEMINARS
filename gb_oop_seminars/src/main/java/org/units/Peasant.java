package org.units;

public class Peasant extends Unit{
    public Peasant(String name, int x, int y) {
        super(100,
                100,
                0,
                name,
                new int[]{-10,-30},
                x,
                y);
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
