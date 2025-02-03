/*
 * Fichero con distintas funciones de múltiples utilidades
 */
public class UtilString {
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
