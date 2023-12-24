package org.units;

public abstract class Unit {
    int health, healthMax, armor;
    String name;
    int[] damage;

    public Unit(int health, int healthMax, int armor, String name, int[] damage) {
        this.health = health;
        this.healthMax = healthMax;
        this.armor = armor;
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
