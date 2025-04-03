/*
 * Este programa contiene la clase Garfield
 * que hereda de Gat y tiene un comportamiento diferente
 */
public class Garfield extends Gat {
    public Garfield() {
        super("Garfield", 9, "estirat");
    }

    @Override
    public void setVides(int vides) {
        if (vides <= 9 && vides >= 0) {
            super.setVides(vides);
        }
    }
    @Override
    public String estirat() {
        if (getPosicio().equals("estirat")) return "passo de fer res";
        return "Bai Maitea, bai";
    }
}
