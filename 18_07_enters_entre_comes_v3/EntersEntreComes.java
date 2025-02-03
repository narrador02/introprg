/*
 * Programa que muestra 5 números introducidos por el usuario, separados por comas mediante un array
 * Pero al recibir un número negativo retornará el mensaje "res a fer"
 */
public class EntersEntreComes {
    public static void main(String[] args) {
        System.out.println("Quants?");
        int quants = Integer.parseInt(Entrada.readLine());
        if (quants < 1) {
            System.out.println("Res a fer");
            return;
        }
        int[] numeros;
        numeros = new int[quants];
        for (int p = 0; p < quants; p++) {
            System.out.println("Valor " + (p + 1) + "?");
            numeros[p] = Integer.parseInt(Entrada.readLine());
        }
        System.out.print(numeros[0]);
        for (int i = 1; i < numeros.length; i++) {
            System.out.print(", " + numeros[i]);
        }
        System.out.println();
    }
}
