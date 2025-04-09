/*
 * Programa el cual contiene los valores de piso
 * y movimiento que se usaran en otro programa
 */
 public class Ascensor {
    private int pis = -1;
    private String moviment = "aturat";

    public int getPis() {
        return pis;
    }

    public String getMoviment() {
        return moviment;
    }

    public void setPis(int num) {
        if (num >= -1 && num <= 10) {
            pis = num;
        }
    }

    public void setMoviment(String mov) {
        if (mov.equals("pujant") || mov.equals("baixant") || mov.equals("aturat")) {
            moviment = mov;
        }
    }
}
