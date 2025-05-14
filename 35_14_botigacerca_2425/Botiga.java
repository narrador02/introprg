/* 
 * Programa que permite gestionar la colección de vinos
 * que hay en la botiga, verificando su estock y disponibilitad.
 */
import java.util.ArrayList;
import java.util.List;

public class Botiga {
    private List<Vi> vins = new ArrayList<>();

    public void afegeix(Vi vi) {
        vins.add(vi);
    }

    public List<Vi> cerca(Vi plantilla) {
        List<Vi> resultats = new ArrayList<>();
        for (Vi vi : vins) {
            if (UtilString.esPlantillaDeText(plantilla.getNom(), vi.getNom()) &&
                UtilString.esPlantillaDeText(plantilla.getDoOrigen(), vi.getDoOrigen()) &&
                UtilString.esPlantillaDeText(plantilla.getTipus(), vi.getTipus())) {
                resultats.add(vi);
            }
        }
        return resultats;
    }
}
