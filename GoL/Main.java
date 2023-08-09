package GoL;


import java.util.Scanner;

import GoL.components.Manager;
import GoL.utils.Utils;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Manager manager = new Manager();

    public static void main(String[] args) throws InterruptedException{
        int generation = 30;
        int[][] screen = {
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
        };
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
            System.out.println();

            Thread.sleep(200);
        }
    }   
}