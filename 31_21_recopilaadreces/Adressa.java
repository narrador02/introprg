/*
 * Clase que representa una dirección de correo válida.
 * Permite validarla, crearla desde texto y ordenarla.
 * Guarda identificador y dominio por separado.
*/
public class Adressa implements Comparable<Adressa> {
    private String identificador;
    private String domini;

    private Adressa(String identificador, String domini) {
        this.identificador = identificador;
        this.domini = domini;
    }

    public static boolean esValida(String text) {
        if (text == null) return false;
        if (!text.matches("[A-Za-z0-9._@+\\-]+")) return false;
        int posArrova = text.indexOf('@');
        if (posArrova < 1 || posArrova != text.lastIndexOf('@')) return false;

        String id = text.substring(0, posArrova);
        String dom = text.substring(posArrova + 1);

        if (!dom.contains(".")) return false;
        String[] parts = dom.split("\\.");
        if (parts.length < 2) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.contains("..")) return false;
        }

        String extensio = parts[parts.length - 1];
        return extensio.matches("[A-Za-z]{2,}");
    }

    public static Adressa fromString(String text) {
        if (!esValida(text)) throw new IllegalArgumentException("boh");
        int pos = text.indexOf('@');
        return new Adressa(text.substring(0, pos), text.substring(pos + 1));
    }

    @Override
    public String toString() {
        return identificador + "@" + domini;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adressa)) return false;
        return toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int compareTo(Adressa altra) {
        return this.toString().compareTo(altra.toString());
    }
}

