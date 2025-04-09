/*
 * Programa hace uso de la clase Ascensor
 * para mostrar sus valores
 */
public class UsaAscensor {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        
        System.out.println("Pis inicial: " + ascensor.getPis());
        System.out.println("Moviment inicial: " + ascensor.getMoviment());

        int pisFinal = -10;
        String moviment = "";
        for (String arg: args) {
            if (UtilString.esEnter(arg)) {
                pisFinal = Integer.parseInt(arg);
            }
            if (!UtilString.esEnter(arg)) {
                if (arg.equals("pujant") || arg.equals("baixant") || arg.equals("aturat")) {
                    moviment = arg;
                }
            }
        }
        ascensor.setPis(pisFinal);
        ascensor.setMoviment(moviment);
        System.out.println("Pis final: " + ascensor.getPis());
        System.out.println("Moviment final: " + ascensor.getMoviment());
    }
}
