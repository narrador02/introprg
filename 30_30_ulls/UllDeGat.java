/*
 * En este programa trabajo en la complementación del picarol
 * a GatRenat, el cual sonará y contará las veces que suena.
 */

public class UllDeGat {
    
    private boolean obert;

    public UllDeGat() {
        this.obert = false;
    }

    public UllDeGat(boolean obert) {
        this.obert = obert;
    }
    
    public void obret() {
        obert = true;
    }
    
    public void tancat() {
        obert = false;
    }
    
    public boolean esObert() {
        return obert;
    }
}
