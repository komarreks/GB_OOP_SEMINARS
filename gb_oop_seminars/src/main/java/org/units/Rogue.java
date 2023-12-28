package org.units;

public class Rogue extends Unit{
    public Rogue(String name, int x, int y) {
        super(100,
                100,
                5,
                name,
                new int[]{20,30},
                x,
                y);
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
