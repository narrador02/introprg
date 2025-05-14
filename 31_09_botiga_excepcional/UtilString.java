/*
 * Fichero donde introduzcoa las utilitades para hacer uso de los Strings y tenerlos centralitzados.
 */
public class UtilString {
    public static boolean esEnter(String text) {
        if (text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) == false) {
                return false;
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

    public static String normalitzaNom(String nom) {
        nom = nom.trim();
        String resultat = "";
        int cont = 0;
        for (int i = 0; i < nom.length(); i++) {
            char caracter = nom.charAt(i);
            if (cont == 0 && Character.isWhitespace(caracter)) {
                cont++;
                resultat = resultat + nom.charAt(i);
                continue;
            } else if (Character.isWhitespace(caracter)) {
                continue;
            }
            // He de veure haviam si funciona el contador
            cont = 0;
            resultat = resultat + nom.charAt(i);
        }
        if (resultat.isBlank()) {
            resultat = "NOM NO VÀLID!";
        }
        return resultat;
    }
}
