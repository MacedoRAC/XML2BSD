package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class VisualModel {

    private float heading;
    private String imageComplexity;
    private String name;
    private String instanceID;

    public VisualModel(){
        this.heading = Float.NaN;
        this.imageComplexity = null;
        this.name = null;
        this.instanceID = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=====VISUAL MODEL -> attributes====");
        System.out.println("===================================");


        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.imageComplexity != null){
            System.out.println("ImageComplexity : " + this.imageComplexity);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.instanceID != null){
            System.out.println("InstanceID : " + this.instanceID);
        }


        System.lineSeparator();
        System.lineSeparator();

    }

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0.0 and 360 are allowed)");
        }
    }

    public void setImageComplexity(String imageComplexity) {
        this.imageComplexity = imageComplexity.replaceAll("^\"|\"$", "");
    }

    public void setName(String name) {
        name = name.replaceAll("^\"|\"$", "");
        String[] parts = name.split("-");

        if(parts[0].length() != 8 || parts[1].length() != 4 || parts[2].length() != 4 || parts[3].length() != 4 || parts[4].length() != 12){
            this.name = null;
            throw new IllegalArgumentException("Invalid name syntax (nnnnnnnn-nnnn-nnnn-nnnn-nnnnnnnnnnnn)");
        }
    }

    public void setInstanceID(String instanceID) {
        instanceID = instanceID.replaceAll("^\"|\"$", "");
        String[] parts = instanceID.split("-");

        if(parts[0].length() != 8 || parts[1].length() != 4 || parts[2].length() != 4 || parts[3].length() != 4 || parts[4].length() != 12){
            this.instanceID = null;
            throw new IllegalArgumentException("Invalid instanceID syntax (nnnnnnnn-nnnn-nnnn-nnnn-nnnnnnnnnnnn)");
        }
    }
}
