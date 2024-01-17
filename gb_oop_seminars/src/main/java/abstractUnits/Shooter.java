package abstractUnits;

import java.util.HashMap;
import java.util.List;

public abstract class Shooter extends Unit{

    public int rangeMaxDamage;
    public int arrows;
    public int swordDamage;
    public Shooter(String unitName,
                   int health,
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
        super(unitName, health, healthMax, armor, name, damage, x, y, enemyes);
        this.rangeMaxDamage = rangeMaxDamage;
        this.arrows = arrows;
        this.swordDamage = swordDamage;
        initiative = 3;
    }

    @Override
    public String toString() {
        return unitName + " "+
                name +
                ", здоровье - " +
                health + "/"+healthMax +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y + ")"+
                ", ближ. соперник - " + nearEnemy(enemyes);
    }

    @Override
    public void step() {
        if(health>0 && arrows>0){
            Unit enemy = nearEnemy(enemyes);

            int maxDamage = getMaxDamage(rangeMaxDamage);

            enemy.health = enemy.health - maxDamage;

            arrows--;

            System.out.println(getCastName() + ": выстрелил в " + enemy.getCastName("а "));
        } else if (arrows == 0) {
            System.out.println(getCastName() + ": я без стрел, товарищи!");
        }
    }
}
