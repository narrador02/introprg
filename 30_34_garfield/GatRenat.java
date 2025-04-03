/*
 * Este programa contiene la clase GatRenat
 * que hereda de Gat, pero con nombre Renat siempre
 */
public class GatRenat extends Gat {
    public GatRenat() {
        super("Renat");
    }

    public GatRenat(int vides) {
        super("Renat", vides);
    }

    public GatRenat(String posicio) {
        super("Renat", 7, posicio);
    }

    public GatRenat(int vides, String posicio) {
        super("Renat", vides, posicio);
    }
}
