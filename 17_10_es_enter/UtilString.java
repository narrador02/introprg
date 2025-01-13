/* 
 * Fichero multiusos para distintos programas
 */
public class UtilString {
    // Coge un String y te dice si está compuesto por números enteros únicamente o no
    public static boolean esEnter(String text) {
        if (text.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i<text.length(); i++) {
                if (!(Character.isDigit(text.charAt(i)) || text.charAt(i) == '+' || text.charAt(i) == '-')) {
                    return false;
                }
            }
        }
        return true;
    }
    // Coge un texto y devuelve sus letras
    public static String nomesLletres(String text) {
        String lletres = "";
        for (int i=0; i<text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                lletres = lletres + text.charAt(i);
            }
        }
    	return lletres;
    }
    // Coge un string y devuelve todos sus carácteres entre comas
    public static String lletresSeparades(String lletres) {
        String separades = "";
        for (int i=0; i<lletres.length(); i++) {
            if (i == 0) {
                separades = separades + lletres.charAt(i);
            } else {
                separades = separades + ", " + lletres.charAt(i);
            }
        }
        return separades;
    }
    public static String intervalString(String txt, int ini, int fi) {
        String result = "";
        if (ini >= fi) {
            if (ini < 0 && fi < 0) {
                result = result + txt.charAt(0);
            }
            if (ini >= txt.length()) {
                ini = txt.length() - 1;
            }
            if (fi < 0) {
                fi = 0;
            }
            for (int i = ini; i >= fi; i--) {
                result = result + txt.charAt(i);
            }
        } else if (ini < 0 && fi < 0) {
            result = result + txt.charAt(0);
        } else {
            if (fi >= txt.length()) {
                fi = txt.length() -1;
                if (ini < 0) {
                    ini = 0;
                }
                for (int i = ini; i <= fi; i++) {              
                    result = result + txt.charAt(i); 
                }
	    } else if (fi < 0) {
     	        fi = 0;
          	    for (int i = ini; i >= fi; i--) {              
  	            result = result + txt.charAt(i);
 	        }
	    } else {
	        if (ini < 0) {
 	            ini = 0;
 	            if (fi >= txt.length()) {
                        fi = txt.length() -1;
                    }
 	            for (int i = ini; i <= fi; i++) {              
                        result = result + txt.charAt(i); 
  	            } 	        
                } else if (ini >= txt.length()) {
                    ini = txt.length() - 1;
                    for (int i = ini; i >= fi; i--) {
                        result = result + txt.charAt(i);
                    }
                } else {
                    for (int i = ini; i <= fi; i++) {              
                        result = result + txt.charAt(i); 
  	            }
                }
            } 
        }
        return result;
    }
}
