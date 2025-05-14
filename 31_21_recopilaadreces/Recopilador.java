/*
 * Clase que procesa textos para extraer correos válidos.
 * Asocia cada correo con los archivos donde aparece.
 * Devuelve las direcciones y archivos ordenados.
*/
import java.util.*;

public class Recopilador {
    private static final String SEPARADORS = "[\\s\\[{(<>})\\],;:'\"=|/\\!?]";
    private Map<Adressa, Set<String>> mapa = new TreeMap<>();

    public int processa(String nom, String text) {
        if (text == null) return 0;
        Set<Adressa> trobades = new HashSet<>();
        String[] paraules = text.split(SEPARADORS);
        for (String p : paraules) {
            if (Adressa.esValida(p)) {
                try {
                    Adressa a = Adressa.fromString(p);
                    if (trobades.add(a)) {
                        mapa.putIfAbsent(a, new TreeSet<>());
                        mapa.get(a).add(nom);
                    }
                } catch (IllegalArgumentException ignored) {}
            }
        }
        return trobades.size();
    }

    public List<Adressa> getAdrecess() {
        return new ArrayList<>(mapa.keySet());
    }

    public List<String> getNoms(Adressa a) {
        List<String> noms = new ArrayList<>(mapa.get(a));
        Collections.sort(noms);
        return noms;
    }
}

