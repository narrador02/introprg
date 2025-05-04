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
        recorregutActual = -1;
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

    public Vi getPrimer() {
        for (Vi vi : vins) {
            if (vi != null) {
                return vi;
            }
        }
        return null;
    }
    
    
    public Vi afegeix(Vi vi) {
        if (vi.esValid() && vi != null && cerca(vi) == null) {
            for (int i = 0; i < vins.length; i++) {
                if (vins[i] == null) {
                    vins[i] = vi;
                    return vi;
                }
            }
        }
        return null;
    }

    public Vi elimina(String ref) {
        String refVi = Vi.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i] != null && vins[i].getRef().equalsIgnoreCase(refVi)) {
                Vi vi = vins[i];
                if (vi.getEstoc() > 0) {
                    return null;
                }
                vins[i] = null;
                return vi;
            }
        }
        return null;
    }

    public Vi cerca(String ref) {
        String refVi = Vi.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i] != null) {
                String vi = vins[i].getRef().toLowerCase();
                refVi = refVi.toLowerCase();
                if (vi.equalsIgnoreCase(refVi)) {
                    return vins[i];
                }
            }
        }
        return null;
    }
    //ROURABLA20200232;Roura Blanc;1012;42;P21E45N55E;Alella;blanc;2020
    public Vi cerca(Vi plantilla) {
        for (Vi vi : vins) {
            if (vi == null) continue;
            if (coincideixAmbPlantilla(vi, plantilla)) {
                return vi;
            }
        }
        return null;
    }

    private boolean coincideixAmbPlantilla(Vi vi, Vi plantilla) {
        if (plantilla.getRef() != null && !plantilla.getRef().isEmpty() &&
            !vi.getRef().equalsIgnoreCase(plantilla.getRef())) {
            return false;
        }
        if (plantilla.getNom() != null && !plantilla.getNom().isEmpty() &&
            !vi.getNom().equalsIgnoreCase(plantilla.getNom())) {
            return false;
        }
        if (plantilla.getPreu() >= 0 && vi.getPreu() > plantilla.getPreu()) {
            return false;
        }
        if (plantilla.getEstoc() >= 0 && vi.getEstoc() < plantilla.getEstoc()) {
            return false;
        }
        if (plantilla.getLloc() != null && !plantilla.getLloc().isEmpty() &&
            !vi.getLloc().equalsIgnoreCase(plantilla.getLloc())) {
            return false;
        }
        if (plantilla.getOrigen() != null && !plantilla.getOrigen().isEmpty() &&
            !vi.getOrigen().equalsIgnoreCase(plantilla.getOrigen())) {
            return false;
        }
        if (plantilla.getTipus() != null && !plantilla.getTipus().isEmpty() &&
            !vi.getTipus().equalsIgnoreCase(plantilla.getTipus())) {
            return false;
        }
        if (plantilla.getCollita() != null && !plantilla.getCollita().isEmpty() &&
            !vi.getCollita().equalsIgnoreCase(plantilla.getCollita())) {
            return false;
        }
        return true;
    }    
}
