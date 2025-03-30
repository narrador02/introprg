/*
 * En este programa GatRenat heredará miembros de GatRenat
 * y los hará servir en su main
 */

public class GatRenat extends Gat {
    public boolean esViu() {
        if (getVides() > 0) {
            return true;
        }
        return false;
    }

    public boolean esDret() {
        if (getPosicio().equals("dret")) {
            return true;
        }
        return false;
    }

    public boolean esAssegut() {
        if (getPosicio().equals("assegut")) {
            return true;
        }
        return false;
    }

    public boolean esEstirat() {
        if (getPosicio().equals("estirat")) {
            return true;
        }
        return false;
    }

    public String aixecat() {
        String resultat = esDret() ? "passo de fer res" : "ja m'aixeco";
        setPosicio("dret");
        return resultat;
    }

    public String seu() {
        String resultat = esAssegut() ? "passo de fer res" : "ja m'assec";
        setPosicio("assegut");
        return resultat;
    }

    public String estirat() {
        String resultat = esEstirat() ? "passo de fer res" : "ja m'estiro";
        setPosicio("estirat");
        return resultat;
    }
}
