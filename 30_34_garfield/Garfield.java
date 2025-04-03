/*
 * Este programa contiene la clase Garfield
 * que hereda de Gat y tiene un comportamiento diferente
 */
public class Garfield extends Gat {
    public Garfield() {
        super("Garfield", 9, "assegut");
    }

    @Override
    public void setVides(int vides) {
        if (vides <= 9 && vides >= 0) {
            super.setVides(vides);
        }
    }

    @Override
    public String estirat() {
        if ("assegut".equals(getPosicio())) {
            setPosicio("estirat");
            return "Bai Maitea, bai";
        }
        return "passo de fer res";
    }

    @Override
    public String aixecat() {
        if ("assegut".equals(getPosicio())) {
            setPosicio("dret");
            return "ja m'aixeco";
        }
        return "passo de fer res";
    }

    @Override
    public String seu() {
        if (!"assegut".equals(getPosicio())) {
            setPosicio("assegut");
            return "ja m'assec";
        }
        return "passo de fer res";
    }
}
