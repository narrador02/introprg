/*
 * Fichero multiusos que trata con Strings
 * para distintas finalidades 
 */
public class UtilString {
    public static boolean esEnter(String text) {
        if (text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) == false) {
                if (i == 0) {
                    String subcadena = Character.toString(text.charAt(i));
                    if (! subcadena.equals("+") && ! subcadena.equals("-")) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[] separa(String text, boolean inclouBlancs) {
        int quants = quantesParaules(text, inclouBlancs);
        String[] paraules = new String[quants];
        String paraula = "";
        String espais = "";
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (!paraula.isEmpty()) {
                    paraules[j] = paraula;
                    paraula = "";
                    j++;
                }
                if (inclouBlancs) {
                    espais += ch;
                }
            } else {
                if (!espais.isEmpty()) {
                    paraules[j] = espais;
                    espais = "";
                    j++;
                }
                paraula = paraula + ch;
            }
        }
        if (!paraula.isEmpty()) {
            paraules[j] = paraula;
        } else if (!espais.isEmpty()) {
            paraules[j] = espais;
        }
        return paraules;
    }
    
    public static String[] separa(String text) {
        return separa(text, false);
    }

    public static int quantesParaules(String text, boolean inclouBlancs) {
        int quants = 0;
        boolean esParaula = false;
        boolean esEspai = false;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (esParaula) {
                    quants++;
                    esParaula = false;
                }
                if (!esEspai && inclouBlancs) {
                    quants++;
                    esEspai = true;
                }
            } else {
                esParaula = true;
                esEspai = false;
            }
        }
        if (esParaula) {
            quants++;
        }
        return quants;
    }

    
}
