package org.units;

public class PikeMan extends Unit{
    public PikeMan(String name, int x, int y) {
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
        return "Копейщик " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - " + armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
