/*
 * Nueva versión del programa de Renat
 * esta vez haciendo uso de la anotación 'this'
 */
public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    public GatRenat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio);
    }
    public int getVides() { return vides; }
    public void setVides(int vides) {
        if (vides >= 0)  {
            this.vides = vides;
        }
    }
    public String getPosicio() { return posicio; }
    public void setPosicio(String posicio) {
        if (posicio.equals("estirat") || posicio.equals("dret") || posicio.equals("assegut"))  {
            this.posicio = posicio;
        } else {
            posicio = "estirat";
        }
    }
    @Override
    public String toString() { return String.format("Vides: %d. Posició: %s", vides, posicio); }
    public static void main(String[] args) {
        System.out.println(new GatRenat(7, "dret"));
    }
}
