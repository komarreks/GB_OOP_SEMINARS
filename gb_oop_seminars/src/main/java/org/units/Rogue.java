package org.units;

import abstractUnits.Infantry;
import abstractUnits.Unit;

import java.util.List;

public class Rogue extends Infantry {
    public Rogue(String name, int x, int y, List<Unit> enemyes) {
        super("Разбойник ",
                100,
                100,
                5,
                name,
                new int[]{20,30},
                x,
                y,
                enemyes);
    }
}
