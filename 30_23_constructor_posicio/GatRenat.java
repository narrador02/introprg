/*
 * Nueva versión del programa de Renat
 * esta vez el constructor cuenta con la posición también
 */
public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    public GatRenat(int vides, String posicio) {
        setVides(vides);
        setPosicio(posicio);
    }
    public int getVides() { return vides; }
    public void setVides(int novesVides) {
        if (novesVides >= 0)  {
            vides = novesVides;
        }
    }
    public String getPosicio() { return posicio; }
    public void setPosicio(String nuevaPos) {
        if (nuevaPos.equals("estirat") || nuevaPos.equals("dret") || nuevaPos.equals("assegut"))  {
            posicio = nuevaPos;
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
