/*
 * Programa contiene el valor de vidas y la posicón
 * del gato, se usará en otro programa
 */
 public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    
    public int getVides() {
        return vides;
    }
    
    public String getPosicio() {
        return posicio;
    }
    
    public void setVides(int num) {
        vides = num;
    }
    
    public void setPosicio(String text) {
        if (text.equals("estirat") || text.equals("assegut") || text.equals("dret")) {
            posicio = text;
        }
    }
}
