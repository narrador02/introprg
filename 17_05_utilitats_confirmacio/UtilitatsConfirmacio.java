/* Utilitats de confirmació
 *
 * Aquest mòdul conté diferents utilitats per gestionar les confirmacions
 * Bé, de moment només en tenim una però potser anirem ampliant-ho
 */
public class UtilitatsConfirmacio {
    
    public static boolean respostaABoolean(String resposta) {
        String respuesta = "";
        for (int i=0;i<resposta.length();i++) {
            if (!Character.isWhitespace(resposta.charAt(i))) {
                respuesta = respuesta + resposta.charAt(i);
            }
        }
        if (null == respuesta) {
            return false;
        }
        respuesta = respuesta.toLowerCase();
        if (respuesta.equals("s") || respuesta.equals("y")) {
            return true;
        }
        if (respuesta.equals("sí") || respuesta.equals("yes")) {
            return true;
        }
        if (respuesta.equals("si") || respuesta.equals("vale") || respuesta.equals("yeah")) {
            return true;
        }
        return false;
    }
}
