/* 
 * Fichero con multiples utilidades
 */
public class UtilString {
	public static boolean esVocal (char ch) {
		char verificacio = Character.toLowerCase(ch);
		String vocals = "aeiouàèéíïòóúü";
		for (int i = 0; i < vocals.length(); i++) {
			if (verificacio == vocals.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static String nomesLletres(String text) {
		String lletres = "";
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLetter(text.charAt(i))) {
				lletres = lletres + text.charAt(i);
			}
		}
		return lletres;
	}
	
	public static String lletresSeparades(String nomesLletres) {
		String separades = "";
		for (int i = 0; i < nomesLletres.length(); i++) {
			if (i == nomesLletres.length() - 1) {
				separades = separades + nomesLletres.charAt(i);
				break;
			}
			separades = separades + nomesLletres.charAt(i) + ", ";
		}
		return separades;
	}

	public static String intervalString(String text, int ini, int fi) {
		String obtingut = "";
		if (ini < 0 && fi < 0) {
			obtingut = obtingut + text.charAt(0);
			return obtingut;
		}
		if (ini <= fi) {
			for (int i = ini; i <= fi; i++) {
				if (i >= 0 && i <= text.length() - 1) {
					obtingut = obtingut + text.charAt(i);
				}
			}
		} else {
			for (int i = ini; i >= fi; i--) {
				if (i >= 0 && i <= text.length() - 1) {
					obtingut = obtingut + text.charAt(i);
				}
			}
		}
		return obtingut;
	}
	
	public static boolean esEnter(String text) {
		if (text.isEmpty()) {
			return false;
		}
		for (int i = 0; i < text.length(); i++) {
			if (Character.isDigit(text.charAt(i)) == false) {
				if (i == 0) {
					String subcadena = Character.toString(text.charAt(i));
					if (! subcadena.equals("+") && ! subcadena.equals("-")) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static String cadenaContinua(String text, int numero) {
		String nombreText = "";
		int posicio = 0;
		for (int i = 0; i < numero; i++) {
			nombreText = nombreText + text.charAt(posicio);
			posicio++;
			if (posicio == text.length()) {
				posicio = 0;
			}
		}
		return nombreText;
	}
	
	public static boolean esSubstring(String principal, String subtext, boolean extricte) {
		boolean confirmacio = false;
		//System.out.println("XXX esSubstring(" + principal + ", " + subtext + ", " + extricte + ") entra");
		if (!extricte) {
			//subtext = subtext.strip();
			String principal2 = principal.toLowerCase();
			String subtext2 = subtext.toLowerCase();
			principal = "";
			subtext = "";
			if (principal2.isEmpty()) {
				return confirmacio;
			}
			if (subtext2.isEmpty()) {
				confirmacio = true;
				return confirmacio;
			}
			if (principal2.length() <= subtext2.length()) {
				return confirmacio;
			}
			for (int i = 0; i < principal2.length(); i++) {
				if (principal2.charAt(i) == 'a' || principal2.charAt(i) == 'à') {
					principal = principal + "a";
				} else if (principal2.charAt(i) == 'e' || principal2.charAt(i) == 'è' || principal2.charAt(i) == 'é') {
					principal = principal + "e";
				} else if (principal2.charAt(i) == 'i' || principal2.charAt(i) == 'í' || principal2.charAt(i) == 'ï') {
					principal = principal + "i";
				} else if (principal2.charAt(i) == 'o' || principal2.charAt(i) == 'ò' || principal2.charAt(i) == 'ó') {
					principal = principal + "o";
				} else if (principal2.charAt(i) == 'u' || principal2.charAt(i) == 'ú' || principal2.charAt(i) == 'ü') {
					principal = principal + "u";
				} else if (principal2.charAt(i) == 'c' || principal2.charAt(i) == 'ç') {
					principal = principal + "c";
				} else {
					principal = principal + principal2.charAt(i);
				}
			}
			for (int i = 0; i < subtext2.length(); i++) {
				if (subtext2.charAt(i) == 'a' || subtext2.charAt(i) == 'à') {
					subtext = subtext + "a";
				} else if (subtext2.charAt(i) == 'e' || subtext2.charAt(i) == 'è' || subtext2.charAt(i) == 'é') {
					subtext = subtext + "e";
				} else if (subtext2.charAt(i) == 'i' || subtext2.charAt(i) == 'í' || subtext2.charAt(i) == 'ï') {
					subtext = subtext + "i";
				} else if (subtext2.charAt(i) == 'o' || subtext2.charAt(i) == 'ò' || subtext2.charAt(i) == 'ó') {
					subtext = subtext + "o";
				} else if (subtext2.charAt(i) == 'u' || subtext2.charAt(i) == 'ú' || subtext2.charAt(i) == 'ü') {
					subtext = subtext + "u";
				} else if (subtext2.charAt(i) == 'c' || subtext2.charAt(i) == 'ç') {
					subtext = subtext + "c";
				} else {
					subtext = subtext + subtext2.charAt(i);
				}
			}
			for (int i = 0; i < (principal.length() - (subtext.length() -1)); i++) {
				String nouText = "";
				for (int p = 0; p < subtext.length(); p++) {
					nouText = nouText + principal.charAt(i + p);
				}
				if (nouText.equals(subtext)) {
					confirmacio = true;
					return confirmacio;
				}
			}
		} else {
			confirmacio = esSubstring (principal, subtext);
		}
		return confirmacio;
	}

	public static boolean esSubstring(String principal, String subtext) {
		/*System.out.println("XXX esSubstring(" + principal + ", " + subtext + ") entra");
		System.out.printf("XXX esSubstring(principal: \"%s\", subtext: \"%s\") entra%n", principal, subtext);*/
		boolean confirmacio = false;
		if (principal.isEmpty()) {
			return confirmacio;
		}
		if (subtext.isEmpty()) {
			confirmacio = true;
			return confirmacio;
		}
		if (principal.length() <= subtext.length()) {
			return confirmacio;
		}

		for (int i = 0; i < (principal.length() - (subtext.length() -1)); i++) {
			String nouText = "";
			for (int p = 0; p < subtext.length(); p++) {
				nouText = nouText + principal.charAt(i + p);
			}
			if (nouText.equals(subtext)) {
				confirmacio = true;
				return confirmacio;
			}
		}
		return confirmacio;
	}
}
