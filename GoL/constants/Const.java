package GoL.constants;

public class Const {
    // Prefixo de cada parametro
    public static final String[] ARGS_PREFIX = {"w=","h=","g=","s=","p="};

    // Valores padrões para cada parametro
    public static final int DEFAULT_WIDTH = 16;
    public static final int DEFAULT_HEIGHT = 9;
    public static final int DEFAULT_GENERATION = 30;
    public static final int DEFAULT_SPEED = 1000;

    // Condições da Celula
    public static final int ALIVE = 1;
    public static final int DEAD = 0;

    // Abstração do Grid
    public static final int OFFSET = 1;
    public static final int CENTER = 0;

    // Cores
    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    // Clear do terminal
    public static final String CLEAR = "\033[H\033[2J";
}
