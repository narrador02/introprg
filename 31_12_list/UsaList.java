/*
 * Programa que fa servir els l'Arraylist de maneres diferents
 * Per comprobar el seu funcionament afegint, eliminant, etc.
 */

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class UsaList {
    public static void main(String[] args) {
        List<String> llista;

        // TODO: inicialitza la llista amb una instància de  ArrayList
        llista = new ArrayList<String>();


        System.out.println("Obtenim les entrades");
        System.out.println("====================");
        String valor;

        valor = Entrada.readLine();

        // TODO: afegeix valor a la llista
        llista.add(valor);

        valor = Entrada.readLine();

        // TODO: afegeix el valor a l'inici de la llista
        llista.add(0, valor);

        valor = Entrada.readLine();

        // TODO: afegeix el valor al mig de la llista
        llista.add(llista.size() / 2, valor);


        System.out.println("Cerquem elements de la llista");
        System.out.println("=============================");
        String text = Entrada.readLine();

        boolean esTroba = false;
        // TODO: inicialitza esTroba a true si text està a la llista
        if (llista.contains(text)) esTroba = true;

        System.out.printf("El text %s és troba a la llista: %s%n", text, esTroba);

        int indexPrimerOcurrencia = -1;
        // TODO: inicialitza indexPrimerOcurrencia a l'índex on es troba text
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).equals(text)) {
                indexPrimerOcurrencia = i;
                break;
            }
        }

        System.out.printf("Posició de %s a la llista: %s%n", text, indexPrimerOcurrencia);


        System.out.println("Mostrem les entrades introduïdes");
        System.out.println("================================");
        boolean llistaBuida = false;
        // TODO inicialitza llistaBuida de manera que valgui cert si llista esta buida
        if (llista.isEmpty()) llistaBuida = true;

        while (! llistaBuida) {
            String entrada;
            // TODO: inicialitza entrada de manera que contingui el
            // primer element de la llista
            entrada = llista.get(0);

            System.out.println(entrada);
            // TODO: elimina el primer element de la llista
            llista.remove(0);

            // TODO: actualitza el valor de llistaBuida
            if (llista.isEmpty()) llistaBuida = true;

        }
    }
}
