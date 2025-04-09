/*
 * Programa que hace uso de GatRenat
 * para acceder a varios valores
 */
public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        System.out.println("Les vides inicials són: " + renat.getVides());
        System.out.println("La posició inicial és: " + renat.getPosicio());
        System.out.println("Introdueix nova posició:");
        renat.setPosicio(Entrada.readLine());
        System.out.println("Posició final: " + renat.getPosicio());
    }
}
