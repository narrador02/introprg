/*
 * En este programa he de añadir la propietad posición mediante
 * los constructores e inicializarla con el parámetro que se especifique.
 * En este caso, si la posición indicada es incorrecta se quedará "estirat".
 * Ahora el constructor y el setter de posición definen el mismo nombre
 */

public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    private UllDeGat ullDret = new UllDeGat();
    private UllDeGat ullEsquerre = new UllDeGat();
    
    public GatRenat() {
    }

    public GatRenat(int vides) {
        setVides(vides);
    }

    public GatRenat(String posicio) {
        setPosicio(posicio);
        if (posicio.equals("assegut")) {
            ullDret.obret();
            ullEsquerre.tancat();
        } else if (posicio.equals("dret")) {
            ullDret.obret();
            ullEsquerre.obret();
        }
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

    public UllDeGat getUllDret() {
        UllDeGat copia;
        if (ullDret.esObert()) {
            copia = new UllDeGat(true);
        } else {
            copia = new UllDeGat();
        }
        return copia;
    }
    
    public UllDeGat getUllEsquerre() {
        UllDeGat copia;
        if (ullEsquerre.esObert()) {
            copia = new UllDeGat(true);
        } else {
            copia = new UllDeGat();
        }
        return copia;
    }
    
    public String aixecat() {
        ullDret.obret();
        ullEsquerre.obret();
        String resultat = esDret() ? "passo de fer res" : "ja m'aixeco";
        setPosicio("dret");
        return resultat;
    }
    
    public String seu() {
        ullDret.obret();
        ullEsquerre.tancat();
        String resultat = esAssegut() ? "passo de fer res" : "ja m'assec";
        setPosicio("assegut");
        return resultat;
    }
    
    public String estirat() {
        ullDret.tancat();
        ullEsquerre.tancat();
        String resultat = esEstirat() ? "passo de fer res" : "ja m'estiro";
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

    @Override
    public String toString() { return String.format("Vides: %d. Posició: %s", vides, posicio); }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        UllDeGat ullDret = renat.getUllDret();
        UllDeGat ullEsquerre = renat.getUllEsquerre();
        System.out.printf("Quan està %s: %b + %b%n",
                          renat.getPosicio(),
                          renat.getUllDret().esObert(),
                          renat.getUllEsquerre().esObert());
        renat.seu();
        System.out.printf("Quan està %s: %b + %b%n",
                          renat.getPosicio(),
                          renat.getUllDret().esObert(),
                          renat.getUllEsquerre().esObert());
        renat.aixecat();
        System.out.printf("Quan està %s: %b + %b%n",
                          renat.getPosicio(),
                          renat.getUllDret().esObert(),
                          renat.getUllEsquerre().esObert());
    }
}
