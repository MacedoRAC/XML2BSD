import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;

public class MyCompListener extends compBaseListener {

    @Override
    public void enterValue_string(compParser.Value_stringContext ctx) {
        String str = ctx.getText();
        if(str.length() > 48)
            System.out.println("You can not have more than 48 characters");
    }

    @Override
    public void enterLat_decimal(compParser.Lat_decimalContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if (val > 90 || val< -90)
            System.out.println("lattitude value out of range");
    }

    @Override
    public void enterLon_decimal(compParser.Lon_decimalContext ctx){
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val > 90 || val < -90)
            System.out.println("Longitude value out of range");
    }

    @Override
    public void enterValue_magvar(compParser.Value_magvarContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < -360 || val > 360)
            System.out.println("Magvar value out of range");
    }

    @Override
    public void enterValue_tscalar(compParser.Value_tscalarContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 0.01 || val > 1.0)
            System.out.println("Traffic Scalar value out of range");
    }

    @Override
    public void enterFreq_value(compParser.Freq_valueContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 108.0 || val > 136.992)
            System.out.println("Frequency value out of range");
    }

    @Override
    public void enterHeading_values(compParser.Heading_valuesContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 0.0 || val > 360.0)
            System.out.println("Heading value out of range");
    }

    @Override
    public void enterStrobes_approachlights(compParser.Strobes_approachlightsContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str);
        if(val < 0 )
            System.out.println("Strobes value out of range");
    }

    @Override
    public void enterPitch_vasi(compParser.Pitch_vasiContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str);
        if(val < 0.0 || val > 10.0)
            System.out.println("Pitch value out of range");
    }

    @Override
    public void enterIdent_ils(compParser.Ident_ilsContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 7)
            System.out.println("Ident can not have more than 5 characters");
    }

    @Override
    public void enterWidth_attr(compParser.Width_attrContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.0 || val > 360.0)
            System.out.println("width value out of range");
    }

    @Override
    public void enterWaypointregion_waypoint(compParser.Waypointregion_waypointContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() != 4)
            System.out.println("Waypoint Region must have exactly 2 characters");
    }

    @Override
    public void enterWaypointident_waypoint(compParser.Waypointident_waypointContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 7)
            System.out.println("Waypoint Ident can not have more than 5 characters");
    }

    @Override
    public void enterName_route(compParser.Name_routeContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 10)
            System.out.println("Route Name can not have more than 8 characters");
    }

    @Override
    public void enterRed_helipad(compParser.Red_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("red value out of range");
    }

    @Override
    public void enterGreen_helipad(compParser.Green_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("green value out of range");
    }

    @Override
    public void enterBlue_helipad(compParser.Blue_helipadContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("blue value out of range");
    }

    @Override
    public void enterIndex_taxiway(compParser.Index_taxiwayContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 3999)
            System.out.println("Taxiway index value out of range");
    }

    @Override
    public void enterNumber_parking(compParser.Number_parkingContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 3999)
            System.out.println("Taxiway number value out of range");
    }

    @Override
    public void enterTeeoffset1_parking(compParser.Teeoffset1_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset1 value out of range");
    }

    @Override
    public void enterTeeoffset2_parking(compParser.Teeoffset2_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset2 value out of range");
    }

    @Override
    public void enterTeeoffset3_parking(compParser.Teeoffset3_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset3 value out of range");
    }

    @Override
    public void enterTeeoffset4_parking(compParser.Teeoffset4_parkingContext ctx) {
        String str = ctx.getText();
        float val = Float.parseFloat(str.split("=")[1]);
        if(val < 0.1 || val > 50.0)
            System.out.println("TeeOffset4 value out of range");
    }

    @Override
    public void enterIndex_taxiname(compParser.Index_taxinameContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("taxiname index value out of range");
    }

    @Override
    public void enterName_taxiname(compParser.Name_taxinameContext ctx) {
        String str = ctx.getText();
        String val = str.split("=")[1];
        if(str.length() > 10)
            System.out.println("Taxiname Name can not have more than 8 characters");
    }

    @Override
    public void enterName_taxiwaypath(compParser.Name_taxiwaypathContext ctx) {
        String str = ctx.getText();
        int val = Integer.parseInt(str.split("=")[1]);
        if(val < 0 || val > 255)
            System.out.println("Taxiname value out of range");
    }


}