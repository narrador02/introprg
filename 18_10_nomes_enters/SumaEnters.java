/*
 * Este programa analiza los argumentos que se pasen por la línea de comandas y distingue si son o no enteros
 */
public class SumaEnters {
    public static void main (String[] args) {
        int[] valors = filtraEnters(args);
        int resultat = sumaEnters(valors);
        System.out.println(resultat);
    }
    
    public static int quantsEnters(String[] valors) {
        int quants = 0;
        for (int i = 0; i < valors.length; i++) {
            boolean esEnter = UtilString.esEnter(valors[i]);
            if (esEnter) {
                quants++;
            }
        }
        return quants;
    }
    
    public static int[] filtraEnters(String[] valors) {
        int [] numeros = new int[quantsEnters(valors)];
        int j = 0;
        for (int i = 0; i < valors.length; i++) {
            if (UtilString.esEnter(valors[i])) {
                numeros[j] = Integer.parseInt(valors[i]);
                j++;
            }
        }
        return numeros;
    }
    
    public static int sumaEnters(int[] valors) {
        int resultat = 0;
        for (int i = 0; i < valors.length; i++) {
            resultat = resultat + valors[i];
        }
        return resultat;
    }
}
