/*
 * Fichero con distintas funciones de multiples utilidades
 */

public class UtilString {
    public static boolean esCreixent(String text, boolean estricta) {
        for (int i = 1; i < text.length(); i++) {
            if (estricta) {
                if (text.charAt(i - 1) >= text.charAt(i)) {
                    return false;
                }
            } else {
                if (text.charAt(i - 1) > text.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean esDecreixent(String text, boolean estricta) {
        for (int i = 1; i < text.length(); i++) {
            if (estricta) {
                if (text.charAt(i - 1) <= text.charAt(i)) {
                    return false;
                }
            } else {
                if (text.charAt(i - 1) < text.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean esCreixiDecri(String text, boolean estricta) {
        int i = 1;
        while (i < text.length()) {
            if (estricta) {
                if (text.charAt(i - 1) >= text.charAt(i)) {
                    break;
                }
            } else {
                if (text.charAt(i - 1) > text.charAt(i)) {
                    break;
                }
            }
            i++;
        }
        while (i < text.length()) {
            if (estricta) {
                if (text.charAt(i - 1) <= text.charAt(i)) {
                    return false;
                }
            } else {
                if (text.charAt(i - 1) < text.charAt(i)) {
                    return false;
                }
            }
            i++;
        }
        return i == text.length();
    }

    public static boolean esDecriCreixi(String text, boolean estricta) {
        int i = 1;
        while (i < text.length()) {
            if (estricta) {
                if (text.charAt(i - 1) <= text.charAt(i)) {
                    break;
                }
            } else {
                if (text.charAt(i - 1) < text.charAt(i)) {
                    break;
                }
            }
            i++;
        }
        while (i < text.length()) {
            if (estricta) {
                if (text.charAt(i - 1) >= text.charAt(i)) {
                    return false;
                }
            } else {
                if (text.charAt(i - 1) > text.charAt(i)) {
                    return false;
                }
            }
            i++;
        }
        return i == text.length();
    }

    public static boolean esCreixent(String text) {
        return esCreixent(text, true);
    }

    public static boolean esDecreixent(String text) {
        return esDecreixent(text, true);
    }

    public static boolean esCreixiDecri(String text) {
        return esCreixiDecri(text, true);
    }

    public static boolean esDecriCreixi(String text) {
        return esDecriCreixi(text, true);
    }
}
