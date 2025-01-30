/*
 * Este programa pide que se introduzcan notas y al poner un número negativo muestra la nota más alta introducida
 */

public class NotaMesAlta {
    public static void main (String[] args) {
        int resultat = 0;
        int contador = 0;
        System.out.println ("Introdueix les notes (-1 per finalitzar)");
        while (true) {
            int nota = Integer.parseInt(Entrada.readLine());
            if (nota < 1) {
                if (contador < 2) {
                    System.out.println ("Com a mínim calen dues notes");
                    return;
                }
                break;
            } else if (nota > resultat) {
                resultat = nota;
            }
            contador++;
        }
        System.out.println ("La nota més alta és " + resultat);
    }
}
