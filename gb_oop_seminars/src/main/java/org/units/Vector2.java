package org.units;

public class Vector2 {
    int x,y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public float rangeEnemy(Vector2 vector2){
        return  (float) Math.sqrt(Math.pow(vector2.x - x, 2)+Math.pow(vector2.y-y, 2));
    }
}
