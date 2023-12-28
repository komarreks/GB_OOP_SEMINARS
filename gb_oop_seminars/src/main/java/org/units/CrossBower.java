package org.units;

public class CrossBower extends UnitShooter{
    public CrossBower(String name, int x, int y) {
        super(75,
              75,
              2,
              name,
              new int[]{10,15},
             4,
             20,
             50,
             x,
             y);
    }
    @Override
    public String toString() {
        return "Арбалетчик " +
                name +
                ", здоровье - " +
                health + "/"+healthMax +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y + ")";
    }
}
