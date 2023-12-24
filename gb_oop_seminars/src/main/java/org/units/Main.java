package org.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static List<Unit> whiteCommand = new ArrayList<>();
    static List<Unit> blackCommand = new ArrayList<>();

    public static void main(String[] args) {
        int countUnits = 10;
        whiteCommand.addAll(generateCommand(countUnits,0));
        blackCommand.addAll(generateCommand(countUnits,3));

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

    private static List<Unit> generateCommand(int countUnits, int offset){
        List<Unit> units = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i<= countUnits; i++){
            int r = random.nextInt(1+offset,5+offset);
            units.add(getUnit(r));
        }
        return units;
    }

    private static Unit getUnit(int num){
        switch (num){
            case 1:return new CrossBower(getName());
            case 2:return new Monk(getName());
            case 3:return new PikeMan(getName());
            case 4:return new Peasant(getName());
            case 5:return new Rogue(getName());
            case 6:return new Sniper(getName());
            case 7:return new Wizard(getName());
        }
        return null;
    }

    private static String getName(){
        return Names.values()[new Random().nextInt(1,Names.values().length-1)].name();
    }
}