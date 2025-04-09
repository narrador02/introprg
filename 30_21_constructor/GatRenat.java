/*
 * En este programa se añade e inicializa la variable 
 * posición para que se printee con toString()
 */
public class GatRenat {
    private int vides;
    private String posicio;
    public GatRenat() {
        vides = 7;
        posicio = "estirat";
    }
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
    public int getVides() { return vides; }
    public String getPosicio() { return posicio; }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        System.out.println(renat);
    }
}
