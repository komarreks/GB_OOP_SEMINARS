package org.units;

public class Wizard extends Unit{
    public Wizard(String name, int x, int y) {
        super(100,
                100,
                5,
                name,
                new int[]{-10,-30},
                x,
                y);
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
