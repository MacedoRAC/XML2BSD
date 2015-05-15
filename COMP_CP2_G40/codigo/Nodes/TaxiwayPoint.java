package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiwayPoint {

    private Integer index;
    private String type;
    private String orientation;
    private float lat;
    private float lon;
    private float biasX;
    private float biasZ;

    public TaxiwayPoint(){
        this.index = null;
        this.type = null;
        this.orientation = null;
        this.lat = Float.NaN;
        this.lon = Float.NaN;
        this.biasX = Float.NaN;
        this.biasZ = Float.NaN;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("====TAXIWAYPOINT -> attributes=====");
        System.out.println("===================================");


        if(this.lat != Float.NaN){
            System.out.println("Lat : " + this.lat);
        }

        if(this.lon != Float.NaN){
            System.out.println("Lon : " + this.lon);
        }

        if(this.type != null){
            System.out.println("Type : " + this.type);
        }

        if(this.orientation != null){
            System.out.println("Orientation : " + this.orientation);
        }

        if(this.biasX != Float.NaN){
            System.out.println("BiasX : " + this.biasX);
        }

        if(this.biasZ != Float.NaN){
            System.out.println("BiasZ : " + this.biasZ);
        }

        if(this.index != null){
            System.out.println("Index : " + this.index);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setIndex(String index) {
        index = index.replaceAll("^\"|\"$", "");
        this.index = Integer.parseInt(index);

        if(this.index < 0 || this.index > 3999){
            this.index = null;
            throw new IllegalArgumentException("Index is out of bounds (values between 0 and 3999 are allowed)");
        }
    }

    public void setType(String type) {
        this.type = type.replaceAll("^\"|\"$", "");
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation.replaceAll("^\"|\"$", "");
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

    public void setBiasX(String biasX) {
        biasX = biasX.replaceAll("^\"|\"$", "");
        this.biasX = Float.parseFloat(biasX);
    }

    public void setBiasZ(String biasZ) {
        biasZ = biasZ.replaceAll("^\"|\"$", "");
        this.biasZ = Float.parseFloat(biasZ);
    }
}
