package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class DME {

    private float lat;
    private float lon;
    private String alt;
    private String range;

    public DME(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.range = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=========DME -> attributes=========");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
        }

        if(this.range != null){
            System.out.println("Range : " + this.range);
        }
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

    public void setAlt(String alt) {
        this.alt = alt.replaceAll("^\"|\"$", "");
    }

    public void setRange(String range) {
        this.range = range.replaceAll("^\"|\"$", "");
    }
}
