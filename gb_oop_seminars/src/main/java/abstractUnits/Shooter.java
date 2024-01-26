package abstractUnits;

import org.units.Peasant;

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

        String localHealth = health + "/"+healthMax;
        if (health <=0){localHealth = "умер";}

        return unitName + " "+
                name +
                ", здоровье - " +
                localHealth +
                ", броня - "+armor+
                ", остаток болтов - "+arrows +
                ", координаты ("+position.x+"/"+position.y;
    }

    @Override
    public void step() {
        if(health>0 && arrows>0){
            Unit enemy = nearEnemy();

            if (enemy == null){return;}


            int maxDamage = getMaxDamage(rangeMaxDamage);

            enemy.health = enemy.health - maxDamage;

            arrows--;

            System.out.println(getCastName() + ": выстрелил в " + enemy.getCastName("а "));

            Peasant peasant = findPeasant();

            if (peasant != null){
                peasant.isReady = false;
                arrows++;
                System.out.print(", взял стрелу у "+peasant.getCastName("а")+"\n");
            }
        } else if (arrows == 0) {
            System.out.println(getCastName() + ": я без стрел, товарищи!");
        }
    }

    public Peasant findPeasant(){
        for (Unit ally : allies) {
            if (ally.getClass().getSimpleName().equals("Peasant")){
                Peasant peasant = (Peasant) ally;
                if (peasant.health > 0 && peasant.isReady){
                    return peasant;
                }
            }
        }

        return null;
    }
}
