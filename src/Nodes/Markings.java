package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Markings {

    private Boolean alternateThreshold;
    private Boolean alternateTouchdown;
    private Boolean alternateFixedDistance;
    private Boolean alternatePrecision;
    private Boolean leadingZeroIdent;
    private Boolean noThresholdEndArrwos;
    private Boolean edges;
    private Boolean threshold;
    private Boolean fixed;
    private Boolean touchdown;
    private Boolean dashes;
    private Boolean ident;
    private Boolean precision;
    private Boolean edgePavement;
    private Boolean singleEnd;
    private Boolean primaryClosed;
    private Boolean secondaryClosed;
    private Boolean primaryStol;
    private Boolean secondaryStol;

    public Markings(){
        this.alternateThreshold = null;
        this.alternateTouchdown = null;
        this.alternateFixedDistance = null;
        this.alternatePrecision = null;
        this.leadingZeroIdent = null;
        this.noThresholdEndArrwos = null;
        this.edges = null;
        this.threshold = null;
        this.fixed = null;
        this.touchdown = null;
        this.dashes = null;
        this.ident = null;
        this.precision = null;
        this.edgePavement = null;
        this.singleEnd = null;
        this.primaryClosed = null;
        this.secondaryClosed = null;
        this.primaryStol = null;
        this.secondaryStol = null;
    }

    public void output(){

        System.out.println("===================================");
        System.out.println("=======AIRPORT -> attributes=======");
        System.out.println("===================================");

        if(this.alternateThreshold != null){
            System.out.println("AlternateThreshold : " + this.alternateThreshold);
        }

        if(this.alternateTouchdown != null){
            System.out.println("AlternateTouchdown : " + this.alternateTouchdown);
        }

        if(this.alternateFixedDistance != null){
            System.out.println("AlternateFixedDistance : " + this.alternateFixedDistance);
        }

        if(this.alternatePrecision != null){
            System.out.println("AlternatePrecision : " + this.alternatePrecision);
        }

        if(this.leadingZeroIdent != null){
            System.out.println("LeadingZeroIdent : " + this.leadingZeroIdent);
        }

        if(this.noThresholdEndArrwos != null){
            System.out.println("NoThresholdEndArrwos : " + this.noThresholdEndArrwos);
        }

        if(this.edges != null){
            System.out.println("Edges : " + this.edges);
        }

        if(this.threshold != null){
            System.out.println("Threshold : " + this.threshold);
        }

        if(this.fixed != null){
            System.out.println("Fixed : " + this.fixed);
        }

        if(this.touchdown != null){
            System.out.println("Touchdown : " + this.touchdown);
        }

        if(this.dashes != null){
            System.out.println("Dashes : " + this.dashes);
        }

        if(this.ident != null){
            System.out.println("Ident : " + this.ident);
        }

        if(this.precision != null){
            System.out.println("Precision : " + this.precision);
        }

        if(this.edgePavement != null){
            System.out.println("EdgePavement : " + this.edgePavement);
        }

        if(this.singleEnd != null){
            System.out.println("SingleEnd : " + this.singleEnd);
        }

        if(this.primaryClosed != null){
            System.out.println("PrimaryClosed : " + this.primaryClosed);
        }

        if(this.secondaryClosed != null){
            System.out.println("SecondaryClosed : " + this.secondaryClosed);
        }

        if(this.primaryStol != null){
            System.out.println("PrimaryStol : " + this.primaryStol);
        }

        if(this.secondaryStol != null){
            System.out.println("SecondaryStol : " + this.secondaryStol);
        }

        System.lineSeparator();
        System.lineSeparator();
    }

    public void setAlternateThreshold(String alternateThreshold) {
        alternateThreshold = alternateThreshold.replaceAll("^\"|\"$", "");
        if(alternateThreshold == "TRUE" || alternateThreshold == "YES")
            this.alternateThreshold = true;
        else
            this.alternateThreshold = false;
    }

    public void setAlternateTouchdown(Boolean alternateTouchdown) {
        this.alternateTouchdown = alternateTouchdown;
    }

    public void setAlternateFixedDistance(String alternateFixedDistance) {
        alternateFixedDistance = alternateFixedDistance.replaceAll("^\"|\"$", "");
        if(alternateFixedDistance == "TRUE" || alternateFixedDistance == "YES")
            this.alternateFixedDistance = true;
        else
            this.alternateFixedDistance = false;
    }

    public void setAlternatePrecision(String alternatePrecision) {
        alternatePrecision = alternatePrecision.replaceAll("^\"|\"$", "");
        if(alternatePrecision == "TRUE" || alternatePrecision == "YES")
            this.alternatePrecision = true;
        else
            this.alternatePrecision = false;
    }

    public void setLeadingZeroIdent(String leadingZeroIdent) {
        leadingZeroIdent = leadingZeroIdent.replaceAll("^\"|\"$", "");
        if(leadingZeroIdent == "TRUE" || leadingZeroIdent == "YES")
            this.leadingZeroIdent = true;
        else
            this.leadingZeroIdent = false;
    }

    public void setNoThresholdEndArrwos(String noThresholdEndArrwos) {
        noThresholdEndArrwos = noThresholdEndArrwos.replaceAll("^\"|\"$", "");
        if(noThresholdEndArrwos == "TRUE" || noThresholdEndArrwos == "YES")
            this.noThresholdEndArrwos = true;
        else
            this.noThresholdEndArrwos = false;
    }

    public void setEdges(String edges) {
        edges = edges.replaceAll("^\"|\"$", "");
        if(edges == "TRUE" || edges == "YES")
            this.edges = true;
        else
            this.edges = false;
    }

    public void setThreshold(String threshold) {
        threshold = threshold.replaceAll("^\"|\"$", "");
        if(threshold == "TRUE" || threshold == "YES")
            this.threshold = true;
        else
            this.threshold = false;
    }

    public void setFixed(String fixed) {
        fixed = fixed.replaceAll("^\"|\"$", "");
        if(fixed == "TRUE" || fixed == "YES")
            this.fixed = true;
        else
            this.fixed = false;
    }

    public void setTouchdown(String touchdown) {
        touchdown = touchdown.replaceAll("^\"|\"$", "");
        if(touchdown == "TRUE" || touchdown == "YES")
            this.touchdown = true;
        else
            this.touchdown = false;
    }

    public void setDashes(String dashes) {
        dashes = dashes.replaceAll("^\"|\"$", "");
        if(dashes == "TRUE" || dashes == "YES")
            this.dashes = true;
        else
            this.dashes = false;
    }

    public void setIdent(String ident) {
        ident = ident.replaceAll("^\"|\"$", "");
        if(ident == "TRUE" || ident == "YES")
            this.ident = true;
        else
            this.ident = false;
    }

    public void setPrecision(String precision) {
        precision = precision.replaceAll("^\"|\"$", "");
        if(precision == "TRUE" || precision == "YES")
            this.precision = true;
        else
            this.precision = false;
    }

    public void setEdgePavement(String edgePavement) {
        edgePavement = edgePavement.replaceAll("^\"|\"$", "");
        if(edgePavement == "TRUE" || edgePavement == "YES")
            this.edgePavement = true;
        else
            this.edgePavement = false;
    }

    public void setSingleEnd(String singleEnd) {
        singleEnd = singleEnd.replaceAll("^\"|\"$", "");
        if(singleEnd == "TRUE" || singleEnd == "YES")
            this.singleEnd = true;
        else
            this.singleEnd = false;
    }

    public void setPrimaryClosed(String primaryClosed) {
        primaryClosed = primaryClosed.replaceAll("^\"|\"$", "");
        if(primaryClosed == "TRUE" || primaryClosed == "YES")
            this.primaryClosed = true;
        else
            this.primaryClosed = false;
    }

    public void setSecondaryClosed(String secondaryClosed) {
        secondaryClosed = secondaryClosed.replaceAll("^\"|\"$", "");
        if(secondaryClosed == "TRUE" || secondaryClosed == "YES")
            this.secondaryClosed = true;
        else
            this.secondaryClosed = false;
    }

    public void setPrimaryStol(String primaryStol) {
        primaryStol = primaryStol.replaceAll("^\"|\"$", "");
        if(primaryStol == "TRUE" || primaryStol == "YES")
            this.primaryStol = true;
        else
            this.primaryStol = false;
    }

    public void setSecondaryStol(String secondaryStol) {
        secondaryStol = secondaryStol.replaceAll("^\"|\"$", "");
        if(secondaryStol == "TRUE" || secondaryStol == "YES")
            this.secondaryStol = true;
        else
            this.secondaryStol = false;
    }
}
