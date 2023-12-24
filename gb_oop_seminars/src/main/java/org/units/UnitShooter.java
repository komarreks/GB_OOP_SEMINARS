package org.units;

public abstract class UnitShooter extends Unit{

    int rangeMaxDamage;
    int arrows;
    int swordDamage;
    public UnitShooter(int health, int healthMax, int armor, String name, int[] damage, int rangeMaxDamage, int arrows, int swordDamage) {
        super(health, healthMax, armor, name, damage);
        this.rangeMaxDamage = rangeMaxDamage;
        this.arrows = arrows;
        this.swordDamage = swordDamage;
    }
}
