package org.units;

public class Monk extends Unit{
    public Monk(String name, int x, int y) {
        super(50,
                50,
                1,
                name,
                new int[]{0,0},
                x,
                y);
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
