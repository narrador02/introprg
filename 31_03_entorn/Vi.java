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

    @Override
    public String toString() {
        return "\n" +
               "    Vi: " + nom + "\n" +
               "    Preu: " + preu + "\n" +
               "    Estoc: " + estoc + "\n";
    }
}
