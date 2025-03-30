/*
 * En este programa Gat define los miembros de su clase
 * que serán heredados por la subclase
 */

public class Gat {
    private int vides = 7;
    private String posicio = "estirat";

    public int getVides() { return vides; }
    public void setVides(int novesVides) {
        if (novesVides >= 0)  {
            vides = novesVides;
        }
    }
    public String getPosicio() { return posicio; }
    public void setPosicio(String posicio) {
        if (posicio.equals("estirat") || posicio.equals("assegut") || posicio.equals("dret")) {
            this.posicio = posicio;
        }
    }
}
