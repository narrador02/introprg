/*
 * Nueva versión del programa GatRenat
 * que incluye la variable posición en el constructor
 */
public class GatRenat {
    private int vides;
    private String posicio;
    public GatRenat(int novesVides, String nuevaPos) {
        vides = novesVides;
        posicio = nuevaPos;
    }
    public int getVides() { return vides; }
    public String getPosicio() { return posicio; }
    @Override
    public String toString() {
        return String.format("Vides: %d. Posicio: %s", vides, posicio);
    }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat(7, "estirat");
        System.out.println(renat);
    }
}
