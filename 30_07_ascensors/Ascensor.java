/* 
 * En aquesta ocasió, el programa inclou una funció anomenada creaAscensorsEnEscala(). 
 * Aquesta funció rep un nombre d’ascensors com a paràmetre i retorna un array. 
 * Cada ascensor en l’array estarà situat al pis corresponent a la seva posició dins de l’array.
 *
 */

public class Ascensor {
    int pis;
    public static Ascensor[] creaAscensorsEnEscala(int quants) {
        Ascensor[] ascensorList = new Ascensor[quants]; 
        for (int i = 0; i < quants; i++) {
            ascensorList[i] = new Ascensor(); 
            ascensorList[i].pis = i;
        }
        return ascensorList;
    }

    public static void main(String[] args){
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                if (Character.isLetter(args[i].charAt(j))) {
                    System.out.println ("Cap ascensor");
                    return;
                }
            }
            if (i > 0) {
                return;
            }
            if (Integer.parseInt(args[0]) == 0) {
                System.out.println ("Cal indicar un únic valor enter.");
                return;
            }
        }
        int quants = Integer.parseInt(args[0]);
        Ascensor[] ascensors = creaAscensorsEnEscala(quants);
        for (int i = 0; i < ascensors.length; i++) {
            System.out.printf("Ascensor %d al pis %d%n", i, ascensors[i].pis);
        }
    }
}
