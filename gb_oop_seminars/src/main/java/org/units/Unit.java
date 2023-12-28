package org.units;

import java.util.List;

public abstract class Unit {
    int health, healthMax, armor;
    String name;
    int[] damage;
    Vector2 position;

    public Unit(int health, int healthMax, int armor, String name, int[] damage, int x, int y) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.name = name;
        this.damage = damage;
        this.position = new Vector2(x,y);
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
