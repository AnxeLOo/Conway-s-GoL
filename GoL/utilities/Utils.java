package GoL.utilities;

import java.util.Random;
import GoL.constants.Const;

public class Utils {
    public static Random random = new Random();
    /**
     * Limpa a tela
     */
    public static void cleanScreen(){
        System.out.print(Const.CLEAR);
    }

    /**
     * Orgazina os parametros informados
     * 
     * @param args Parametros
     * 
     * @return Parametros orgazinados
     */
    public static String[] sortInputs(String[] args){
        String[] firstArgs = args;
        
        String[] argsNames = Const.ARGS_PREFIX;
        String[] sortedArgs = {null, null, null, null, null};

        String current;

        for (int j = 0; j < argsNames.length; j++) {
            for (String value : firstArgs) {
                if (value.contains(argsNames[j])) {
                    current = value.replace(argsNames[j], "");
                    if (current != "") sortedArgs[j] = current;
                }
            }
        }
        return sortedArgs;
    }

    /**
     * Valida os parametros: Largura, Altura, Geração e Velocidade
     * 
     * @param parametros Array com os parametros
     * 
     * @return 
     * Se todos os valores estiverem corretos:
     * <ul>
     *      <li>Array dos parametros convertidos</li>
     * </ul>
     *
     * <li>Se encontra parametro incorreto:
     *      <ul>
     *          <li>Array dos parametros convertidos com o valor <p>
     *              padrão do parametro em seu respectivo indice
     *          </li>
     *      </ul>
     * </li>
     */
    public static int[] checkArgs(String[] parametros) {
        int[] defaultArgs = {
            Const.DEFAULT_WIDTH,
            Const.DEFAULT_HEIGHT,
            Const.DEFAULT_GENERATION,
            Const.DEFAULT_SPEED,
        };
        int current;

        for (int i = 0; i < defaultArgs.length; i++) {
            try {
                current = Integer.parseInt(parametros[i]);
                
                if (i == 3 && current < 100) continue;
                defaultArgs[i] = current;
            } catch (NumberFormatException e) {}
        }
        return defaultArgs;   
    }

    /**
     * Valida o parametro da População
     * 
     * @param width Largura da tela
     * @param height Altura da tela
     * @param pArgs Parametro informado da População
     * 
     * @return Array contendo População
     */
    public static int[][] validatePopulationArgs(int width, int height, String pArgs) {
        int[][] screen = new int[height][width];
        String[] splitted;

        try {
            splitted = pArgs.split("#");
            for (int y = 0; y < splitted.length; y++) {
                for (int x = 0; x < splitted[y].length(); x++) {
                    char current = splitted[y].charAt(x);

                    if (!(current == '1' || current == '0')) {
                        throw new NumberFormatException();
                    }
                    screen[y][x] = current-48;
                }
            }
        } catch (NumberFormatException e) {
            screen = generateRandomPopulation(width, height);
        } catch (NullPointerException e){
            screen = generateRandomPopulation(width, height);
        } catch (IndexOutOfBoundsException e){
            screen = generateRandomPopulation(width, height);
        }
        return screen;
    }

    /**
     * Gera uma população aleatoria
     * 
     * @param width Largura da tela
     * @param height Altura da tela
     * 
     * @return População gerada
     */
    public static int[][] generateRandomPopulation(int width, int height) {
        int[][] randomPopulation = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                randomPopulation[y][x] = random.nextInt(2);
            }
        }
        return randomPopulation;
    }
}