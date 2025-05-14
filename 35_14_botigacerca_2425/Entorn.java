/*
 * Programa que permite interaccionar con la Botiga y los vinos de manera
 * cómoda a partir de métodos desde el terminal.
 */
import java.io.*;
import java.util.List;

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
        int cont = 0;
        for (Vi vi : botiga.getVins()) {
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
        if (ref.isEmpty()) {
            boolean modificat = false;
            Vi vi = new Vi("", "", 0, 0, "", "", "", "");
            while (true) {
                System.out.print("ref> ");
                ref = Entrada.readLine();
                if (ref.equals("!")) break;
                if (!ref.isEmpty()) {
                    vi.setRef(ref);
                    modificat = true;
                }

                System.out.print("nom> ");
                String nom = Entrada.readLine();
                if (nom.equals("!")) break;
                if (!nom.isEmpty()) {
                    vi.setNom(nom);
                    modificat = true;
                }

                System.out.print("preu max.> ");
                String preu = Entrada.readLine();
                if (preu.equals("!")) break;
                if (!preu.isEmpty()) {
                    if (UtilString.esEnter(preu)) {
                        vi.setPreu(Integer.parseInt(preu));
                        modificat = true;
                    } else {
                        System.out.println("ERROR: el valor ha de ser un enter positiu");
                        break;
                    }
                }

                System.out.print("estoc min.> ");
                String estoc = Entrada.readLine();
                if (estoc.equals("!")) break;
                if (!estoc.isEmpty()) {
                    if (UtilString.esEnter(estoc)) {
                        vi.setEstoc(Integer.parseInt(estoc));
                        modificat = true;
                    } else {
                        System.out.println("ERROR: el valor ha de ser un enter positiu");
                        break;
                    }
                }

                System.out.print("lloc> ");
                String lloc = Entrada.readLine();
                if (lloc.equals("!")) break;
                if (!lloc.isEmpty()) {
                    vi.setLloc(lloc);
                    modificat = true;
                }

                System.out.print("D.O.> ");
                String origen = Entrada.readLine();
                if (origen.equals("!")) break;
                if (!origen.isEmpty()) {
                    vi.setOrigen(origen);
                    modificat = true;
                }

                System.out.print("tipus> ");
                String tipus = Entrada.readLine();
                if (tipus.equals("!")) break;
                if (!tipus.isEmpty()) {
                    vi.setTipus(tipus);
                    modificat = true;
                }

                System.out.print("collita> ");
                String collita = Entrada.readLine();
                if (collita.equals("!")) break;
                if (!collita.isEmpty()) {
                    vi.setCollita(collita);
                    modificat = true;
                }
                break;
            }

            List<Vi> resultats;
            if (!modificat) {
                resultats = botiga.getVins();
            } else {
                resultats = botiga.cerca(vi);
            }

            if (resultats.isEmpty()) {
                System.out.println("No trobat");
            } else {
                for (Vi trobat : resultats) {
                    System.out.println(trobat);
                }
            }

        } else {
            String refNormalitzat = UtilString.normalitzaString(ref);
            Vi vi = botiga.cerca(refNormalitzat);
            if (vi == null) {
                System.out.println("No trobat");
            } else {
                System.out.println("Trobat:" + vi.toString());
            }
        }
    }

    public static void accion(String arg, Entorn entorn) {
        arg = arg.toLowerCase();
        switch (arg) {
            case "ajuda":
                System.out.printf("Comandes disponibles:\najuda\ncerca\nsurt\n");
                break;
            case "afegeix":
                System.out.println("Comanda temporalment no disponible");
                break;
            case "cerca":
                entorn.processaCerca("");
                break;
            case "modifica":
                System.out.println("Comanda temporalment no disponible");
                break;
            case "elimina":
                System.out.println("Comanda temporalment no disponible");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            Entorn entorn = new Entorn();
            System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
            entorn.carregarBotiga();
            while (!surt) {
                System.out.print("botiga> ");
                String arg = Entrada.readLine();
                if (arg.equalsIgnoreCase("surt")) {
                    break;
                }
                accion(arg, entorn);
            }
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("adéu");
        }
    }
}
