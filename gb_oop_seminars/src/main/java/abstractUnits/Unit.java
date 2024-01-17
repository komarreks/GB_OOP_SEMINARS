package abstractUnits;

import additional.UnitsAction;
import additional.Vector2;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Unit implements UnitsAction {
    public int health, healthMax, armor;
    public String name, unitName;
    public int[] damage;
    public Vector2 position;
    public List<Unit> enemyes;
    public List<Unit> allies;
    public boolean isDodging;
    public int initiative;

    public Unit(String unitName, int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.name = name;
        this.unitName = unitName;
        this.damage = damage;
        this.position = new Vector2(x,y);
        this.enemyes = enemyes;
        isDodging = false;
        initiative = 0;
    }

    public void setAllies(List<Unit> allies){
        this.allies = allies;
    }

    public String getUnitName(){
        return unitName;
    }

    public String getName(){
        return name;
    }

    public String getCastName(String add){
        return getUnitName() + add + getName();
    }

    public String getCastName(){
        return getUnitName() + " " + getName();
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

    public float enemyDistance(Unit enemy){
        return this.position.rangeEnemy(enemy.position);
    }

    public boolean isDodging(){
        return isDodging;
    }

    public int dodging(int distance){
        int dodge = 0;
        if (isDodging){
            dodge = new Random().nextInt(0,11);
            int probability = dodge - (10-distance);
            dodge = probability>0?dodge:0;
        }
        return dodge;
    }

    public void printDistance(List<Unit> enemyes){
        enemyes.forEach(n -> System.out.println(position.rangeEnemy(n.position)+ ", "));
    }

    public int getMaxDamage(int rangeMaxDamage){
        Unit enemy = nearEnemy(enemyes);

        int dodge = 0;
        float distance = enemyDistance(enemy);
        int maxDamage = (int) distance > rangeMaxDamage ? damage[0] : damage[1];

        if(enemy.isDodging){
            dodge = enemy.dodging((int) distance)*10;
            maxDamage = (int) (maxDamage - (maxDamage/100*dodge));
        }

        maxDamage = maxDamage - enemy.armor;

        maxDamage = maxDamage>0?maxDamage:0;

        return maxDamage;
    }

}
