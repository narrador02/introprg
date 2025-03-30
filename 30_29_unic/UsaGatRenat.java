/*
 * Mata al gato Renat 3 veces
 * - la primera con todas las vidas
 * - la segunda con una sola vida
 * - la tercera con dos vidas
 * Después de matarlo "del todo" prueba otra vez
 */

public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = GatRenat.getInstancia();
        System.out.println("Inicialment Renat està " + renat.getPosicio());
        for (String posicio: args) {
            canviaPosicio(posicio);
            System.out.println("Ara està " + renat.getPosicio());
        }
    }
    private static void canviaPosicio(String novaPosicio) {
        GatRenat renat = GatRenat.getInstancia(novaPosicio);
        if (novaPosicio.equals("1")) {
            renat.setPosicio("estirat");
        }
        if (novaPosicio.equals("2")) {
            renat.setPosicio("assegut");
        }
        if (novaPosicio.equals("3")) {
            renat.setPosicio("dret");
        }
        if (novaPosicio.equals("estirat") || novaPosicio.equals("assegut") || novaPosicio.equals("dret")) {
            renat.setPosicio(novaPosicio);
        }
    }
}
