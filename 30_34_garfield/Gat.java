public class Gat {
    private final String nom;
    private int vides = 7;
    private String posicio;

    public Gat(String nom) {
        if (nom.isEmpty()) {
            this.nom = "anònim";
        } else {
            this.nom = nom;
        }
    }

    public Gat(String nom, int vides) {
        this(nom);
        setVides(vides);
    }

    public Gat(String nom, int vides, String posicio) {
        this(nom, vides);
        setPosicio(posicio);
    }

    public String getNom() { return nom; }

    public int getVides() { return vides; }

    public void setVides(int vides) {
        if (vides > 0 && vides <= 7) {
            this.vides = vides;
        }
    }

    public String getPosicio() { return posicio; }

    public void setPosicio(String posicio) {
        if (posicio.equals("dret") || posicio.equals("assegut") || posicio.equals("estirat")) {
            this.posicio = posicio;
        }
    }

    public boolean esViu() {
        return vides > 0;
    }

    public boolean esDret() {
        return "dret".equals(posicio);
    }

    public boolean esAssegut() {
        return "assegut".equals(posicio);
    }

    public boolean esEstirat() {
        return "estirat".equals(posicio);
    }

    public String aixecat() {
        if (esDret()) return "passo de fer res";
        setPosicio("dret");
        return "ja m'aixeco";
    }

    public String seu() {
        if (esAssegut()) return "passo de fer res";
        setPosicio("assegut");
        return "ja m'assec";
    }

    public String estirat() {
        if (esEstirat()) return "passo de fer res";
        setPosicio("estirat");
        return "ja m'estiro";
    }
}
