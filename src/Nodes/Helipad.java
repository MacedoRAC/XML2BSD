package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Helipad {

    private float lat;
    private float lon;
    private String alt;
    private String surface;
    private float heading;
    private String length;
    private String width;
    private String type;
    private Boolean closed;
    private Boolean transparent;
    private Integer red;
    private Integer green;
    private Integer blue;

    public Helipad(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.surface = null;
        this.heading = Float.NaN;
        this.length = null;
        this.width = null;
        this.type = null;
        this.closed = null;
        this.transparent = null;
        this.red = null;
        this.green = null;
        this.blue = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("========HELIPAD -> attributes======");
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

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.surface != null){
            System.out.println("Surface : " + this.surface);
        }

        if(this.length != null){
            System.out.println("Length : " + this.length);
        }

        if(this.width != null){
            System.out.println("Width : " + this.width);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.closed != null){
            System.out.println("Closed : " + this.closed);
        }

        if(this.width != null){
            System.out.println("Width : " + this.width);
        }

        if(this.transparent != null){
            System.out.println("Transparent : " + this.transparent);
        }

        if(this.red != null){
            System.out.println("Red : " + this.red);
        }

        if(this.green != null){
            System.out.println("Green : " + this.green);
        }

        if(this.blue != null){
            System.out.println("Blue : " + this.blue);
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

    public void setAlt(String alt) {
        this.alt = alt.replaceAll("^\"|\"$", "");
    }

    public void setSurface(String surface) {
        this.surface = surface.replaceAll("^\"|\"$", "");
    }

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0 and 360 are allowed)");
        }
    }

    public void setLength(String length) {
        this.length = length.replaceAll("^\"|\"$", "");
    }

    public void setWidth(String width) {
        this.width = width.replaceAll("^\"|\"$", "");
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }

    public void setClosed(String closed) {
        closed = closed.replaceAll("^\"|\"$", "");

        if(closed == "TRUE" || closed == "YES")
            this.closed = true;
        else
            this.closed = false;
    }

    public void setTransparent(String transparent) {
        transparent = transparent.replaceAll("^\"|\"$", "");

        if(transparent == "TRUE" || transparent == "YES")
            this.transparent = true;
        else
            this.transparent = false;
    }

    public void setRed(String red) {
        red = red.replaceAll("^\"|\"$", "");
        this.red = Integer.parseInt(red);

        if(this.red < 0 || this.red > 255){
            this.red = null;
            throw new IllegalArgumentException("Red is out of bounds (integer between 0 and 255 are allowed)");
        }
    }

    public void setGreen(String green) {
        green = green.replaceAll("^\"|\"$", "");
        this.green = Integer.parseInt(green);

        if(this.green < 0 || this.green > 255){
            this.green = null;
            throw new IllegalArgumentException("Green is out of bounds (integer between 0 and 255 are allowed)");
        }
    }

    public void setBlue(String blue) {
        blue = blue.replaceAll("^\"|\"$", "");
        this.blue = Integer.parseInt(blue);

        if(this.blue < 0 || this.blue > 255){
            this.blue = null;
            throw new IllegalArgumentException("Blue is out of bounds (integer between 0 and 255 are allowed)");
        }
    }
}
