/* 
 * Programa que permite gestionar la colección de vinos
 * que hay en la botiga, verificando su stock y disponibilitad
 */
public class Botiga {
    private static final int DEFAULT_MAX_VINS = 10;
    private Vi[] vins;
    private int recorregutActual;

    public Botiga() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }

    public Botiga(int maxVins) {
        if (maxVins < 1) {
            vins = new Vi[DEFAULT_MAX_VINS];
        } else {
            vins = new Vi[maxVins];
        }
    }
    
    public void iniciaRecorregut() {
        recorregutActual = 0;
    }

    public Vi getSeguent() {
        while (recorregutActual >= 0 && recorregutActual < vins.length) {
            Vi vi = vins[recorregutActual++];
            if (vi != null) {
                return vi;
            }
        }
        return null;
    }

    public Vi afegeix(Vi vi) {
        if (vi.esValid()) {
            for (int i = 0; i < vins.length; i++) {
                if (vins[i] != null && vins[i].getNom().equals(vi.getNom())) {
                    return null;
                }
            }
            for (int i = 0; i < vins.length; i++) {
                if (vins[i] == null) {
                    vins[i] = vi;
                    return vi;
                }
            }
        }
        return null;
    }

    public Vi elimina(String nom) {
        String nomVi = Vi.normalitzaNom(nom);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i] != null && vins[i].getNom().equals(nomVi)) {
                if (vins[i].getEstoc() > 0) {
                    return null;
                } else {
                    Vi vi = vins[i];
                    vins[i] = null;
                    return vi;
                }
            }
        }
        return null;
    }

    public Vi cerca(String nom) {
        String nomVi = Vi.normalitzaNom(nom);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i] != null) {
                String vi = vins[i].getNom().toLowerCase();
                nomVi = nomVi.toLowerCase();
                if (vi.equals(nomVi)) {
                    return vins[i];
                }
            }
        }
        return null;
    }
}
