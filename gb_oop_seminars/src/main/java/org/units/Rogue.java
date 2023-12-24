package org.units;

public class Rogue extends Unit{
    public Rogue(String name) {
        super(100,
                100,
                5,
                name,
                new int[]{20,30});
    }
    @Override
    public String toString() {
        return "Разбойник " + name + ", здоровье - " + health + "/"+healthMax + ", броня - "+armor;
    }
}
