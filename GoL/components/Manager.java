package GoL.components;

import GoL.constants.Const;

public class Manager {
    private int[][] display;

    public void setScreen(int[][] display){
        this.display = display;
    }
    
    public int[][] updatePopulation(){
        int[][] newPopulation = new int[this.display.length][this.display[0].length];
        
        for (int y = 0; y < this.display.length; y++) {
            for (int x = 0; x < this.display[0].length; x++) {
                int condition = this.display[y][x];
                int neighbors = Cell.getNeighbors(this.display, y, x);

                Cell cell = new Cell(condition, neighbors);
                newPopulation[y][x] = cell.lifeRules();
            }
        }
        return this.display = newPopulation;
    }

    public void drawScreen(int g) {
        System.out.println(g+"° generation\n");


        for (int[] row : this.display) {
            for (int value : row) {
                if (value == Const.ALIVE) {
                    System.out.print(
                        Const.RED_COLOR+"[x]"+Const.RESET_COLOR
                    );
                }
                if (value == Const.DEAD) System.out.print("[ ]");
            }
            System.out.println();
        }
    }
}
