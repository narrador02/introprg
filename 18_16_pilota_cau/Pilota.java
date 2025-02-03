/*
 * Este programa muestra el contenido de una tabla de carácteres donde la mayor parte de los valores son el carácter '·' (un punto).
 * El 'O' representa una pelota. La pelota comienza en la posición (0, 0) y, cada vez que el programa recibe un salto de línea,
 * incrementa en uno la fila i la columna. Cuando supera la últina fila, vuelve a la primera. Lo mismo con la columna.
 */
public class Pilota {
    public static final int N_FILES = 9;
    public static final int N_COLS = 13;

    public static void netejaPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void mostraCamp(char[][] camp) {
        for (int i=0; i<N_FILES; i++) {
            for (int j=0; j<N_COLS; j++) {
                System.out.print(camp[i][j]);
            }
            System.out.println();
        }
    }
    public static void netejaCamp(char[][] camp) {
        for (int i=0; i<N_FILES; i++) {
            for (int j=0; j<N_COLS; j++) {
                camp[i][j] = '·';
            }
        }
    }
    public static void netejaPosicio(char[][] camp, int fila, int col) {
        camp[fila][col] = '·';
    }
    public static void posicionaPilota(char[][] camp, int fila, int col) {
        camp[fila][col] = 'O';
    }
    public static int seguentFila(int actual) {
        if (actual < N_FILES) {
            actual++;
        }
        if (actual == N_FILES) {
            actual = 0;
        }
        return actual;
    }
    public static int seguentCol(int actual) {
        if (actual < N_COLS) {
            actual++;
        }
        if (actual == N_COLS) {
            actual = 0;
        }
        return actual;
    }
    public static void main(String[] args)  {
        char[][] camp = new char[N_FILES][N_COLS];
        netejaCamp(camp);
        int fila = 0;
        int col = 0;
        do {
            posicionaPilota(camp, fila, col);
            netejaPantalla();
            mostraCamp(camp);
            netejaPosicio(camp, fila, col);
            fila = seguentFila(fila);
            col = seguentCol(col);
            System.out.printf("%nEnter per continuar");
        } while (Entrada.readLine().isEmpty());
    }
}
