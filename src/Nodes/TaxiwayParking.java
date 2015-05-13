package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class TaxiwayParking {

    private Integer index;
    private String type;
    private String orientation;
    private float lat;
    private float lon;
    private float biasX;
    private float biasZ;
    private float heading;
    private Integer number;
    private String airlineCodes;
    private Integer pushBack;
    private float teeOffset1;
    private float teeOffset2;
    private float teeOffset3;
    private float teeOffset4;

    public TaxiwayParking(){
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
        System.out.println("====TAXIWAYARKING -> attributes====");
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

        if(this.heading != Float.NaN){
            System.out.println("Heading : " + this.heading);
        }

        if(this.number != Float.NaN){
            System.out.println("Number : " + this.number);
        }

        if(this.airlineCodes != null){
            System.out.println("AirlineCodes : " + this.airlineCodes);
        }

        if(this.pushBack != null){
            System.out.println("PushBack : " + this.pushBack);
        }

        if(this.teeOffset1 != Float.NaN){
            System.out.println("TeeOffset1 : " + this.teeOffset1);
        }

        if(this.teeOffset2 != Float.NaN){
            System.out.println("TeeOffset2 : " + this.teeOffset2);
        }

        if(this.teeOffset3 != Float.NaN){
            System.out.println("TeeOffset3 : " + this.teeOffset3);
        }

        if(this.teeOffset4 != Float.NaN){
            System.out.println("TeeOffset4 : " + this.teeOffset4);
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

    public void setHeading(String heading) {
        heading = heading.replaceAll("^\"|\"$", "");
        this.heading = Float.parseFloat(heading);

        if(this.heading < 0 || this.heading > 360){
            this.heading = Float.NaN;
            throw new IllegalArgumentException("Heading is out of bounds (values between 0 and 360 are allowed)");
        }
    }

    public void setNumber(String number) {
        number = number.replaceAll("^\"|\"$", "");
        this.number = Integer.parseInt(number);

        if(this.number < 0 || this.number > 3999){
            this.number = null;
            throw new IllegalArgumentException("Number is out of bounds (values between 0 and 3999 are allowed)");
        }
    }

    public void setAirlineCodes(String airlineCodes) {
        this.airlineCodes = airlineCodes.replaceAll("^\"|\"$", "");
    }

    public void setPushBack(String pushBack) {
        pushBack = pushBack.replaceAll("^\"|\"$", "");
        this.pushBack = Integer.parseInt(pushBack);
    }

    public void setTeeOffset1(String teeOffset1) {
        teeOffset1 = teeOffset1.replaceAll("^\"|\"$", "");
        this.teeOffset1 = Float.parseFloat(teeOffset1);

        if(this.teeOffset1 < 0.1 || this.teeOffset1 > 50){
            this.teeOffset1 = Float.NaN;
            throw new IllegalArgumentException("TeeOffset1 is out of bounds (values between 0.1 and 50 are allowed)");
        }
    }

    public void setTeeOffset2(String teeOffset2) {
        teeOffset2 = teeOffset2.replaceAll("^\"|\"$", "");
        this.teeOffset2 = Float.parseFloat(teeOffset2);

        if(this.teeOffset2 < 0.1 || this.teeOffset2 > 50){
            this.teeOffset2 = Float.NaN;
            throw new IllegalArgumentException("TeeOffset2 is out of bounds (values between 0.1 and 50 are allowed)");
        }
    }

    public void setTeeOffset3(String teeOffset3) {
        teeOffset3 = teeOffset3.replaceAll("^\"|\"$", "");
        this.teeOffset3 = Float.parseFloat(teeOffset3);

        if(this.teeOffset3 < 0.1 || this.teeOffset3 > 50){
            this.teeOffset3 = Float.NaN;
            throw new IllegalArgumentException("TeeOffset3 is out of bounds (values between 0.1 and 50 are allowed)");
        }
    }

    public void setTeeOffset4(String teeOffset4) {
        teeOffset4 = teeOffset4.replaceAll("^\"|\"$", "");
        this.teeOffset4 = Float.parseFloat(teeOffset4);

        if(this.teeOffset4 < 0.1 || this.teeOffset4 > 50){
            this.teeOffset4 = Float.NaN;
            throw new IllegalArgumentException("TeeOffset4 is out of bounds (values between 0.1 and 50 are allowed)");
        }
    }
}
