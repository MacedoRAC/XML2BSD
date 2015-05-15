package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class ILS {

    private float lat;
    private float lon;
    private String alt;
    private float heading;
    private float frequency;
    private String end;
    private String range;
    private float magvar;
    private String ident;
    private float width;
    private String name;
    private Boolean backCourse;

    public ILS(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.alt = null;
        this.heading = Float.NaN;
        this.frequency = Float.NaN;
        this.end = null;
        this.range = "27N";
        this.magvar = 0;
        this.ident = null;
        this.width = Float.NaN;
        this.name = null;
        this.backCourse = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("==========ILS -> attributes========");
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

        if(this.frequency != Float.NaN){
            System.out.println("Frequency : " + this.frequency);
        }

        if(this.end != null){
            System.out.println("End : " + this.end);
        }

        if(this.range != null){
            System.out.println("Range : " + this.range);
        }

        if(this.magvar != Float.NaN){
            System.out.println("Magvar : " + this.magvar);
        }

        if(this.ident != null){
            System.out.println("Ident : " + this.ident);
        }

        if(this.width != Float.NaN){
            System.out.println("Width : " + this.width);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }

        if(this.backCourse != null){
            System.out.println("BackCourse : " + this.backCourse);
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

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0.0 and 360 are allowed)");
        }
    }

    public void setFrequency(String frequency) {
        frequency = frequency.replaceAll("^\"|\"$", "");
        this.frequency = Float.parseFloat(frequency);

        if(this.frequency < 108 || this.frequency > 136.992){
            this.frequency = Float.NaN;
            throw new IllegalArgumentException("Frequency is out of bounds (values between 108.0 and 136.992 are allowed)");
        }
    }

    public void setEnd(String end) {
        this.end = end.replaceAll("^\"|\"$", "");
    }

    public void setRange(String range) {
        this.range = range.replaceAll("^\"|\"$", "");
    }

    public void setMagvar(String magvar) {
        magvar = magvar.replaceAll("^\"|\"$", "");
        this.magvar = Float.parseFloat(magvar);

        if(this.magvar < -360 || this.magvar > 360){
            this.magvar = Float.NaN;
            throw new IllegalArgumentException("Magvar is out of bounds (values between -360 and 360 are allowed)");
        }
    }

    public void setIdent(String ident) {
        this.ident = ident.replaceAll("^\"|\"$", "");

        if(this.ident.length() > 5){
            this.ident = null;
            throw new IllegalArgumentException("Ident is out of bounds (5 char at maximum)");
        }
    }

    public void setWidth(String width) {
        width = width.replaceAll("^\"|\"$", "");
        this.width = Float.parseFloat(width);

        if(this.width < 0 || this.width > 360){
            this.width = Float.NaN;
            throw new IllegalArgumentException("Width is out of bounds (values between 0 and 360 are allowed)");
        }
    }

    public void setName(String name) {
        this.name = name.replaceAll("^\"|\"$", "");

        if(this.name.length() > 48){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (48 char at maximum)");
        }
    }

    public void setBackCourse(String backCourse) {
        backCourse = backCourse.replaceAll("^\"|\"$", "");

        if(backCourse == "TRUE" || backCourse == "YES")
            this.backCourse = true;
        else
            this.backCourse = false;
    }
}
