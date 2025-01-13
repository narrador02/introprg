/* Fichero multiusos para distintos programas */
public class UtilString {
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
}
