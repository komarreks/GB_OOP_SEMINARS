package org.units;

public class PikeMan extends Unit{
    public PikeMan(String name) {
        super(100,
                100,
                5,
                name,
                new int[]{20,30});
    }
    @Override
    public String toString() {
        return "Копейщик " + name + ", здоровье - " + health + "/"+healthMax + ", броня - "+armor;
    }
}
