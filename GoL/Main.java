package GoL;

import java.util.Scanner;
import GoL.components.Manager;
import GoL.utilities.Utils;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Manager manager = new Manager();
  

    public static void main(String[] args) throws InterruptedException{
        // String[] test = {"p=01#001#111"};

        String[] sortedArgs = Utils.sortInputs(args);
        int[] newArgs = Utils.checkArgs(sortedArgs);

        int width = newArgs[0];
        int height = newArgs[1];
        int generation = newArgs[2];
        int speed = newArgs[3];
        
        int[][] screen = Utils.validatePopulationArgs(width, height, sortedArgs[4]);

        manager.setScreen(screen);
        for (int gen = 1; gen <= generation; gen++) {
            Utils.cleanScreen();
            manager.drawScreen(gen);
            
            if (gen == 1) {
                System.out.print("Press ANY key to start ");
                sc.nextLine();
                sc.close();
            }

            manager.updatePopulation();
            Thread.sleep(speed);
        }
    }   
}