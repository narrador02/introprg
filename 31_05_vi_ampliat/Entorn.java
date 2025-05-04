/* 
 * Programa que permite interaccionar con la Botiga y los vinos de manera
 * cómoda a partir de métodos desde el terminal
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class Entorn {
    private final Botiga botiga = new Botiga();
    public static boolean surt = false;

    public void carregarBotiga() throws IOException {
        File file = new File("botiga.csv");
        int cont = 0;
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader("botiga.csv"));
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dades = linia.split(";");
                Vi vi = Vi.deArrayString(dades);
                if (vi != null) {
                    botiga.afegeix(vi);
                    cont++;
                }
            }
            br.close();
        }
        System.out.println("Referències llegides: " + cont);
    }

    public void guardarBotiga() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("botiga.csv"));
        botiga.iniciaRecorregut();
        Vi vi;
        int cont = 0;
        while ((vi = botiga.getSeguent()) != null) {
            String[] dades = vi.aArrayString();
            String linia = String.join(";", dades);
            bw.write(linia);
            bw.newLine();
            cont++;
        }
        System.out.println("Referències guardades: " + cont);
        bw.close();
    }

    public void processaCerca(String ref) {
        if (ref == null || ref.isEmpty()) {
            Vi plantilla = new Vi(null, null, -1, -1, null, null, null, null);
            
            System.out.print("ref> ");
            String input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setRef(input);
            }
            
            System.out.print("nom> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setNom(input);
            }
            
            System.out.print("preu max.> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                if (UtilString.esEnter(input)) {
                    plantilla.setPreu(Integer.parseInt(input));
                } else {
                    System.out.println("ERROR: el preu ha de ser un enter");
                    return;
                }
            }
            
            System.out.print("estoc min.> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                if (UtilString.esEnter(input)) {
                    plantilla.setEstoc(Integer.parseInt(input));
                } else {
                    System.out.println("ERROR: l'estoc ha de ser un enter");
                    return;
                }
            }
            
            System.out.print("lloc> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setLloc(input);
            }
            
            System.out.print("D.O.> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setOrigen(input);
            }
            
            System.out.print("tipus> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setTipus(input);
            }
            
            System.out.print("collita> ");
            input = Entrada.readLine();
            if (!input.isEmpty() && !input.equals("!")) {
                plantilla.setCollita(input);
            }
            
            Vi trobat = botiga.cerca(plantilla);
            if (trobat == null) {
                trobat = botiga.getPrimer(); 
            }
            
            if (trobat != null) {
                System.out.println("Trobat:" + trobat.toString());
            } else {
                System.out.println("No trobat");
            }
        } else {
            Vi trobat = botiga.cerca(ref);
            if (trobat != null) {
                System.out.println("Trobat:" + trobat.toString());
            } else {
                System.out.println("No trobat");
            }
        }
    }

    public Vi processaAfegeix(String nom, int preu, int estoc) {
        System.out.println("Comanda temporalment no disponible");
        return null;
    }
    
    public String processaModifica(String nom) {
        System.out.println("Comanda temporalment no disponible");
        return null;
    }
    
    public void processaElimina(String nom) {
        System.out.println("Comanda temporalment no disponible");
    }

    public static void accion(String arg, Entorn entorn) {
        arg = arg.toLowerCase();
        switch (arg) {
            case "ajuda":
                System.out.printf("Comandes disponibles:\najuda\ncerca\nsurt\n");
                break;
            case "afegeix":
            case "modifica":
            case "elimina":
                System.out.println("Comanda temporalment no disponible");
                break;
            case "cerca":
                entorn.processaCerca("");
                break;
            case "surt":
                surt = true;
                break;
            default:
                System.out.println("Comanda no reconeguda. Escriu 'ajuda' per veure les opcions.");
        }
    }

    public static void main(String[] args) {
        Entorn entorn = new Entorn();
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
        
        try {
            entorn.carregarBotiga();
        } catch (IOException e) {
            System.out.println("Error carregant la botiga: " + e.getMessage());
        }
        
        while (!surt) {
            System.out.print("botiga> ");
            String arg = Entrada.readLine();
            accion(arg, entorn);
        }
        
        try {
            entorn.guardarBotiga();
        } catch (IOException e) {
            System.out.println("Error guardant la botiga: " + e.getMessage());
        }
        System.out.println("adéu");
    }
}
