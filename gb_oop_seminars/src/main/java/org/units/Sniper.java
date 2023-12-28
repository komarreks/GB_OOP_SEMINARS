package org.units;

public class Sniper extends UnitShooter{
    public Sniper(String name, int x, int y) {
        super(100,
                100,
                5,
                name,
                new int[]{40,60},
                4,
                20,
                40,
                x,
                y);
    }
    @Override
    public String toString() {
        return "Снайпер " +
                name +
                ", здоровье - " +
                health + "/"+healthMax +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
