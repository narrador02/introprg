/*
 * En aquest programa trabajo en la complementación del picarol
 * a GatRenat, el cual sonará y contará las veces que suena.
 */

public class Picarol {
    
    private int cops;
    
    public void sona() {
        cops++;
        System.out.println("clink-clink");
    }
    
    public int vegades() {
        return cops;
    }
}
