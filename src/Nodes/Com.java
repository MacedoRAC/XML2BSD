package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Com {

    private float freq;
    private String type;
    private String name;

    public Com(){
        this.freq = Float.NaN;
        this.type = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========COM -> attributes=========");
        System.out.println("===================================");

        if(this.freq != Float.NaN){
            System.out.println("Frequency : " + this.freq);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

    }

    public void setFreq(String freq) {
        freq = freq.replaceAll("^\"|\"$", "");
        this.freq = Float.parseFloat(freq);

        if(this.freq < -180.0 || this.freq > 136.992){
            this.freq = Float.NaN;
            throw new IllegalArgumentException("Frequency is out of bounds (values between -180.0 and 136.992 are allowed)");
        }
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }

    public void setName(String name) {
        this.name = name.replaceAll("^\"|\"$", "");

        if(this.name.length() > 48){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (48 chars at maximum are allowed)");
        }
    }
}
