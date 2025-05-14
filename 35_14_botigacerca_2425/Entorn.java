/* 
 * Programa que permite interaccionar con la Botiga y los vinos de manera
 * cómoda a partir de métodos desde el terminal.
 */
import java.util.List;

public class Entorn {
    public static void main(String[] args) {
        Botiga botiga = new Botiga();

        botiga.afegeix(new Vi("Roura Blanc", "Empordà", "blanc"));
        botiga.afegeix(new Vi("Roura Negre", "Empordà", "negre"));
        botiga.afegeix(new Vi("Perelada Negre", "Empordà", "negre"));
        botiga.afegeix(new Vi("Llopart Rosat", "Penedès", "rosat"));

        // Cerca amb plantilla parcial
        Vi plantilla = new Vi("rou", "", "negre");

        List<Vi> resultats = botiga.cerca(plantilla);

        for (Vi vi : resultats) {
            System.out.println(vi);
        }
    }
}
