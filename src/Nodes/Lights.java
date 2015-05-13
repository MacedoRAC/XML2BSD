package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Lights {

    private String center;
    private String edge;
    private Boolean centerRed;


    public Lights(){
        this.center = null;
        this.edge = null;
        this.centerRed = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("========LIGHTS -> attributes=======");
        System.out.println("===================================");


        if(this.center != null){
            System.out.println("Center : " + this.center);
        }

        if(this.edge != null){
            System.out.println("Lat : " + this.edge);
        }

        if(this.centerRed != null){
            System.out.println("CenterRed : " + this.centerRed);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setCenter(String center) {
        this.center = center.replaceAll("^\"|\"$", "");
    }

    public void setEdge(String edge) {
        this.edge = edge.replaceAll("^\"|\"$", "");
    }

    public void setCenterRed(String centerRed) {
        centerRed = centerRed.replaceAll("^\"|\"$", "");
        if(centerRed == "TRUE" || centerRed == "YES")
            this.centerRed = true;
        else
            this.centerRed = false;
    }
}
