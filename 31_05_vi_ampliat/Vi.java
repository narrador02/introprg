/*
 * Clase Vi que contiene todas las propiedades
 * necesarias, sus constructores y métodos
 */
public class Vi {
    private String ref;
    private String nom;
    private int preu;
    private int estoc = 0;
    private String lloc;
    private String origen;
    private String tipus;
    private String collita;

    public Vi(String nom, int preu) {
        this(null, nom, preu, 0, null, null, null, null);
    }
    
    public Vi(String nom, int preu, int estoc) {
        this(null, nom, preu, estoc, null, null, null, null);
    }
    
    public Vi(String ref, String nom, int preu, int estoc, String lloc, String origen, String tipus, String collita) {
        this.ref = normalitzaString(ref);
        this.nom = normalitzaNom(nom);
        setPreu(preu);
        setEstoc(estoc);
        this.lloc = normalitzaString(lloc);
        this.origen = normalitzaString(origen);
        this.tipus = normalitzaString(tipus);
        this.collita = normalitzaString(collita);
    }

    public static String normalitzaNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return "NOM NO VÀLID!";
        }
        nom = nom.trim();
        String resultat = "";
        int cont = 0;
        for (int i = 0; i < nom.length(); i++) {
            char caracter = nom.charAt(i);
            if (cont == 0 && Character.isWhitespace(caracter)) {
                cont++;
                resultat = resultat + nom.charAt(i);
                continue;
            } else if (Character.isWhitespace(caracter)) {
                continue;
            }
            cont = 0;
            resultat = resultat + nom.charAt(i);
        }
        if (resultat.isBlank()) {
            resultat = "NOM NO VÀLID!";
        }
        return resultat;
    }
    
    public static String normalitzaString(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        text = text.trim();
        String resultat = "";
        int cont = 0;
        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);
            if (cont == 0 && Character.isWhitespace(caracter)) {
                cont++;
                resultat = resultat + text.charAt(i);
                continue;
            } else if (Character.isWhitespace(caracter)) {
                continue;
            }
            cont = 0;
            resultat = resultat + text.charAt(i);
        }
        return resultat.isBlank() ? null : resultat;
    }

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = normalitzaString(ref); }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = normalitzaNom(nom); }
    
    public int getPreu() { return preu; }
    public void setPreu(int preu) {
        if (preu >= 0) {
            this.preu = preu;
        } else if (this.preu == 0) {
            this.preu = -1;
        }
    }
    
    public int getEstoc() { return estoc; }
    public void setEstoc(int estoc) {
        if (estoc >= 0) {
            this.estoc = estoc;
        } else if (this.estoc == 0) {
            this.estoc = -1;
        }
    }
    
    public String getLloc() { return lloc; }
    public void setLloc(String lloc) { this.lloc = normalitzaString(lloc); }
    
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = normalitzaString(origen); }
    
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = normalitzaString(tipus); }
    
    public String getCollita() { return collita; }
    public void setCollita(String collita) { this.collita = normalitzaString(collita); }

    public boolean esValid() {
        if (getNom().equals("NOM NO VÀLID!") || preu < 0 || estoc < 0) {
            return false;
        }
        if (ref == null || lloc == null || origen == null || tipus == null || collita == null) {
            return false;
        }
        return true;
    }

    public String[] aArrayString() {
        return new String[] {
            ref,
            nom,
            Integer.toString(preu),
            Integer.toString(estoc),
            lloc,
            origen,
            tipus,
            collita
        };
    }

    public static Vi deArrayString(String[] dades) {
        if (dades == null || dades.length != 8) return null;
        
        try {
            String ref = dades[0];
            String nom = dades[1];
            int preu = Integer.parseInt(dades[2]);
            int estoc = Integer.parseInt(dades[3]);
            String lloc = dades[4];
            String origen = dades[5];
            String tipus = dades[6];
            String collita = dades[7];
            
            Vi vi = new Vi(ref, nom, preu, estoc, lloc, origen, tipus, collita);
            return vi.esValid() ? vi : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "\n" +
               "    Ref: " + ref + "\n" +
               "    Vi: " + nom + "\n" +
               "    Preu: " + preu + "\n" +
               "    Estoc: " + estoc + "\n" +
               (lloc != null ? "    Lloc: " + lloc + "\n" : "") +
               (origen != null ? "    D.O.: " + origen + "\n" : "") +
               (tipus != null ? "    Tipus: " + tipus + "\n" : "") +
               (collita != null ? "    Collita: " + collita + "\n" : "");
    }
}
