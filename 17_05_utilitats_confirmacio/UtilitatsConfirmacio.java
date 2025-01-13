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
        if (null == resposta) {
            return false;
        }
        resposta = resposta.toLowerCase();
        if (resposta.equals("s") || resposta.equals("y")) {
            return true;
        }
        if (resposta.equals("sí") || resposta.equals("yes")) {
            return true;
        }
        if (resposta.equals("si") || resposta.equals("vale") || resposta.equals("yeah")) {
            return true;
        }
        return false;
    }
}
