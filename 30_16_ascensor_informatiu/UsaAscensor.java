/*
 * Programa que hace uso de la clase Ascensor
 * para mostrar sus valores
 */
public class UsaAscensor {
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

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        System.out.println("Pis inicial: " + ascensor.getPis());
        System.out.println("Moviment inicial: " + ascensor.getMoviment());
        System.out.println("Introdueix nou pis:");
        String pis = Entrada.readLine();
        if (esEnter(pis)) {
            ascensor.setPis(Integer.parseInt(pis));
        }

        System.out.println("Introdueix nou moviment:");
        ascensor.setMoviment(Entrada.readLine());

        System.out.println("Pis final: " + ascensor.getPis());
        System.out.println("Moviment final: " + ascensor.getMoviment());
        System.out.println("Estat de l'ascensor: " + ascensor.comEsta());
    }
}
