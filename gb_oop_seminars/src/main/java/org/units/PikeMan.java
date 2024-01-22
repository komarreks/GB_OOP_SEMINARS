package org.units;

import abstractUnits.Infantry;
import abstractUnits.Unit;

import java.util.List;

public class PikeMan extends Infantry {
    public PikeMan(String name, int x, int y, List<Unit> enemyes) {
        super("Воин",
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
