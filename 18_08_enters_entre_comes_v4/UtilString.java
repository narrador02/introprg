/*
 * Fichero con distintas funciones de múltiples utilidades
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

    public static int demanarEnter () {
        String entrada = "";
        boolean esEnter = false;
        int numero = 0;
        while (true) {
            entrada = Entrada.readLine();
            esEnter = esEnter(entrada);
            if (esEnter) {
                numero = Integer.parseInt(entrada);
                return numero;
            } else {
                System.out.println("Per favor, un valor enter");
            }
        }
    }

    public static char demanarCaracter () {
        String entrada = Entrada.readLine();
        if (entrada.isEmpty()) {
            char ch = ',';
            return ch;
        }
        char ch = entrada.charAt(0);
        return ch;
    }

    public static String entreComes (int[] numeros, char ch) {
        String resposta = "";
        if (numeros.length >= 1) {
            resposta = "" + numeros[0];
            for (int i = 1; i < numeros.length; i++) {
                resposta = resposta + (ch + " " + numeros[i]);
            }
        }
        return resposta;
    }
}
