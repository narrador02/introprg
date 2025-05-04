/*
 * Programa que permite crear una hora, con sus horas, minutos y segundos
 * te devuelve el conjunto del tiempo. Te permite modificar la hora
 * modificando los parametros y es dinámico
 */
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

    public Hora(int hores, int minuts, int segons) throws Exception {
        setHores(hores);
        setMinuts(minuts);
        setSegons(segons);
    }

    public int getHores() {return hores;}

    public void setHores(int hores) throws Exception {
        if (hores >= 0 && hores <= 23) {
            this.hores = hores;
            return;
        } else {
            throw new Exception("hores fora de rang: " + hores);
        }
    }

    public int getMinuts() {return minuts;}

    public void setMinuts(int minuts) throws Exception {
        if (minuts >= 0 && minuts <= 59) {
            this.minuts = minuts;
        } else {
            throw new Exception("minuts fora de rang: " + minuts);
        }
    }

    public int getSegons() {return segons;}

    public void setSegons(int segons) throws Exception {
        if (segons >= 0 && segons <= 59) {
            this.segons = segons;
        } else {
            throw new Exception("segons fora de rang: " + segons);
        }
    }

    public void incrementa() {segons++;}

    public void incrementa(int num) {
        segons = num;
    }

    public void decrementa() {segons--;}

    public void decrementa(int num) {
        segons = num;
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

    public static int compareTo(Hora hora1, Hora hora2) {
        int contador = 0;
        int multiplicador = 1;
        int[] Comp = hora1.construeixArray();
        int[] Comp2 = hora2.construeixArray();
        for (int i = 0; i < hora1.temps.length; i++) {
            if (Comp[i] > Comp2[i]) {
                contador = multiplicador + contador;
            } else if (Comp[i] < Comp2[i]) {
                contador = multiplicador - contador;
            }
            multiplicador = multiplicador * 2;
        }
        if (contador > 0) {
            return 1;
        } else if (contador < 0){
            return -1;
        } else {return 0;}
    }

    public static boolean esValida(int hores, int minuts, int segons) {
        if (hores >= 24) {
            return false;
        } else if (minuts >= 60) {
            return false;
        } else if (segons >= 60) {
            return false;
        }
        return true;
    }

    public Hora duplica() throws Exception {
        return new Hora(this.hores, this.minuts, this.segons);
    }

    public static Hora duplica(Hora hora) throws Exception {
        return new Hora(hora.hores, hora.minuts, hora.segons);
    }

    public String toString() {
        String minutsFormat = (minuts < 10) ? "0" + minuts : "" + minuts;
        String segonsFormat = (segons < 10) ? "0" + segons : "" + segons;
        return hores + ":" + minutsFormat + ":" + segonsFormat;
    }    

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

    public static void main(String[] args) throws Exception {
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
