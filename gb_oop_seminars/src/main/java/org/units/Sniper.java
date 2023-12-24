package org.units;

public class Sniper extends UnitShooter{
    public Sniper(String name) {
        super(100,
                100,
                5,
                name,
                new int[]{40,60},
                4,
                20,
                40);
    }
    @Override
    public String toString() {
        return "Снайпер " + name + ", здоровье - " + health + "/"+healthMax + ", броня - "+armor+", остаток стрел - "+arrows;
    }
}
