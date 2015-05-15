package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Vasi {

    private String end;
    private String type;
    private String side;
    private String biasX;
    private String biasZ;
    private String spacing;
    private float pitch;

    public Vasi(){
        this.end = null;
        this.type = null;
        this.side = null;
        this.biasX = null;
        this.biasZ = null;
        this.spacing = null;
        this.pitch = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========VASI -> attributes========");
        System.out.println("===================================");


        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.side != null){
            System.out.println("Side : " + this.side);
        }

        if(this.biasX != null){
            System.out.println("BiasX : " + this.biasX);
        }

        if(this.biasZ != null){
            System.out.println("BiasZ : " + this.biasZ);
        }

        if(this.spacing != null){
            System.out.println("Spacing : " + this.spacing);
        }

        if(this.pitch != Float.NaN){
            System.out.println("Pitch : " + this.pitch);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setEnd(String end) {
        this.end = end.replaceAll("^\"|\"$", "");
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }

    public void setSide(String side) {
        this.side = side.replaceAll("^\"|\"$", "");
    }

    public void setBiasX(String biasX) {
        this.biasX = biasX.replaceAll("^\"|\"$", "");
    }

    public void setBiasZ(String biasZ) {
        this.biasZ = biasZ.replaceAll("^\"|\"$", "");
    }

    public void setSpacing(String spacing) {
        this.spacing = spacing.replaceAll("^\"|\"$", "");
    }

    public void setPitch(String pitch) {
        pitch = pitch.replaceAll("^\"|\"$", "");
        this.pitch = Float.parseFloat(pitch);

        if(this.pitch < 0 || this.pitch > 10){
            this.pitch = Float.NaN;
            throw new IllegalArgumentException("Pitch is out of bounds (values between 0.0 and 10.0 are allowed)");
        }
    }
}
