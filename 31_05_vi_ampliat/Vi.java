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


    public Vi(String ref, String nom, int preu, int estoc, String lloc, String origen, String tipus, String collita) {
        if (ref != null) {
            this.ref = normalitzaString(ref);
        }
        if (nom != null) {
            this.nom = normalitzaString(nom);
        }
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
        if (lloc != null) {
            this.lloc = normalitzaString(lloc);
        }
        if (origen != null) {
            this.origen = normalitzaString(origen);
        }
        if (tipus != null) {
            this.tipus = normalitzaString(tipus);
        }
        if (collita != null) {
            this.collita = normalitzaString(collita);
        }
    }

    public static Vi deArrayString(String[] dades) {
        if (dades == null || dades.length != 8) {return null;}
        if (dades[0] == null || dades[0].isBlank() ||
            dades[1] == null || dades[1].isBlank() ||
            dades[4] == null || dades[4].isBlank() ||
            dades[5] == null || dades[5].isBlank() ||
            dades[6] == null || dades[6].isBlank() ||
            dades[7] == null || dades[7].isBlank()) {
            return null;
        }
        if (dades[2] == null || dades[3] == null || dades[2].isBlank() || dades[3].isBlank()
            ||!UtilString.esEnter(dades[2]) || !UtilString.esEnter(dades[3])) {
            return null;
        }
        int preu = Integer.parseInt(dades[2]);
        if (preu < 0) {
            return null;
        }
        int estoc = Integer.parseInt(dades[3]);
        if (estoc < 0) {
            return null;
        }
        return new Vi(dades[0], dades[1], preu, estoc, dades[4], dades[5], dades[6], dades[7]);
    }

    public String[] aArrayString() {
        String[] dades = new String[8];
        dades[0] = ref;
        dades[1] = nom;
        dades[2] = Integer.toString(preu);
        dades[3] = Integer.toString(estoc);
        dades[4] = lloc;
        dades[5] = origen;
        dades[6] = tipus;
        dades[7] = collita;
        return dades;
    }

    public String getRef() {return ref;}
    public void setRef(String ref) {this.ref = ref;}
    
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getPreu() {return preu;}
    public void setPreu(int preu) {
        if (preu >= 0 || this.preu == -1) {
            this.preu = preu;
        }
    }

    public int getEstoc() {return estoc;}
    public void setEstoc(int estoc) {
        if (estoc >= 0) {
            this.estoc = estoc;
        }
    }

    public String getLloc() {return lloc;}
    public void setLloc(String lloc) {
        if (lloc == null || lloc.trim().isEmpty()) {
            this.lloc = "P21E45N55E";
        } else {
            this.lloc = normalitzaString(lloc);
        }
    }

    public String getOrigen() {return origen;}
    public void setOrigen(String origen) {this.origen = origen;}

    public String getTipus() {return tipus;}
    public void setTipus(String tipus) {this.tipus = tipus;}

    public String getCollita() {return collita;}
    public void setCollita(String collita) {this.collita = collita;}

    public boolean esValid() {
        boolean valid = true;
        if (getRef() == null) {valid = false;}
        if (getNom() == null) {valid = false;}
        if (getPreu() == -1) {valid = false;}
        if (getEstoc() == -1) {valid = false;}
        if (getLloc() == null) {valid = false;}
        if (getOrigen() == null) {valid = false;}
        if (getTipus() == null) {valid = false;}
        if (getCollita() == null) {valid = false;}
        return valid;
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
        if (resultat.isBlank()) {
            return null;
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "\n" +
                "    Ref: " + ref + "\n" +
                "    Nom: " + nom + "\n" +
                "    Preu: " + preu + "\n" +
                "    Estoc: " + estoc + "\n" +
                "    Lloc: " + lloc + "\n" +
                "    D.O.: " + origen + "\n" +
                "    Tipus: " + tipus + "\n" +
                "    Collita: " + collita + "\n";
    }
}
