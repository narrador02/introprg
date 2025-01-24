/* 
 * Programa que repite cualquier texto que comience o acabe en vocal 
 */
public class LloroVocalIniciFi {
    public static void main (String[] args) {
		boolean finalizar = false;
		while (!finalizar) {
			System.out.println("El lloro demana paraula amb vocal a l'inici o/i final");
			String entrada = Entrada.readLine();
			if (entrada.isEmpty()) {
				System.out.println("El lloro demana confirmació per finalitzar");
				entrada = Entrada.readLine();
				finalizar = UtilitatsConfirmacio.respostaABoolean(entrada);
			}
			boolean esVocalIni = UtilString.esVocal(entrada.charAt(0));
			boolean esVocalFi = UtilString.esVocal(entrada.charAt(entrada.length()-1));
			if (esVocalIni || esVocalFi) {
				System.out.println("El lloro diu: " + entrada);
			}
		}
		System.out.println("Adéu");
	}
}
