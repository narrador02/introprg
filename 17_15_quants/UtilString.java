/* 
 * Fichero con distintas funcionalidades 
 */
public class UtilString {
	public static int quants(String principal, String subtext, boolean extricte) {
		int confirmacio = 0;
		boolean esBuit = esBuit (principal, subtext);
		if (esBuit == false) {
			return confirmacio;
		}
		if (!extricte) {
			principal = principal.toLowerCase();
			subtext = subtext.toLowerCase();
			principal = noExtricteVocals(principal);
			subtext = noExtricteVocals(subtext);
			confirmacio = quants (principal, subtext);
		} else {
			confirmacio = quants (principal, subtext);
		}
		return confirmacio;
	}

	public static int quants(String principal, String subtext) {
		boolean confirmacio = false;
		int contador = 0;
		for (int i = 0; i < (principal.length() - (subtext.length() -1)); i++) {
			String nouText = "";
			for (int p = 0; p < subtext.length(); p++) {
				nouText = nouText + principal.charAt(i + p);
			}
			if (nouText.equals(subtext)) {
				contador++;
			}
		}
		return contador;
	}

	public static boolean esBuit (String principal, String subtext) {
		boolean confirmacio = true;
		if (principal.isEmpty()) {
			confirmacio = false;
			return confirmacio;
		}
		if (subtext.isEmpty()) {
			confirmacio = false;
			return confirmacio;
		}
		return confirmacio;
	}
	
	public static String noExtricteVocals (String text) {
		text = text.toLowerCase();
		String resposta = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'a' || text.charAt(i) == 'à') {
				resposta = resposta + "a";
			} else if (text.charAt(i) == 'e' || text.charAt(i) == 'è' || text.charAt(i) == 'é') {
				resposta = resposta + "e";
			} else if (text.charAt(i) == 'i' || text.charAt(i) == 'í' || text.charAt(i) == 'ï') {
				resposta = resposta + "i";
			} else if (text.charAt(i) == 'o' || text.charAt(i) == 'ò' || text.charAt(i) == 'ó') {
				resposta = resposta + "o";
			} else if (text.charAt(i) == 'u' || text.charAt(i) == 'ú' || text.charAt(i) == 'ü') {
				resposta = resposta + "u";
			} else if (text.charAt(i) == 'c' || text.charAt(i) == 'ç') {
				resposta = resposta + "c";
			} else {
				resposta = resposta + text.charAt(i);
			}
		}
		return resposta;
	}
}
