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

    public boolean esValid() {
        if (ref == null || ref.trim().isEmpty()) return false;
        if (nom == null || nom.trim().isEmpty()) return false;
        if (origen == null || origen.trim().isEmpty()) return false;
        if (tipus == null || tipus.trim().isEmpty()) return false;
        if (collita == null || collita.trim().isEmpty()) return false;
        if (preu < 0 || estoc < 0) return false;
        return true;
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

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public void setEstoc(int estoc) {
        this.estoc = estoc;
    }
    
    public void setRef(String ref) {
    this.ref = ref;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
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
    
    public void setLloc(String lloc) {
    this.lloc = lloc;
    }   
    
    @Override
    public String toString() {
        return ref + ";" + nom + ";" + preu + ";" + estoc + ";" + lloc + ";" + origen + ";" + tipus + ";" + collita;
    }
    
    public static Vi deArrayString(String[] dades) throws IllegalArgumentException {
        if (dades == null || dades.length != 8) {
            throw new IllegalArgumentException("Cal passar exactament 8 camps");
        }
        String ref = dades[0];
        String nom = dades[1];
        int preu = Integer.parseInt(dades[2]);
        int estoc = Integer.parseInt(dades[3]);
        String lloc = dades[4];
        String origen = dades[5];
        String tipus = dades[6];
        String collita = dades[7];

        return new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);
    }
    
    public String[] aArrayString() {
        return new String[] {
            ref,
            nom,
            String.valueOf(preu),
            String.valueOf(estoc),
            lloc,
            origen,
            tipus,
            collita
        };
    }
    
    public static String normalitzaString(String text) {
        if (text == null) return "";
        return text.trim().toLowerCase();
    }
}
