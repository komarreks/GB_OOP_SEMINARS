package game;

import additional.Names;
import abstractUnits.Unit;
import org.units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static List<Unit> whiteCommand = new ArrayList<>();
    static List<Unit> blackCommand = new ArrayList<>();

    public static void main(String[] args) {
        int countUnits = 10;
        whiteCommand.addAll(generateCommand(countUnits,0, blackCommand));
        blackCommand.addAll(generateCommand(countUnits,3, whiteCommand));

        whiteCommand.sort((u1,u2) -> Integer.compare(u2.initiative,u1.initiative));
        blackCommand.sort((u1,u2) -> Integer.compare(u2.initiative,u1.initiative));

        System.out.println("Белые:");
        whiteCommand.forEach(unit -> {
            System.out.println(unit);
        });
        System.out.println("\n");
        System.out.println("Черные:");
        blackCommand.forEach(unit -> {
            System.out.println(unit);
        });
    }

    private static List<Unit> generateCommand(int countUnits, int offset, List<Unit> enemyes){
        List<Unit> units = new ArrayList<>();
        Random random = new Random();

        int x = offset == 0? 0:9;
        int y = 0;

        for (int i = 1; i<= countUnits; i++){
            int r = random.nextInt(1+offset,5+offset);
            units.add(getUnit(r, x, y, enemyes));
            y++;
        }
        return units;
    }

    private static Unit getUnit(int num, int x, int y, List<Unit> enemyes){
        switch (num){
            case 1:return new CrossBower(getName(), x, y, enemyes);
            case 2:return new Monk(getName(), x, y, enemyes);
            case 3:return new PikeMan(getName(), x, y, enemyes);
            case 4:return new Peasant(getName(), x, y, enemyes);
            case 5:return new Rogue(getName(), x, y, enemyes);
            case 6:return new Sniper(getName(), x, y, enemyes);
            case 7:return new Wizard(getName(), x, y, enemyes);
        }
        return null;
    }

    private static String getName(){
        return Names.values()[new Random().nextInt(1,Names.values().length-1)].name();
    }
}