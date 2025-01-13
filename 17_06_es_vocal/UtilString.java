/* Programa para checkear si una string es vocal */
public class UtilString {
    public static boolean esVocal(char lletra) {
    	String vocals = "aàáeèéiíïoòóuúü";
    	vocals = vocals + vocals.toUpperCase();
    	for (int i=0; i<vocals.length(); i++) {
    	    if (lletra == vocals.charAt(i)) {
    	    	return true;
    	    }
    	}
    	return false;
    }
}
