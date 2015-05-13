package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class GlideSlope {

    private float lat;
    private float lon;
    private String alt;
    private float pitch;
    private String range;

    public GlideSlope(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.pitch = Float.NaN;
        this.range = "27N";
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("======GLIDESLOPE -> attributes=====");
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

        if(this.pitch != Float.NaN){
            System.out.println("Pitch : " + this.pitch);
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

    public void setPitch(String pitch) {
        pitch = pitch.replaceAll("^\"|\"$", "");
        this.pitch = Float.parseFloat(pitch);

        if(this.pitch < 0 || this.pitch > 360){
            this.pitch = Float.NaN;
            throw new IllegalArgumentException("Pitch is out of bounds (values between 0 and 360 are allowed)");
        }
    }

    public void setRange(String range) {
        this.range = range.replaceAll("^\"|\"$", "");
    }
}
