package org.units;

import abstractUnits.Shooter;
import abstractUnits.Unit;

import java.util.List;

public class Sniper extends Shooter {
    public Sniper(String name, int x, int y, List<Unit> enemyes) {
        super("Снайпер ",
                100,
                100,
                5,
                name,
                new int[]{15,30},
                4,
                20,
                15,
                x,
                y,
                enemyes);
    }
}
