/*
 * Programa principal que analiza archivos.
 * Recopila direcciones de correo válidas y muestra resultados.
 * Informa si hay errores o si no se encuentra ninguna.
 */
import java.io.*;
import java.util.*;

public class RecopilaAdreces {
    public static void main(String[] args) {
        Recopilador r = new Recopilador();
        for (String nomFitxer : args) {
            String contingut = llegeixFitxer(nomFitxer);
            if (contingut != null) {
                r.processa(nomFitxer, contingut);
            }
        }
        mostraResultat(r);
    }
    
    public static void mostraResultat(Recopilador r) {
        List<Adressa> adreces = r.getAdreces();
        if (adreces.isEmpty()) {
            System.out.println("No s'han trobat adreces");
        } else {
            for (Adressa a : adreces) {
                System.out.println(a);
                for (String nom : r.getNoms(a)) {
                    System.out.println("- " + nom);
                }
            }
        }
    }

    public static String llegeixFitxer(String nomFitxer) {
        File fitxer = new File(nomFitxer);
        if (!fitxer.exists()) {
            System.out.println("No s'ha trobat el fitxer " + nomFitxer + "\n");
            return null;
        }
        if (!fitxer.isFile() || !fitxer.canRead()) {
            System.out.println("No s'ha pogut llegir el fitxer " + nomFitxer + "\n");
            return null;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fitxer));
            StringBuilder sb = new StringBuilder();
            String linia;
            while ((linia = br.readLine()) != null) {
                sb.append(linia).append('\n');
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            System.out.println("No s'ha pogut llegir el fitxer " + nomFitxer + "\n");
            return null;
        }
    }
}
