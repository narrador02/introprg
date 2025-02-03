/*
 * Fichero con una funcion que comprueba si un numero es entero
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
}
