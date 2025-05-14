/* 
 * Programa que permite gestionar la colección de vinos
 * que hay en la botiga, verificando su estock y disponibilitad.
 */
import java.util.ArrayList;
import java.util.List;

public class Botiga {
    private List<Vi> vins = new ArrayList<>();

    public Vi afegeix(Vi vi) {
        vins.add(vi);
        return vi;
    }

    public Vi cerca(String ref) throws IllegalArgumentException {
        if (ref == null) {
            throw new IllegalArgumentException("La referència no pot ser null");
        }
        String refVi = UtilString.normalitzaString(ref);
        for (Vi vi : vins) {
            if (vi.getRef().equalsIgnoreCase(refVi)) {
                return vi;
            }
        }
        return null;
    }

    public List<Vi> cerca(Vi plantilla) throws IllegalArgumentException {
        if (plantilla == null) {
            throw new IllegalArgumentException("La plantilla no pot ser null");
        }
        List<Vi> resultats = new ArrayList<>();
        for (Vi vi : vins) {
            if (coincideixAmbPlantilla(vi, plantilla)) {
                resultats.add(vi);
            }
        }
        return resultats;
    }

    private boolean coincideixAmbPlantilla(Vi vi, Vi plantilla) {
        if (!UtilString.esPlantillaDeText(plantilla.getRef(), vi.getRef())) return false;
        if (!UtilString.esPlantillaDeText(plantilla.getNom(), vi.getNom())) return false;
        if (plantilla.getPreu() >= 0 && vi.getPreu() > plantilla.getPreu()) return false;
        if (plantilla.getEstoc() >= 0 && vi.getEstoc() < plantilla.getEstoc()) return false;
        if (!UtilString.esPlantillaDeText(plantilla.getLloc(), vi.getLloc())) return false;
        if (!UtilString.esPlantillaDeText(plantilla.getOrigen(), vi.getOrigen())) return false;
        if (!UtilString.esPlantillaDeText(plantilla.getTipus(), vi.getTipus())) return false;
        if (!UtilString.esPlantillaDeText(plantilla.getCollita(), vi.getCollita())) return false;
        return true;
    }
}
