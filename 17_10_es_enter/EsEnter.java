/*
 * Programa de misma funcionalidad que el 31_76 pero con estructura modular y haciendo uso del fichero UtilString.java 
 */
public class EsEnter {
    public static void main(String[] args) {
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        String text = (Entrada.readLine()).strip();
        while (!text.isEmpty()) {
            if (UtilString.esEnter(text)) {
                System.out.println("És enter");
            } else {
                System.out.println("No és enter");
            }
            text = (Entrada.readLine()).strip();
        }
        System.out.println("Adéu");
    }
}
