/*
 * Programa que envuelve los Strings con un objecte para que su comportamiento
 * en el hashmap sea diferente
 */
public class EnvoltaString {
    private String valor;

    public EnvoltaString(String valor) { this.valor = valor; }

    public String toString() { return String.format("ENVOLTAT(\"%s\")", valor); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof EnvoltaString) {
            EnvoltaString other = (EnvoltaString) obj;
            return valor.equalsIgnoreCase(other.valor);
        } else if (obj instanceof String) {
            String other = (String) obj;
            return valor.equalsIgnoreCase(other);
        }
        return false;
    }

    public static void main(String[] args) {
        String nom1 = "Renat";
        String nom2 = new String("Renat");
        System.out.printf("\"%s\" == \"%s\" -> %b%n", nom1, nom2, nom1 == nom2);
        System.out.printf("\"%s\".equals(\"%s\") -> %b%n", nom1, nom2, nom1.equals(nom2));

        EnvoltaString envoltaNom1 = new EnvoltaString(nom1);
        EnvoltaString envoltaNom2 = new EnvoltaString(nom2);
        System.out.printf("%s == %s -> %b%n", envoltaNom1, envoltaNom2, envoltaNom1 == envoltaNom2);
        System.out.printf("%s.equals(%s) -> %b%n", envoltaNom1, envoltaNom2, envoltaNom1.equals(envoltaNom2));
    }
}
