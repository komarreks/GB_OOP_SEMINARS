package abstractUnits;

import java.util.HashMap;
import java.util.List;

public abstract class Shooter extends Unit{

    public int rangeMaxDamage;
    public int arrows;
    public int swordDamage;
    public Shooter(int health,
                   int healthMax,
                   int armor,
                   String name,
                   int[] damage,
                   int rangeMaxDamage,
                   int arrows,
                   int swordDamage,
                   int x,
                   int y,
                   List<Unit> enemyes) {
        super(health, healthMax, armor, name, damage, x, y, enemyes);
        this.rangeMaxDamage = rangeMaxDamage;
        this.arrows = arrows;
        this.swordDamage = swordDamage;
    }

    public Unit nearEnemy(List<Unit> enemyes){
        HashMap<Float, Unit> unitMap = new HashMap<>();

        enemyes.forEach(enemy ->{
            unitMap.put(position.rangeEnemy(enemy.position),enemy);
        });

        return unitMap.entrySet().stream().findFirst().get().getValue();
    }
}
