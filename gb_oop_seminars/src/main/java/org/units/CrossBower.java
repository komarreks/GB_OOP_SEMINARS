package org.units;

import abstractUnits.Shooter;
import abstractUnits.Unit;

import java.util.List;

public class CrossBower extends Shooter {
    public CrossBower(String name, int x, int y, List<Unit> enemyes) {
        super("Арбалетчик",
              75,
              75,
              2,
              name,
              new int[]{10,20},
             4,
             20,
             15,
             x,
             y,
             enemyes);
    }
}
