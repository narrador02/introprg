/* Fichero con distintas funcionalidades */
public class UtilString {
    public static boolean esPrefix(String text, String prefix, boolean extricte) {
        boolean confirmacio = false;
        if (!extricte) {
            text = text.toLowerCase();
            prefix = prefix.toLowerCase();
            text = noExtricteVocals(text);
            prefix = noExtricteVocals(prefix);
            confirmacio = esPrefix (text, prefix);
        } else {
            confirmacio = esPrefix (text, prefix);
        }
        return confirmacio;
    }
    
    public static boolean esPrefix(String text, String prefix) {
        boolean confirmacio = false;
        if (text.isEmpty()) {
            return confirmacio;
        }
        if (prefix.isEmpty()) {
            confirmacio = true;
            return confirmacio;
        }
        if (text.length() < prefix.length()) {
            return confirmacio;
        }
        confirmacio = true;
        for (int i = 0; i < prefix.length(); i++) {
            if (text.charAt(i) != prefix.charAt(i)) {
                confirmacio = false;
                break;
            }
        }
        return confirmacio;
    }
    
    public static boolean esSufix(String text, String sufix, boolean extricte) {
        boolean confirmacio = false;
        if (!extricte) {
            text = text.toLowerCase();
            sufix = sufix.toLowerCase();
            text = noExtricteVocals(text);
            sufix = noExtricteVocals(sufix);
            confirmacio = esSufix (text, sufix);
        } else {
            confirmacio = esSufix (text, sufix);
        }
        return confirmacio;
    }
    
    public static boolean esSufix(String text, String sufix) {
        String principal = "";
        boolean confirmacio = false;
        if (text.isEmpty()) {
            return confirmacio;
        }
        if (sufix.isEmpty()) {
            confirmacio = true;
            return confirmacio;
        }
        if (text.length() < sufix.length()) {
            return confirmacio;
        }
        confirmacio = true;
        int prova = text.length() - sufix.length();
        for (int i = prova; i <= text.length() - 1; i++) {
            principal = principal + text.charAt(i);
        }
        for (int p = 0; p < sufix.length(); p++) {
            if (principal.charAt(p) != sufix.charAt(p)) {
                confirmacio = false;
                break;
            }
        }
        return confirmacio;
    }

    public static String noExtricteVocals (String text) {
        String resposta = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'à') {
                resposta = resposta + "a";
            } else if (text.charAt(i) == 'e' || text.charAt(i) == 'è' || text.charAt(i) == 'é') {
                resposta = resposta + "e";
            } else if (text.charAt(i) == 'i' || text.charAt(i) == 'í' || text.charAt(i) == 'ï') {
                resposta = resposta + "i";
            } else if (text.charAt(i) == 'o' || text.charAt(i) == 'ò' || text.charAt(i) == 'ó') {
                resposta = resposta + "o";
            } else if (text.charAt(i) == 'u' || text.charAt(i) == 'ú' || text.charAt(i) == 'ü') {
                resposta = resposta + "u";
            } else if (text.charAt(i) == 'c' || text.charAt(i) == 'ç') {
                resposta = resposta + "c";
            } else {
                resposta = resposta + text.charAt(i);
            }
        }
        return resposta;
    }
}
