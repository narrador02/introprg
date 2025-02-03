/*
 * Este programa analiza los argumentos que se pasen por la línea de comandas y distingue si son o no enteros
 */
public class Arguments {
    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println ("Cap argument");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            boolean esEnter = UtilString.esEnter(args[i]);
            if (esEnter) {
                System.out.println ("[" + i + "] " + "\"" + args[i] + "\": " + "és enter");
            } else {
                System.out.println ("[" + i + "] " + "\"" + args[i] + "\": " + "no és enter");
            }
        }
    }
}
