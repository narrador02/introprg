/* 
 * Programa que crea y verifica los vinos para tenerlos controlados.
 */
public class Vi {
    private String nom;
    private String doOrigen;
    private String tipus;

    public Vi(String nom, String doOrigen, String tipus) {
        this.nom = nom;
        this.doOrigen = doOrigen;
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public String getDoOrigen() {
        return doOrigen;
    }

    public String getTipus() {
        return tipus;
    }

    @Override
    public String toString() {
        return nom + " (" + doOrigen + ") - " + tipus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vi)) return false;
        Vi v = (Vi) obj;
        return nom.equals(v.nom) && doOrigen.equals(v.doOrigen) && tipus.equals(v.tipus);
    }

    @Override
    public int hashCode() {
        return nom.hashCode() + doOrigen.hashCode() + tipus.hashCode();
    }
}
