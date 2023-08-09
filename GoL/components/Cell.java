package GoL.components;

public class Cell {
    private int condition;
    private int neighbors;

    public void setCell(int startCondition, int startNeighbors) {
        this.condition = startCondition;
        this.neighbors = startNeighbors;
    }

    public int lifeRules() {
        int condition = this.condition;

        if (condition == 1) {
            if (this.neighbors > 3 || this.neighbors < 2) {
                condition = 0;
            } else if (this.neighbors >= 2) {
                condition = 1;
            }
        } else if (condition == 0) {
            if (this.neighbors == 3) {
                condition = 1;
            }
        }
        return condition;
    }

    public static int getCellNeighbors(int[][] screen, int yAxis, int xAxis) {
        int alive = 0;
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                try {
                    if ((yAxis == 0 && xAxis == 0) && (y == -1 || x == -1)) {
                        throw new IndexOutOfBoundsException();
                    }else if ((yAxis == 0 && xAxis != 0) && (y == -1)) {
                        throw new IndexOutOfBoundsException();
                    }else if ((yAxis != 0 && xAxis == 0) && (x == -1)) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (!(y == 0 && x == 0)) {
                        int current = screen[y+yAxis][x+xAxis];
                        if (current == 1) alive++;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return alive;
    }
}
