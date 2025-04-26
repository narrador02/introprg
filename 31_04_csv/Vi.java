/*
 * Clase Vi que contiene todas las propiedades
 * necesarias, sus constructores y métodos
 */
public class Vi {
    private String nom;
    private int preu;
    private int estoc = 0;
    
    public Vi(String nom, int preu) {
        this.nom = normalitzaNom(nom);
        if (preu < 0) {
            this.preu = -1;
        } else {
            setPreu(preu);
        }
    }
    
    public Vi(String nom, int preu, int estoc) {
        this.nom = normalitzaNom(nom);
        if (preu < 0) {
            this.preu = -1;
        } else {
            setPreu(preu);
        }
        if (estoc < 0) {
            this.estoc = -1;
        } else {
            setEstoc(estoc);
        }
    }
    
    public String getNom() { return nom; }
    
    public int getPreu() { return preu; }
    
    public int getEstoc() { return estoc; }
    
    public void setNom(String nom) {
        this.nom = normalitzaNom(nom);
    }
    
    public void setPreu(int preu) {
        if (preu > 0) {
            this.preu = preu;
        }
    }
    
    public void setEstoc(int estoc) {
        if (estoc > 0) {
            this.estoc = estoc;
        }
    }
    
    public boolean esValid() {
        if (getNom().equals("NOM NO VÀLID!") || preu < 0 || estoc < 0) {
            return false;
        }
        return true;
    }
    
    public static String normalitzaNom(String nom) {
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
    
    public String[] aArrayString() {
        String[] dades = new String[3];
        dades[0] = nom;
        dades[1] = Integer.toString(preu);
        dades[2] = Integer.toString(estoc);
        return dades;
    }
    
    public static Vi deArrayString(String[] dades) {
        if (dades.length != 3) {
            return null;
        }
        String nom = dades[0];
        if (!UtilString.esEnter(dades[1]) || !UtilString.esEnter(dades[2])) {
            return null;
        }
        int preu = Integer.parseInt(dades[1]);
        if (preu < 0) {
            return null;
        }
        int estoc = Integer.parseInt(dades[2]);
        if (estoc < 0) {
            return null;
        }
        Vi vi = new Vi(nom, preu, estoc);
        if (vi.getNom().equals("NOM NO VÀLID!")) {
            return null;
        }
        return new Vi(nom, preu, estoc);
    }

    @Override
    public String toString() {
        return "\n" +
               "    Vi: " + nom + "\n" +
               "    Preu: " + preu + "\n" +
               "    Estoc: " + estoc + "\n";
    }
}
