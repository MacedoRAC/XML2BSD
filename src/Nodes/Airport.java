package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Airport {
    private String region;
    private String country;
    private String state;
    private String city;
    private String name;
    private String ident;
    private String alt;
    private String testRadius;


    private float lat;
    private float lon;
    private float magvar;
    private float trafficScalar;

    public Airport(){
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.magvar = Float.NaN;
        this.trafficScalar = Float.NaN;
    }

    public void output(){

        System.out.println("===================================");
        System.out.println("=======AIRPORT -> attributes=======");
        System.out.println("===================================");

        if(this.region != null){
            System.out.println("Region : " + this.region);
        }

        if(this.country != null){
            System.out.println("Country : " + this.country);
        }

        if(this.state != null){
            System.out.println("State : " + this.state);
        }

        if(this.city != null){
            System.out.println("City : " + this.city);
        }

        if(this.ident != null){
            System.out.println("Ident : " + this.ident);
        }

        if(this.alt != null){
            System.out.println("Alt : " + this.alt);
        }

        if(this.testRadius != null){
            System.out.println("AirportTestRadius : " + this.testRadius);
        }

        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }


        if(this.magvar != Float.NaN){
            System.out.println("Magvar : " + this.magvar);
        }


        if(this.trafficScalar != Float.NaN){
            System.out.println("TrafficScalar : " + this.trafficScalar);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setRegion(String region) {
        this.region = region.replaceAll("^\"|\"$", "");

        if(this.region.length() > 48){
            this.region = null;
            throw new IllegalArgumentException("Region is out of bounds (48 chars at maximum are allowed)");
        }
    }

    public void setCountry(String country) {
        this.country = country.replaceAll("^\"|\"$", "");

        if(this.country.length() > 48){
            this.country = null;
            throw new IllegalArgumentException("Country is out of bounds (48 chars at maximum are allowed)");
        }
    }

    public void setState(String state) {
        this.state = state.replaceAll("^\"|\"$", "");

        if(this.state.length() > 48){
            this.state = null;
            throw new IllegalArgumentException("State is out of bounds (48 chars at maximum are allowed)");
        }
    }

    public void setCity(String city) {
        this.city = city.replaceAll("^\"|\"$", "");

        if(this.city.length() > 48){
            this.city = null;
            throw new IllegalArgumentException("City is out of bounds (48 chars at maximum are allowed)");
        }
    }

    public void setName(String name) {
        this.name = name.replaceAll("^\"|\"$", "");

        if(this.name.length() > 48){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (48 chars at maximum are allowed)");
        }
    }

    public void setIdent(String ident) {
        this.ident = ident.replaceAll("^\"|\"$", "");

        if(this.ident.length() > 4){
            this.ident = null;
            throw new IllegalArgumentException("Ident is out of bounds (4 chars at maximum are allowed)");
        }
    }

    public void setAlt(String alt) {
        this.alt = alt.replaceAll("^\"|\"$", "");
    }

    public void setTestRadius(String testRadius) {
        this.testRadius = testRadius.replaceAll("^\"|\"$", "");
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

    public void setMagvar(String magvar) {
        magvar = magvar.replaceAll("^\"|\"$", "");
        this.magvar = Float.parseFloat(magvar);

        if(this.magvar < -360 || this.magvar > 360){



















































































            this.magvar = Float.NaN;
            throw new IllegalArgumentException("Magvar is out of bounds (values between -360 and 360 are allowed)");
        }
    }

    public void setTrafficScalar(String trafficScalar) {
        trafficScalar = trafficScalar.replaceAll("^\"|\"$", "");
        this.trafficScalar = Float.parseFloat(trafficScalar);

        if(this.trafficScalar < 0.01 || this.trafficScalar > 1.0){
            this.trafficScalar = Float.NaN;
            throw new IllegalArgumentException("TrafficScalar is out of bounds (values between 0.01 and 1.0 are allowed)");
        }
    }
}
