package abstractUnits;

import game.Main;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Infantry extends Unit{
    public Infantry(String unitName, int health, int healthMax, int armor, String name, int[] damage, int x, int y, List<Unit> enemyes) {
        super(unitName, health, healthMax, armor, name, damage, x, y, enemyes);
        isDodging = true;
        initiative = 2;
    }
    @Override
    public String toString() {
        return unitName + " " +
                name +
                ", здоровье - " + health + "/"+healthMax +
                ", броня - " + armor +
                ", координаты ("+position.x+"/"+position.y + ")";
    }

    public boolean canMoveToCoord(int x, int y){
        for (Unit unit : Main.allTeam){
            if (x == unit.position.x && y == unit.position.y && unit.health>0){
                return false;
            }
        }

        if (x < 0 || y < 0){return false;}

        return true;
    }

    public boolean findAnotherAnyWay(){
        if (canMoveToCoord(position.x + 1, position.y)){
            position.x ++;
            return true;
        } else if (canMoveToCoord(position.x, position.y + 1)) {
            position.y ++;
            return true;
        } else if (canMoveToCoord(position.x -1, position.y)) {
            position.x --;
            return true;
        } else if (canMoveToCoord(position.x, position.y - 1)) {
            position.y --;
            return true;
        }

        System.out.println(getCastName() + " спасите, я заблокирован!!!");
        return false;
    }

    @Override
    public void step() {
        if (health>0){
            Unit enemy = nearEnemy();

            if (enemy == null){
                return;
            }

            int ex = enemy.position.x;
            int ey = enemy.position.y;

            if (Math.abs(ex - position.x) <=1 && Math.abs(ey - position.y) <=1){
                int maxDamage = getMaxDamage(1);

                enemy.health = enemy.health - maxDamage;

                System.out.println(getCastName() + " ударил " + enemy.getCastName("а "));
            }else {
                System.out.println(getCastName() + ": братва, я пошел!");

                int diffX = Math.abs(ex - position.x);
                int diffY = Math.abs(ey - position.y);

                int preterX = position.x;
                int preterY = position.y;

                boolean moveToY = diffY < diffX && diffY > 1;

                if (moveToY){
                    preterY = preterY + (ey >= position.y ? 1:-1);
                }else {
                    preterX = preterX + (ex >= position.x ? 1:-1);
                }

                if (canMoveToCoord(preterX,preterY)){
                    position.x = preterX;
                    position.y = preterY;

                    System.out.println(getCastName() + " переместился");
                }else if(findAnotherAnyWay()){
                    System.out.println(getCastName() + " кое как переместился");
                }

            }
        }
    }
}
