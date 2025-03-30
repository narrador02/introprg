public class Hora {
    private int hores;
    private int minuts;
    private int segons;
    private int[] temps = new int[]{hores, minuts, segons};
    
    public Hora() {
        hores = 0;
        minuts = 00;
        segons = 00; 
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
        segons++;
        if (segons >= 60) {
            segons = 0;
            minuts++;
            if (minuts >= 60) {
                minuts = 0;
                hores = (hores + 1) % 24;
            }
        }
    }
    
    public void incrementa(int segons) {
        for (int i = 0; i < segons; i++) {
            incrementa();
        }
    }
    
    public void decrementa() {
        segons--;
        if (segons < 0) {
            segons = 59;
            minuts--;
            if (minuts < 0) {
                minuts = 59;
                hores = (hores - 1 + 24) % 24;
            }
        }
    }
    
    public void decrementa(int segons) {
        for (int i = 0; i < segons; i++) {
            decrementa();
        }
    }
    
    public int[] construeixArray() {
        return new int[]{hores, minuts, segons};
    }
    
    public int compareTo(Hora hora2) {
        int contador = 0;
        int multiplicador = 1;
        int[] Comp = construeixArray();
        int[] Comp2 = hora2.construeixArray();
        for (int i = 0; i < this.temps.length; i++) {
            if (Comp[i] > Comp2[i]) {
                contador = multiplicador + contador;
            } else if (Comp[i] < Comp2[i]) {
                contador = multiplicador - contador;
            }
            multiplicador = multiplicador * 2;
        }
        return contador;
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
            return ">";
        } else if (comparacio > 0) {
            return "<";
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
