package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiName {

    private Integer index;
    private String name;

    public TaxiName(){
        this.index = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("======TAXINAME -> attributes=======");
        System.out.println("===================================");


        if(this.index != Float.NaN){
            System.out.println("Index : " + this.index);
        }

        System.out.println("Name : " + this.name);


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setIndex(String index) {
        index = index.replaceAll("^\"|\"$", "");
        this.index = Integer.parseInt(index);

        if(this.index < 0 || this.index > 255){
            this.index = null;
            throw new IllegalArgumentException("Index is out of bounds (values between 0 and 255 are allowed)");
        }
    }

    public void setName(String name) {
        this.name = name.replaceAll("^\"|\"$", "");

        if(this.name.length() > 8){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (8 chars at maximum)");
        }
    }
}
