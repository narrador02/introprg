/*
 * Programa principal que recibe archivos por argumentos.
 * Recopila y muestra direcciones de correo ordenadas.
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

        List<Adressa> adreces = r.getAdrecess();
        if (adreces.isEmpty()) {
            System.out.println("...no se aún");
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFitxer));
            StringBuilder sb = new StringBuilder();
            String linia;
            while ((linia = br.readLine()) != null) {
                sb.append(linia).append('\n');
            }
            br.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("boh" + nomFitxer);
        } catch (IOException e) {
            System.out.println("boh" + nomFitxer);
        }
        return null;
    }
}

