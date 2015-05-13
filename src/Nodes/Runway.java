package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Runway {
    private String alt;
    private String surface;
    private String length;
    private String width;
    private String number;
    private String designator;
    private String primaryDesignator;
    private String secondaryDesignator;
    private String patternAltitude;
    private String secondaryPattern;
    private String primMarkingBias;
    private String secMarkBias;

    private Boolean primaryTakeoff;
    private Boolean primarylanding;
    private Boolean secondaryTakeoff;
    private Boolean secondarylanding;

    private float lat;
    private float lon;
    private float heading;


    public Runway(){
        this.alt = null;
        this.surface = null;
        this.length = null;
        this.width = null;
        this.number = null;
        this.designator = null;
        this.primaryDesignator = null;
        this.secondaryDesignator = null;
        this.patternAltitude = null;
        this.secondaryPattern = "LEFT";
        this.primMarkingBias = null;
        this.secMarkBias = null;

        this.primaryTakeoff = null;
        this.primarylanding = true;
        this.secondaryTakeoff = true;
        this.secondarylanding = true;

        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.heading = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("=======RUNWAY -> attributes========");
        System.out.println("===================================");

        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
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

        if(this.number != null){
            System.out.println("Number : " + this.number);
        }

        if(this.designator != null){
            System.out.println("Designator : " + this.designator);
        }

        if(this.primaryDesignator != null){
            System.out.println("PrimaryDesignator : " + this.primaryDesignator);
        }

        if(this.secondaryDesignator != null){
            System.out.println("SecondaryDesignator : " + this.secondaryDesignator);
        }

        if(this.patternAltitude != null){
            System.out.println("PatternAltitude : " + this.patternAltitude);
        }


        if(this.secondaryPattern != null){
            System.out.println("SecondaryPattern : " + this.secondaryPattern);
        }

        if(this.primMarkingBias != null){
            System.out.println("PrimaryMarkingBias : " + this.primMarkingBias);
        }

        if(this.secMarkBias != null){
            System.out.println("SecondaryMarkingBias : " + this.secMarkBias);
        }

        if(this.primaryTakeoff != null){
            System.out.println("PrimaryTakeOff : " + this.primaryTakeoff);
        }

        if(this.primarylanding != null){
            System.out.println("Primarylanding : " + this.primarylanding);
        }

        if(this.secondaryTakeoff != null){
            System.out.println("SecondaryTakeOff : " + this.secondaryTakeoff);
        }

        if(this.secondarylanding != null){
            System.out.println("SecondaryLanding : " + this.secondarylanding);
        }

        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setAlt(String alt) {
        this.alt = alt.replaceAll("^\"|\"$", "");
    }

    public void setSurface(String surface) {
        this.surface = surface.replaceAll("^\"|\"$", "");
    }

    public void setLength(String length) {
        this.length = length.replaceAll("^\"|\"$", "");
    }

    public void setWith(String with) {
        this.width = with.replaceAll("^\"|\"$", "");
    }

    public void setNumber(String number) {
        this.number = number.replaceAll("^\"|\"$", "");
    }

    public void setDesignator(String designator) {
        this.designator = designator.replaceAll("^\"|\"$", "");
    }

    public void setPrimaryDesignator(String primaryDesignator) {
        this.primaryDesignator = primaryDesignator.replaceAll("^\"|\"$", "");
    }

    public void setSecondaryDesignator(String secondaryDesignator) {
        this.secondaryDesignator = secondaryDesignator.replaceAll("^\"|\"$", "");
    }

    public void setPatternAltitude(String patternAltitude) {
        this.patternAltitude = patternAltitude.replaceAll("^\"|\"$", "");
    }

    public void setSecondaryPattern(String secondaryPattern) {
        this.secondaryPattern = secondaryPattern.replaceAll("^\"|\"$", "");
    }

    public void setPrimMarkingBias(String primMarkingBias) {
        this.primMarkingBias = primMarkingBias.replaceAll("^\"|\"$", "");
    }

    public void setSecMarkBias(String secMarkBias) {
        this.secMarkBias = secMarkBias.replaceAll("^\"|\"$", "");
    }

    public void setPrimaryTakeoff(String primaryTakeoff) {
        primaryTakeoff = primaryTakeoff.replaceAll("^\"|\"$", "");
        if(primaryTakeoff == "TRUE" || primaryTakeoff == "YES")
            this.primaryTakeoff = true;
        else
            this.primaryTakeoff = false;

    }

    public void setPrimarylanding(String primarylanding) {
        primarylanding = primarylanding.replaceAll("^\"|\"$", "");
        if(primarylanding == "TRUE" || primarylanding == "YES")
            this.primarylanding = true;
        else
            this.primarylanding = false;
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

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0.0 and 360.0 are allowed)");
        }
    }

    public void setSecondaryTakeoff(String secondaryTakeoff) {
        secondaryTakeoff = secondaryTakeoff.replaceAll("^\"|\"$", "");
        if(secondaryTakeoff == "TRUE" || secondaryTakeoff == "YES")
            this.secondaryTakeoff = true;
        else
            this.secondaryTakeoff = false;
    }

    public void setSecondarylanding(String secondarylanding) {
        secondarylanding = secondarylanding.replaceAll("^\"|\"$", "");
        if(secondarylanding == "TRUE" || secondarylanding == "YES")
            this.secondarylanding = true;
        else
            this.secondarylanding = false;
    }
}
