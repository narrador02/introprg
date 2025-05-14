/*
 * Fichero donde introduzcoa las utilitades para hacer uso de los Strings y tenerlos centralitzados.
 */
public class UtilString {
    public static String normalitzaString(String text) {
        if (text == null) return "";
        return text.trim().toLowerCase();
    }

    public static boolean esPlantillaDeText(String plantilla, String text) {
        if (plantilla == null || plantilla.trim().isEmpty()) return true;
        if (text == null) return false;
        String p = normalitzaString(plantilla);
        String t = normalitzaString(text);
        return t.startsWith(p);
    }
}
