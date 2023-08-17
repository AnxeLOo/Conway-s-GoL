package GoL.components;

import GoL.constants.Const;
public class Cell {
    private int condition;
    private int neighbors;

    /**
     * Construtor da Classe Cell
     * 
     * @param startCondition Condição inicial da Celula
     * @param startNeighbors Vizinhos da Celula
     */
    public Cell(int startCondition, int startNeighbors) {
        this.condition = startCondition;
        this.neighbors = startNeighbors;
    }

    /**
     * Aplica as regras da vida na celula
     * 
     * @return Nova condição da celula
     */
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

    /**
     * Verifica os vizinhos vivos da Celula
     * 
     * @param screen Matriz tela
     * @param yAxis Linha da celula na tela
     * @param xAxis Coluna da celula na tela
     * 
     * @return Quantidade de vizinhos vivos
     */
    public static int getNeighbors(int[][] screen, int yAxis, int xAxis) {
        int current, alive = 0;

        for(int y = -Const.OFFSET; y <= Const.OFFSET; y++){
            for(int x = -Const.OFFSET; x <= Const.OFFSET; x++){
                try {
                    current = screen[y+yAxis][x+xAxis];
                    if (current == 1 && !(y == Const.CENTER && x == Const.CENTER)){
                        alive++;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return alive;
    }
}
