/* 
 * Programa que permite interaccionar con la Botiga y los vinos de manera
 * cómoda a partir de métodos desde el terminal.
 */
import java.util.List;

public class Entorn {
    public static void main(String[] args) {
        Botiga botiga = new Botiga();

        botiga.afegeix(new Vi("RBL2020001", "Roura Blanc", 1012, 42, "P21E45N55E", "Empordà", "blanc", "2020"));
        botiga.afegeix(new Vi("RNG2020002", "Roura Negre", 990, 30, "P21E45N55N", "Empordà", "negre", "2020"));
        botiga.afegeix(new Vi("PEL2020003", "Perelada Negre", 1100, 50, "P22E46N55E", "Empordà", "negre", "2020"));
        botiga.afegeix(new Vi("LLR2020004", "Llopart Rosat", 1230, 10, "P20E40N50S", "Penedès", "rosat", "2021"));

        Vi plantilla = new Vi(null, "rou", -1, -1, null, "emp", "negre", null);

        List<Vi> resultats = botiga.cerca(plantilla);

        for (Vi vi : resultats) {
            System.out.println(vi);
        }
    }
}
