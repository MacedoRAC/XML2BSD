package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class BiasXYZ {

    private float biasX;
    private float biasY;
    private float biasZ;

    public BiasXYZ(){
        this.biasX = Float.NaN;
        this.biasY = Float.NaN;
        this.biasZ = Float.NaN;
    }

    public void output() {
        System.out.println("===================================");
        System.out.println("=======BIASXYZ -> attributes=======");
        System.out.println("===================================");


        if(this.biasX != Float.NaN){
            System.out.println("BiasX : " + this.biasX);
        }

        if(this.biasY != Float.NaN){
            System.out.println("BiasY : " + this.biasY);
        }

        if(this.biasZ != Float.NaN){
            System.out.println("BiasZ : " + this.biasZ);
        }


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setBiasX(String biasX) {
        biasX = biasX.replaceAll("^\"|\"$", "");
        this.biasX = Float.parseFloat(biasX);
    }

    public void setBiasY(String biasY) {
        biasY = biasY.replaceAll("^\"|\"$", "");
        this.biasY = Float.parseFloat(biasY);
    }

    public void setBiasZ(String biasZ) {
        biasZ = biasZ.replaceAll("^\"|\"$", "");
        this.biasZ = Float.parseFloat(biasZ);
    }
}
