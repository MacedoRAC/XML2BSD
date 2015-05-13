package Nodes;

/**
 * Created by Andr� on 13/05/2015.
 */
public class Previous {

    private String waypointType;
    private String waypointRegion;
    private String waypointIdent;
    private float altitudeMinimum;

    public Previous(){
        this.waypointType = null;
        this.waypointRegion = null;
        this.waypointIdent = null;
        this.altitudeMinimum = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======PREVIOUS -> attributes======");
        System.out.println("===================================");

        if(this.waypointType != null){
            System.out.println("WaypointType : " + this.waypointType);
        }

        if(this.altitudeMinimum != Float.NaN){
            System.out.println("AltitudeMinimum : " + this.altitudeMinimum);
        }

        if(this.waypointRegion != null){
            System.out.println("WaypointRegion : " + this.waypointRegion);
        }

        if(this.waypointIdent != null){
            System.out.println("WaypointIdent : " + this.waypointIdent);
        }


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setWaypointType(String waypointType) {
        this.waypointType = waypointType.replaceAll("^\"|\"$", "");
    }

    public void setWaypointRegion(String waypointRegion) {
        this.waypointRegion = waypointRegion.replaceAll("^\"|\"$", "");

        if(this.waypointRegion.length() != 2){
            this.waypointRegion = null;
            throw new IllegalArgumentException("WaypointRegion is out of bounds (must insert 2 chars)");
        }
    }

    public void setWaypointIdent(String waypointIdent) {
        this.waypointIdent = waypointIdent.replaceAll("^\"|\"$", "");

        if(this.waypointIdent.length() > 5){
            this.waypointIdent = null;
            throw new IllegalArgumentException("WaypointIdent is out of bounds (5 chars maximum are allowed)");
        }
    }

    public void setAltitudeMinimum(String altitudeMinimum) {
        altitudeMinimum = altitudeMinimum.replaceAll("^\"|\"$", "");
        this.altitudeMinimum = Float.parseFloat(altitudeMinimum);
    }
}
