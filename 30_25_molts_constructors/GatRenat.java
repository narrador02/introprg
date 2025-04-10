/*
 * Nueva versión del ejercicio anterior
 * en la que se hace uso de varios constructores
 */
public class GatRenat {
    private int vides;
    private String posicio;
    public GatRenat() {
        this(7, "estirat");
    }
    public GatRenat(int vides) {
        this(vides, "estirat");
    }
    public GatRenat(String posicio) {
        this(7, posicio);
    }
    public GatRenat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio);
    }
    public int getVides() { return vides; }
    public void setVides(int novesVides) {
        if (novesVides >= 0)  {
            vides = novesVides;
        } else {
            vides = 7;
        }
    }
    public String getPosicio() { return posicio; }
    public void setPosicio(String posicio) {
        if (posicio.equals("estirat") || posicio.equals("assegut") || posicio.equals("dret")) {
            this.posicio = posicio;
        } else {
            this.posicio = "estirat";
        }
    }
    @Override
    public String toString() { return String.format("Vides: %d. Posició: %s", vides, posicio); }
    public static void main(String[] args) {
        GatRenat[] renats = {
            new GatRenat(),         // tot per defecte
            new GatRenat(8),        // 8 vides i posició per defecte
            new GatRenat("dret"),   // posició dret i vides per defecte
            new GatRenat(8, "dret") // 8 vides i posició dret

        };
        for (GatRenat renat: renats) {
            System.out.println(renat);
        }
    }
}
