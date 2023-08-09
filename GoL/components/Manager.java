package GoL.components;

import GoL.utils.Utils;

public class Manager {
    public Cell cell = new Cell();
    private int[][] display;

    public void setScreen(int[][] display){
        this.display = display;
    }
    
    public int[][] updatePopulation(){
        int[][] newPopulation = new int[this.display.length][this.display[0].length];
        
        for (int y = 0; y < this.display.length; y++) {
            for (int x = 0; x < this.display[0].length; x++) {
                int condition = this.display[y][x];
                int neighbors = Cell.getCellNeighbors(this.display, y, x);

                cell.setCell(condition, neighbors);
                newPopulation[y][x] = cell.lifeRules();
            }
        }
        return this.display = newPopulation;
    }

    public void drawScreen(int g) {
        Utils.cleanScreen();
        System.out.println(g+"° generation\n");

        for (int[] row : this.display) {
            for (int value : row) {
                if (value == 1) {
                    System.out.print("[x]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
