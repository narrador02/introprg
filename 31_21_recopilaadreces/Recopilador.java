/*
 * Procesa textos para extraer correos válidos.
 * Asocia cada correo con los archivos donde aparece.
 * Devuelve las direcciones y archivos ordenados.
*/
import java.util.*;

public class Recopilador {
    private static final String SEPARADORS = "[\\s\\[{(<>})\\],;:'\"=|/\\!?]";
    private Map<Adressa, List<String>> adreces = new TreeMap<>();

    public int processa(String nom, String text) {
        if (text == null) return 0;
        Set<Adressa> trobades = new HashSet<>();
        String[] paraules = text.split(SEPARADORS);

        for (String p : paraules) {
            if (Adressa.esValida(p)) {
                try {
                    Adressa a = Adressa.fromString(p);
                    if (trobades.add(a)) {
                        adreces.putIfAbsent(a, new ArrayList<>());
                        List<String> llista = adreces.get(a);
                        if (!llista.contains(nom)) {
                            llista.add(nom);
                        }
                    }
                } catch (IllegalArgumentException ignored) {}
            }
        }
        return trobades.size();
    }

    public List<Adressa> getAdrecess() {
        return new ArrayList<>(adreces.keySet());
    }

    public List<String> getNoms(Adressa a) {
        List<String> noms = adreces.get(a);
        List<String> resultat = new ArrayList<>(noms);
        Collections.sort(resultat);
        return resultat;
    }
}
