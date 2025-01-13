/* Programa que cuenta cuantas vocales hay y las muestra */
public class ComptaVocals {
    public static void main(String[] args) {
        System.out.println("Introdueix un text");
        String entrada = Entrada.readLine();
        String vocales = "aáeèéiíïoóòuúü";
        for (int i=0; i<vocales.length(); i++) {
            mostraOcurrencies(vocales.charAt(i), quantesOcurrencies(entrada, vocales.charAt(i)));;
        }
    }
    public static void mostraOcurrencies(char lletra, int quantes) {
        System.out.println("Nombre de '" + lletra + "'s: " + quantes);
    }
    public static int quantesOcurrencies(String text, char lletra) {
        int comptador = 0;
        for (int i=0; i < text.length(); i++) {
            if (text.charAt(i) == lletra) {
                comptador += 1;
            }
        }
        return comptador;
    }
}
