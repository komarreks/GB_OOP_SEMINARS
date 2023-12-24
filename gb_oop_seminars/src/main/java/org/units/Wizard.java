package org.units;

public class Wizard extends Unit{
    public Wizard(String name) {
        super(100,
                100,
                5,
                name,
                new int[]{20,30});
    }
    @Override
    public String toString() {
        return "Колдун " + name + ", здоровье - " + health + "/"+healthMax + ", броня - "+armor;
    }
}
