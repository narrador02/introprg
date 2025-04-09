/*
 * Programa el cual contiene los valores piso, contador y movimiento
 * que se usarán en otro programa
 */
 public class Ascensor {
     private int pis = -1;
     private int compPis = -1;
     private String moviment = "aturat";

     public boolean esAbaix() {
         return pis == -1;
     }
    
    public boolean esAdalt() {
          return pis == 10;
     }
    
    public boolean esAturat() {
         return pis == compPis && moviment.equals("aturat");
     }
    
    public boolean esEnMoviment() {
         return pis != compPis || moviment.equals("pujant") || moviment.equals("baixant");
     }
    
    public boolean esPujant() {
         return pis > compPis || moviment.equals("pujant");
     }
    
    public boolean esBaixant() {
         return pis < compPis || moviment.equals("baixant");
     }
    
    public String comEsta() {
         return (moviment + " al pis " + pis);
     }
     
     public int getPis() {
         return pis;
     }

    public String getMoviment() {
         return moviment;
     }

    public void setPis(int num) {
         if (num >= -1 && num <= 10) {
             compPis = pis;
             pis = num;
         }
     }

    public void setMoviment(String mov) {
         if (mov.equals("pujant") || mov.equals("baixant") || mov.equals("aturat")) {
             moviment = mov;
         }
     }
 }
