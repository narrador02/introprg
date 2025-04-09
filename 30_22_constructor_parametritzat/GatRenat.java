/*
 * He añadido posicio
 * con el valor especificado
 */
public class GatRenat {
    private int vides;
    private String posicio;
    public GatRenat(int novesVides, String novaPosicio) {
        vides = novesVides;
        posicio = novaPosicio;
    }
    public int getVides() { return vides; }
    public String getPosicio() { return posicio; }
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat(7, "estirat");
        System.out.println(renat);
    }
}
