package abstractUnits;

import additional.Vector2;

import java.util.List;

public abstract class Unit {
    public int health, healthMax, armor;
    public String name;
    public int[] damage;
    public Vector2 position;
    public List<Unit> enemyes;

    public Unit(int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.name = name;
        this.damage = damage;
        this.position = new Vector2(x,y);
        this.enemyes = enemyes;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public float enemyDistance(Unit enemy){
        return this.position.rangeEnemy(enemy.position);
    }

    public void printDistance(List<Unit> enemyes){
        enemyes.forEach(n -> System.out.println(position.rangeEnemy(n.position)+ ", "));
    }
}
