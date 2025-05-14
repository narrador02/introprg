/* 
 * Programa que crea y verifica los vinos para tenerlos controlados.
 */
public class Vi {
    private String ref;
    private String nom;
    private int preu;
    private int estoc;
    private String lloc;
    private String origen;
    private String tipus;
    private String collita;

    public Vi(String ref, String nom, int preu, int estoc, String lloc,
              String origen, String tipus, String collita) {
        this.ref = ref;
        this.nom = nom;
        this.preu = preu;
        this.estoc = estoc;
        this.lloc = lloc;
        this.origen = origen;
        this.tipus = tipus;
        this.collita = collita;
    }
    
    public void setRef(String ref) {
    this.ref = ref;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public void setEstoc(int estoc) {
        this.estoc = estoc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setCollita(String collita) {
        this.collita = collita;
    }
    
    public String getRef() {
        return ref;
    }

    public String getNom() {
        return nom;
    }

    public int getPreu() {
        return preu;
    }

    public int getEstoc() {
        return estoc;
    }

    public String getLloc() {
        return lloc;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipus() {
        return tipus;
    }

    public String getCollita() {
        return collita;
    }

    @Override
    public String toString() {
        return ref + ";" + nom + ";" + preu + ";" + estoc + ";" + lloc + ";" + origen + ";" + tipus + ";" + collita;
    }
}
