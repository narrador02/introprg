/*
 * Nueva versión del programa 31_75 con estructura modular. Hace uso del fichero UtilString.java en dos ocasiones 
 */
public class CadenaContinua {
    public static void main(String[] args) {
        System.out.println("Text?");
        String text = Entrada.readLine();
        if (text.isEmpty()) {
            System.out.println("error");
        } else {
            System.out.println("Nombre?");
            String nombre = Entrada.readLine();
            if (UtilString.esEnter(nombre)) {
                System.out.println(UtilString.cadenaContinua(text, Integer.parseInt(nombre)));
            } else {
                System.out.println("error");
            }
        }
    }
}
