/* 
 * Este programa demuestra el funcionamento de la clase GatRenat con la funcionalitat Picarol.
 * El programa crea un gato y un picarol, hace sonar el picarol sin el gato 
 * después le hace moverse para que suene
 */
public class Soroll {
    public static void main(String[] args) {
        Picarol picarol = new Picarol();
        picarol.sona();
        GatRenat renat = new GatRenat();
        System.out.println(renat.aixecat());
        renat.agafaPicarol(picarol);
        System.out.println(renat.seu());      
        System.out.println(renat.seu()); 
        renat.deixaPicarol();
        System.out.println(renat.estirat());
        System.out.println("Nombre de cops que sona el picarol: " + picarol.vegades());
    }
}
