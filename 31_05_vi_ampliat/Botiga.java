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

    public Vi getPrimer() {
        for (Vi vi : vins) {
            if (vi != null) {
                return vi;
            }
        }
        return null;
    }

    public Vi afegeix(Vi vi) {
        if (vi == null || !vi.esValid()) return null;
        
        if (vi.getRef() != null && cerca(vi.getRef()) != null) {
            return null;
        }
        
        if (cerca(vi.getNom()) != null) {
            return null;
        }

        for (int i = 0; i < vins.length; i++) {
            if (vins[i] == null) {
                vins[i] = vi;
                return vi;
            }
        }
        return null;
    }

    public Vi elimina(String ref) {
        if (ref == null) return null;
        
        String refNormalitzada = Vi.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i] != null && vins[i].getRef() != null && 
                vins[i].getRef().equalsIgnoreCase(refNormalitzada)) {
                
                if (vins[i].getEstoc() > 0) {
                    return null;
                }
                
                Vi eliminat = vins[i];
                vins[i] = null;
                return eliminat;
            }
        }
        return null;
    }

    public Vi cerca(String text) {
        if (text == null) return null;
        
        String textNormalitzat = Vi.normalitzaString(text);
        if (textNormalitzat == null) return null;
        
        for (Vi vi : vins) {
            if (vi != null) {
                if (vi.getRef() != null && vi.getRef().equalsIgnoreCase(textNormalitzat)) {
                    return vi;
                }
                if (vi.getNom() != null && vi.getNom().equalsIgnoreCase(textNormalitzat)) {
                    return vi;
                }
            }
        }
        return null;
    }

    public Vi cerca(Vi plantilla) {
        if (plantilla == null) return null;
        
        for (Vi vi : vins) {
            if (vi != null && coincideixAmbPlantilla(vi, plantilla)) {
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
