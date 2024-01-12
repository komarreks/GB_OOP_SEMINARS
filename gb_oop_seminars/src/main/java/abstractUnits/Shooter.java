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

    public Unit nearEnemy(List<Unit> enemyes){
        HashMap<Float, Unit> unitMap = new HashMap<>();

        enemyes.forEach(enemy ->{
            if (enemy.health>0){
                unitMap.put(position.rangeEnemy(enemy.position),enemy);
            }
        });

        return unitMap.entrySet().stream().findFirst().get().getValue();
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

            int dodge = 0;
            float distance = enemyDistance(enemy);
            int maxDamage = (int) distance > rangeMaxDamage ? damage[0] : damage[1];

            if(enemy.isDodging){
                dodge = enemy.dodging((int) distance);
                maxDamage = (int) (maxDamage/(dodge*distance));
            }

            maxDamage = maxDamage - enemy.armor;

            maxDamage = maxDamage>0?maxDamage:0;

            enemy.health = enemy.health - maxDamage;

            arrows--;
        }
    }
}
