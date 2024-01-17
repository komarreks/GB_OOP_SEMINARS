package game;

import additional.Names;
import abstractUnits.Unit;
import org.units.*;

import java.util.*;

public class Main {
    static List<Unit> whiteCommand = new ArrayList<>();
    static List<Unit> blackCommand = new ArrayList<>();

    static int whiteStep = 0;
    static int blackStep = 0;
    static boolean whiteAlive = true, blackAlive = true;
    public static void main(String[] args) {
        int countUnits = 10;
        whiteCommand.addAll(generateCommand(countUnits,0, blackCommand));
        blackCommand.addAll(generateCommand(countUnits,3, whiteCommand));

        whiteCommand.sort((u1,u2) -> Integer.compare(u2.initiative,u1.initiative));
        blackCommand.sort((u1,u2) -> Integer.compare(u2.initiative,u1.initiative));

        System.out.println("Белые:");
        whiteCommand.forEach(unit -> {
            System.out.println(unit);
            unit.setAllies(whiteCommand);
        });
        System.out.println("\n");
        System.out.println("Черные:");
        blackCommand.forEach(unit -> {
            System.out.println(unit);
            unit.setAllies(blackCommand);
        });

        int stepCount = 1;

        while (whiteAlive && blackAlive){

            System.out.println("Ход: " + stepCount);

            if (stepCount%10==0){
                String none = new Scanner(System.in).nextLine();
            }

            whiteCommandStep();
            blackCommandStep();

            stepCount++;
        }

        if (whiteAlive){
            System.out.printf("Белые победили!\nВживых остались:\n");
            whiteCommand.forEach(unit -> {
                if (unit.health>0){
                    System.out.printf(unit.getCastName());
                }
            });
        }else {
            System.out.printf("Черные победили!\nВживых остались:\n");
            blackCommand.forEach(unit -> {
                if (unit.health>0){
                    System.out.printf(unit.getCastName());
                }
            });
        }
    }

    private static void whiteCommandStep(){
        int countLiveUnits = countAliveUnits(whiteCommand);

        whiteAlive = countLiveUnits > 0;

        if (whiteStep >= countLiveUnits && whiteAlive){whiteStep = 0;}

        if (whiteAlive){
            whiteCommand.get(whiteStep).step();
            whiteStep++;
        }
    }

    private static void blackCommandStep(){
        int countLiveUnits = countAliveUnits(blackCommand);

        blackAlive = countLiveUnits > 0;

        if (blackStep >= countLiveUnits && blackAlive){blackStep = 0;}

        if (blackAlive){
            blackCommand.get(blackStep).step();
            blackStep++;
        }
    }

    private static int countAliveUnits(List<Unit> command){
        int count = 0;

        for (Unit unit:command){
            if (unit.health>0){
                count++;
            }
        }

        return count;
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