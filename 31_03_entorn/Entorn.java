/* 
 * Programa que permite interaccionar con la Botiga y los vinos de manera
 * cómoda a partir de métodos desde el terminal
 */
public class Entorn {
    private final Botiga botiga = new Botiga();
    public static boolean surt = false;

    public Vi processaAfegeix(String nom, int preu, int estoc) {
        String nomNormalitzat = Vi.normalitzaNom(nom);
        Vi vi = new Vi(nomNormalitzat, preu, estoc);
        Vi viExistent = botiga.cerca(nomNormalitzat);
        if (viExistent != null) {
            return null;
        }
        botiga.afegeix(vi);
        System.out.println("Introduit:" + vi.toString());
        return vi;
    }
    
    public void processaCerca(String nom) {
        String nomNormalitzat = Vi.normalitzaNom(nom);
        Vi vi = botiga.cerca(nomNormalitzat);
        if (vi == null) {
            System.out.println("No trobat");
        } else {
            System.out.println("Trobat:" + vi.toString());
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
                System.out.printf("Comandes disponibles:\najuda\ncerca\nafegeix\nmodifica\nelimina\nsurt\n");
                break;
            case "afegeix":
                System.out.printf("nom (enter cancel·la)> ");
                String nom = Entrada.readLine();
                if (nom.isEmpty()) {
                    break;
                }
                System.out.printf("preu (en cèntims)> ");
                String inputPreu = Entrada.readLine();
                int preu = 0;
                if (!UtilString.esEnter(inputPreu) && !inputPreu.isEmpty()) {
                    System.out.println("ERROR: cal un enter positiu");
                    break;
                }
                if (!inputPreu.isEmpty() && UtilString.esEnter(inputPreu)) {
                    preu = Integer.parseInt(inputPreu);
                }
                if (UtilString.esEnter(inputPreu) && preu < 0) {
                    System.out.println("ERROR: cal un enter positiu");
                    break;
                }
                System.out.printf("estoc (enter sense estoc)> ");
                String inputEstoc = Entrada.readLine();
                int estoc = 0;
                if (!UtilString.esEnter(inputEstoc) && !inputEstoc.isEmpty()) {
                    System.out.println("ERROR: cal un enter positiu");
                    break;
                }
                if (!inputEstoc.isEmpty() && UtilString.esEnter(inputEstoc)) {
                    estoc = Integer.parseInt(inputEstoc);
                }
                if (UtilString.esEnter(inputEstoc) && estoc < 0) {
                    System.out.println("ERROR: cal un enter positiu");
                    break;
                }
                Vi vi = entorn.processaAfegeix(nom, preu, estoc);
                if (vi == null) {
                    System.out.println("ERROR: no s'ha pogut afegir");
                }
                break;
            case "cerca":
                System.out.printf("nom (enter cancel·la)> ");
                nom = Entrada.readLine();
                if (nom.isEmpty()) {
                    break;
                }
                entorn.processaCerca(nom);
                break;
            case "modifica":
                System.out.printf("nom (enter cancel·la)> ");
                nom = Entrada.readLine();
                if (nom.isEmpty()) {
                    break;
                }
                System.out.println(entorn.processaModifica(nom));
                break;
            case "elimina":
                System.out.printf("nom (enter cancel·la)> ");
                nom = Entrada.readLine();
                if (nom.isEmpty()) {
                    break;
                }
                entorn.processaElimina(nom);
                break;
        }
    }
    
    public static void main (String[] args) {
        Entorn entorn = new Entorn();
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
        while (!surt) {
            System.out.print("botiga> ");
            String arg = Entrada.readLine();
            if (arg.equalsIgnoreCase("surt")) {
                System.out.println("adéu");
                break;
            }
            accion(arg, entorn);
        }
    }
}
