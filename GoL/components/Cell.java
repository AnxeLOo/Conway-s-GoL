package GoL.components;

import GoL.constants.Const;
public class Cell {
    private int condition;
    private int neighbors;

    public Cell(int startCondition, int startNeighbors) {
        this.condition = startCondition;
        this.neighbors = startNeighbors;
    }

    public int lifeRules() {
        int condition = this.condition;

        if (condition == Const.ALIVE) {
            if (this.neighbors > 3 || this.neighbors < 2) {condition = Const.DEAD;} 
            else if (this.neighbors >= 2) {condition = Const.ALIVE;}

        } else if (condition == Const.DEAD) {
            if (this.neighbors == 3) condition = Const.ALIVE;
        }
        return condition;
    }

    public static int getNeighbors(int[][] screen, int yAxis, int xAxis) {
        int alive = 0;
        for (int y = -Const.OFFSET; y <= Const.OFFSET; y++) {
            for (int x = -Const.OFFSET; x <= Const.OFFSET; x++) {
                try {
                    if ((yAxis == Const.CENTER && xAxis == Const.CENTER) && (y == -1 || x == -1)) continue;
                    if ((yAxis == Const.CENTER && xAxis != Const.CENTER) && (y == -1)) continue;
                    if ((yAxis != Const.CENTER && xAxis == Const.CENTER) && (x == -1)) continue;
                    
                    if (!(y == 0 && x == 0)) {
                        int current = screen[y+yAxis][x+xAxis];
                        if (current == Const.ALIVE) alive++;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return alive;
    }
}
