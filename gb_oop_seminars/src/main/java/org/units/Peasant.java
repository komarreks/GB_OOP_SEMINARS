package org.units;

public class Peasant extends Unit{
    public Peasant(String name) {
        super(100,
                100,
                0,
                name,
                new int[]{0,0});
    }
    @Override
    public String toString() {
        return "Крестьянин " + name + ", здоровье - " + health + "/"+healthMax + ", броня - "+armor;
    }
}
