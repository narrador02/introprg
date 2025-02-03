/*
 * Programa que muestra 5 números introducidos por el usuario, separados por comas mediante un array
 * Pero al recibir un número negativo retornará un mensaje de "res a fer". Ahora a parte pide el
 * carácter de separación y si no se introduce un entero lo vuelve a pedir hasta que lo pongas
 */
public class EntersEntreComes {
    public static void main(String[] args) {
        System.out.println("Quants?");
        int quants = UtilString.demanarEnter();
        if (quants < 1) {
            System.out.println("Res a fer");
            return;
        }

        System.out.println("Separador?");
        char ch = UtilString.demanarCaracter();

        int[] numeros;
        numeros = new int[quants];
        for (int p = 0; p < quants; p++) {
            System.out.println("Valor " + (p + 1) + "?");
            numeros[p] = UtilString.demanarEnter();
        }
        //System.out.print(numeros[0]);
        String resposta = UtilString.entreComes(numeros, ch);
        System.out.println(resposta);
    }
}
