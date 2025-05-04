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
import java.io.FileNotFoundException;

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
            Vi resultat;
            if (!modificat) {
                resultat = botiga.getPrimer();
                if (resultat != null) System.out.println("Trobat:" + resultat.toString());
                return;
            } 
            resultat = botiga.cerca(vi);
            if (resultat == null) {
                System.out.println("No trobat");
            } else {
                System.out.println("Trobat:" + resultat.toString());
            }
        } else {
            String refNormalitzat = Vi.normalitzaString(ref);
            Vi vi = botiga.cerca(refNormalitzat);
            if (vi == null) {
                System.out.println("No trobat");
            } else {
                System.out.println("Trobat:" + vi.toString());
            }
        }
    }
    
    


    public String processaModifica(String nom) {
        Vi vi = botiga.cerca(nom);
        if (vi == null) {
            return "No trobat";
        }
        System.out.printf("preu (enter " + vi.getPreu() + ")> ");
        int preu = vi.getPreu();
        String inputPreu = Entrada.readLine();
        if (!inputPreu.isEmpty()) {
            if (UtilString.esEnter(inputPreu)) {
                preu = Integer.parseInt(inputPreu);
            } else {
                return "ERROR: cal un enter positiu";
            }
        }
        System.out.printf("estoc (enter " + vi.getEstoc() + ")> ");
        int estoc = vi.getEstoc();
        String inputEstoc = Entrada.readLine();
        if (!inputEstoc.isEmpty()) {
            if (UtilString.esEnter(inputEstoc)) {
                estoc = Integer.parseInt(inputEstoc);
            } else {
                return "ERROR: cal un enter positiu";
            }
        }
        vi.setNom(nom);
        vi.setPreu(preu);
        vi.setEstoc(estoc);
        return ("Modificat:" + vi.toString());
    }

    public void processaElimina(String nom) {
        Vi vi = botiga.cerca(nom);
        if (botiga.cerca(nom) == null) {
            System.out.println("No trobat");
        } else {
            System.out.println("A eliminar:" + vi.toString());
            System.out.print("Segur?> ");
            String conf = Entrada.readLine();
            if (UtilitatsConfirmacio.respostaABoolean(conf)) {
                if (vi.getEstoc() > 0) {
                    System.out.println("ERROR: no s'ha pogut eliminar");
                    return;
                }
                if (botiga.cerca(nom) != null) {
                    vi = botiga.elimina(nom);
                    System.out.println("Eliminat");
                } else {
                    System.out.println("ERROR: no s'ha pogut eliminar");
                }
            } else {
                System.out.println("No eliminat");
            }
        }
    }
    
    public static void accion (String arg, Entorn entorn) {
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
    
    public static void main (String[] args) throws IOException {
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
