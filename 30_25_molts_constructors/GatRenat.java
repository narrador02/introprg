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
        this(7, "estirat");
    }
    public GatRenat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio);
    }
    public void setVides(int vides) {
        this.vides = vides;
    }
    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }
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
