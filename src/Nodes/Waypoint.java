package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Waypoint {

    private float lat;
    private float lon;
    private String waypointType;
    private float magvar;
    private String waypointRegion;
    private String waypointIdent;

    public Waypoint(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.waypointType = null;
        this.magvar = Float.NaN;
        this.waypointRegion = null;
        this.waypointIdent = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======WAYPOINT -> attributes======");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.waypointType != null){
            System.out.println("WaypointType : " + this.waypointType);
        }

        if(this.magvar != Float.NaN){
            System.out.println("Magvar : " + this.magvar);
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

    public void setLat(String lat) {
        lat = lat.replaceAll("^\"|\"$", "");
        this.lat = Float.parseFloat(lat);

        if(this.lat < -90 || this.lat > 90){
            this.lat = Float.NaN;
            throw new IllegalArgumentException("Lat is out of bounds (values between -90 and 90 are allowed)");
        }
    }

    public void setLon(String lon) {
        lon = lon.replaceAll("^\"|\"$", "");
        this.lon = Float.parseFloat(lon);

        if(this.lon < -180 || this.lon > 180){
            this.lon = Float.NaN;
            throw new IllegalArgumentException("Lon is out of bounds (values between -180 and 180 are allowed)");
        }
    }

    public void setWaypointType(String waypointType) {
        this.waypointType = waypointType.replaceAll("^\"|\"$", "");
    }

    public void setMagvar(String magvar) {
        magvar = magvar.replaceAll("^\"|\"$", "");
        this.magvar = Float.parseFloat(magvar);

        if(this.magvar < -360 || this.magvar > 360){
            this.magvar = Float.NaN;
            throw new IllegalArgumentException("Magvar is out of bounds (values between -360 and 360 are allowed)");
        }
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
}
