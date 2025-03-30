/*
 * Actualización del programa
 * anterior, esta vez interactuando
 * entre GatRentat y el picarol
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    private Picarol picarol;

    public Picarol agafaPicarol(Picarol picarol) {
        Picarol picarolVell = this.picarol;
        this.picarol = picarol;
        return picarolVell;
    }

    public Picarol deixaPicarol() {
        Picarol picarolVell = this.picarol;
        this.picarol = null;
        return picarolVell;
    }

    public boolean hiHaPicarol() {
        if (picarol == null) {
            return false;
        }
        return true;
    }

    public GatRenat() {
    }

    public GatRenat(int vides) {
        setVides(vides);
    }

    public GatRenat(String posicio) {
        setPosicio(posicio);
    }

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
    public void setPosicio(String posicio) {
        if (posicio.equals("estirat") || posicio.equals("assegut") || posicio.equals("dret")) {
            this.posicio = posicio;
        }
    }

    public String aixecat() {
        String resultat;
        if (esDret()) {
            resultat = "passo de fer res";
        } else {
            resultat = "ja m'aixeco";
            if (hiHaPicarol()) {
                picarol.sona();
            }
        }
        setPosicio("dret");
        return resultat;
    }

    public String seu() {
        String resultat;
        if (esAssegut()) {
            resultat = "passo de fer res";
        } else {
            resultat = "ja m'assec";
            if (hiHaPicarol()) {
                picarol.sona();
            }
        }
        setPosicio("assegut");
        return resultat;
    }

    public String estirat() {
        String resultat;
        if (esEstirat()) {
            resultat = "passo de fer res";
        } else {
            resultat = "ja m'estiro";
            if (hiHaPicarol()) {
                picarol.sona();
            }
        }
        setPosicio("estirat");
        return resultat;
    }

    public boolean esDret() {
        if (posicio.equals("dret")) {
            return true;
        }
        return false;
    }

    public boolean esAssegut() {
        if (posicio.equals("assegut")) {
            return true;
        }
        return false;
    }

    public boolean esEstirat() {
        if (posicio.equals("estirat")) {
            return true;
        }
        return false;
    }
}
