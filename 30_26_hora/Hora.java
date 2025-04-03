/*
 * Este programa contiene la clase Hora
 * que declara horas minutos y segundos
 * y ofrece funcionalidades de incrementar
 * y decrementar la hora
 */
public class Hora {
    private int hores;
    private int minuts;
    private int segons;

    public Hora() {
        this.hores = 0;
        this.minuts = 0;
        this.segons = 0;
    }

    public Hora(int hores, int minuts, int segons) {
        if (hores >= 0 && hores < 24 && minuts >= 0 && minuts < 60 && segons >= 0 && segons < 60) {
            this.hores = hores;
            this.minuts = minuts;
            this.segons = segons;
        } else {
            this.hores = 0;
            this.minuts = 0;
            this.segons = 0;
        }
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public int getMinuts() {
        return minuts;
    }

    public void setMinuts(int minuts) {
        this.minuts = minuts;
    }

    public int getSegons() {
        return segons;
    }

    public void setSegons(int segons) {
        this.segons = segons;
    }

    public void incrementa() {
        incrementa(1);
    }

    public void incrementa(int segons) {
        int totalSegons = this.hores * 3600 + this.minuts * 60 + this.segons + segons;
        totalSegons = ((totalSegons % 86400) + 86400) % 86400;
        this.hores = totalSegons / 3600;
        this.minuts = (totalSegons % 3600) / 60;
        this.segons = totalSegons % 60;
    }

    public void decrementa() {
        decrementa(1);
    }

    public void decrementa(int segons) {
        incrementa(-segons);
    }

    public int compareTo(Hora altra) {
        if (this.hores != altra.hores) {
            return this.hores - altra.hores;
        } else if (this.minuts != altra.minuts) {
            return this.minuts - altra.minuts;
        } else {
            return this.segons - altra.segons;
        }
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }

    /**
 * Compara dues hores i retorna l'operador corresponent
 * Per exemple, si hora1 és menor que hora2, l'operador serà "<". Els
 * altres dos valors possibles són ">" i "=="
 * @param hora1: primera hora a comparar
 * @param hora2: segona hora a comparar
 * @return operador resultant
 */
 
    private static String composaOperadorComparacio(Hora hora1, Hora hora2) {
        int comparacio = hora1.compareTo(hora2);
        if (comparacio < 0) {
            return "<";
        } else if (comparacio > 0) {
            return ">";
        } else {
            return "==";
        }
    }

    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora(0, 0, 2);
        System.out.printf("Inicialment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
        System.out.println("Incrementem 1 segon a la primera i decrementem 1 segon a la segona");
        hora1.incrementa();
        hora2.decrementa();
        System.out.printf("Finalment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
    }
}
