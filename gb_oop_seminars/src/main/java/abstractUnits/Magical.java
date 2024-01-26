package abstractUnits;

import java.util.ArrayList;
import java.util.List;

public abstract class Magical extends Unit{
    public Magical(String unitName, int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        super(unitName, health, healthMax, armor, name, damage, x, y, enemyes);
        initiative = 1;
    }

    @Override
    public String toString() {

        String localHealth = health + "/"+healthMax;
        if (health <=0){localHealth = "умер";}

        return unitName + " " +
                name +
                ", здоровье - " + localHealth +
                ", броня - "+armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }

    @Override
    public void step() {
        List<Unit> localListUnit = new ArrayList<>();

        localListUnit.addAll(allies);

        localListUnit.sort((o1,o2) -> Integer.compare(o1.health, o2.health));

        for (Unit unit : localListUnit) {
            String className = unit.getClass().getSuperclass().getSimpleName();

            if (unit.health <= 0 && className.equals("Infantry")){
                resurection(unit);
                System.out.println(getCastName() + ": воскресил "+unit.getCastName("а "));
                return;
            } else if (unit.health>0 && unit.health< unit.healthMax) {
                healing(unit);
                System.out.println(getCastName() + ": подлечил "+unit.getCastName("а "));
                return;
            }
        }

        System.out.println(getCastName() + ": стоит и смотрит");
    }

    public void healing(Unit unit){
        double diffHealing = health/healthMax;
        int maxHealing = (int) (damage[1] * diffHealing);

        unit.health += maxHealing + unit.health < unit.healthMax?maxHealing: unit.healthMax- unit.health;
    }

    public void resurection(Unit unit){
        unit.health = health;
        health -= 10;
    }
}
