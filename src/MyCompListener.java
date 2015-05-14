import Nodes.Airport;
import Nodes.ApproachLights;
import Nodes.BiasXYZ;
import Nodes.BlastPad;
import Nodes.Com;
import Nodes.DME;
import Nodes.Fuel;
import Nodes.GlideSlope;
import Nodes.Helipad;
import Nodes.Services;
import Nodes.ILS;
import Nodes.Lights;
import Nodes.Markings;
import Nodes.Next;
import Nodes.OffsetThreshold;
import Nodes.Overrun;
import Nodes.Previous;
import Nodes.Route;
import Nodes.Runway;
import Nodes.RunwayAlias;
import Nodes.RunwayStart;
import Nodes.TaxiName;
import Nodes.TaxiwayParking;
import Nodes.TaxiwayPath;
import Nodes.TaxiwayPoint;
import Nodes.Tower;
import Nodes.Vasi;
import Nodes.Waypoint;
import Nodes.VisualModel;

public class MyCompListener extends compBaseListener {

    private Airport airportNode;
    private Services servicesNode;
    private Fuel fuelNode;
    private Com comNode;
    private Runway runwayNode;
    private Markings markingsNode;
    private Lights lightsNode;
    private OffsetThreshold offthresholdNode;
    private BlastPad blastpadNode;
    private Overrun overrunNode;
    private ApproachLights approachligthsNode;


    public MyCompListener() {
        airportNode = new Airport();
        servicesNode = new Services();
        comNode = new Com();
        runwayNode = new Runway();
        markingsNode = new Markings();
        lightsNode = new Lights();
        offthresholdNode = new OffsetThreshold();
        blastpadNode = new BlastPad();
        overrunNode = new Overrun();
        approachligthsNode = new ApproachLights();
        

    }


    @Override
    public void exitStart(compParser.StartContext ctx) {
        System.out.println("Semantic Analysis ended" + System.lineSeparator());
    }

    /*Airport */
    @Override
    public void enterValue_string(compParser.Value_stringContext ctx) {
        try {
            String attribute = ctx.getText();
            String value = ctx.STRING().getText();

            switch (attribute) {
                case "region=":
                    airportNode.setRegion(value);
                    break;
                case "country=":
                    airportNode.setCountry(value);
                    break;
                case "state=":
                    airportNode.setState(value);
                    break;
                case "city=":
                    airportNode.setCity(value);
                    break;
                case "name=":
                    airportNode.setName(value);
                    break;
                case "ident=":
                    airportNode.setIdent(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = 1;/*ctx.get\getLine()*/
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }


    @Override
    public void enterValue_lat(compParser.Value_latContext ctx) {
        try {
            String attribute = ctx.getText();
            String value = ctx.lat_decimal().getText();

            switch (attribute) {
                case "lat=":
                    airportNode.setLat(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = 1;/*ctx.get\getLine()*/
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterValue_lon(compParser.Value_lonContext ctx) {
        try {
            String attribute = ctx.getText();
            String value = ctx.lon_decimal().getText();

            switch (attribute) {
                case "lon=":
                    airportNode.setLon(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = 1;/*ctx.get\getLine()*/
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterValue_alt(compParser.Value_altContext ctx) {
        try {
            String attribute = ctx.getText();
            String value = ctx.NUM().toString();

            switch (attribute) {
                case "alt=":
                    airportNode.setAlt(value);
                    break;
                case "length=":
                    runwayNode.setLength(value);
                    break;
                case "width=":
                    runwayNode.setWith(value);
                    break;
                case "patternAltitude=":
                    runwayNode.setPatternAltitude(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = 1;/*ctx.get\getLine()*/
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterValue_magvar(compParser.Value_magvarContext ctx) {
        try {
            String attribute = ctx.getText();
            String value = ctx.NUM().toString();

            switch (attribute) {
                case "magvar=":
                    airportNode.setMagvar(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = 1;/*ctx.get\getLine()*/
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterValue_tscalar(compParser.Value_tscalarContext ctx) {
        try {
            String attribute = ctx.value_tscalar().getText();
            String value = ctx.TRAFFIC_SCALAR().getText();

            switch (attribute) {
                case "trafficScalar=":
                    airportNode.setTrafficScalar(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterValue_radius(compParser.Value_radiusContext ctx) {
        try {
            String attribute = ctx.value_radius().getText();
            String value = ctx.TEST_RADIUS().getText();

            switch (attribute) {
                case "airportTestRadius=":
                    airportNode.setTestRadius(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }


    /*Services and Fuel */
    @Override
    public void enterFuel(compParser.FuelContext ctx) {
        fuelNode = new Fuel();
    }

    @Override
    public void exitFuel(compParser.FuelContext ctx) {
        servicesNode.addFuel(fuelNode);
    }

    @Override
    public void enterTypeOfFuel(compParser.TypeOfFuelContext ctx) {
        try {
            String attribute = ctx.typeOfFuel().getText();
            String value = ctx.FUEL_TYPE().getText();

            switch (attribute) {
                case "type=":
                    fuelNode.setFuelType(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterFuelAvail(compParser.FuelAvailContext ctx) {
        try {
            String attribute = ctx.fuelAvail().getText();
            String value = ctx.FUEL_AVAILABILITY().getText();

            switch (attribute) {
                case "availability=":
                    fuelNode.setFuelAvail(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    /* COM */
    @Override
    public void enterFreq_value(compParser.Freq_valueContext ctx) {
        try {
            String attribute = ctx.freq_value().getText();
            String value = ctx.COM_FREQ().getText();

            switch (attribute) {
                case "frequency=":
                    comNode.setFreq(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterCom_types(compParser.Com_typesContext ctx) {
        try {
            String attribute = ctx.com_types().getText();
            String value = ctx.COM_TYPE().getText();

            switch (attribute) {
                case "type=":
                    comNode.setType(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    /* RUNWAY */
    @Override
    public void enterSurface_types(compParser.Surface_typesContext ctx) {
        try {
            String attribute = ctx.surface_types().getText();
            String value = ctx.RUNWAY_SURFACE().getText();

            switch (attribute) {
                case "surface=":
                    runwayNode.setSurface(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterHeading_values(compParser.Heading_valuesContext ctx) {
        try {
            String attribute = ctx.heading_values().getText();
            String value = ctx.RUNWAY_HEADING().getText();

            switch (attribute) {
                case "heading=":
                    runwayNode.setHeading(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterRunway_number(compParser.Runway_numberContext ctx) {
        try {
            String attribute = ctx.runway_number().getText();
            String value = ctx.RUNWAY_NUMBER().getText();

            switch (attribute) {
                case "number=":
                    runwayNode.setNumber(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterDesignator_values(compParser.Designator_valuesContext ctx) {
        try {
            String attribute = ctx.designator_values().getText();
            String value = ctx.RUNWAY_DESIGNATOR().getText();

            switch (attribute) {
                case "designator=":
                    runwayNode.setDesignator(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterBoolean_value(compParser.Boolean_valueContext ctx) {
        try {
            String attribute = ctx.boolean_value().getText();
            String value = ctx.RUNWAY_DESIGNATOR().getText();

            switch (attribute) {
                case "primaryTakeoff=":
                    runwayNode.setPrimaryTakeoff(ctx.RUNWAY_PRIMARY_TAKEOFF.getText());
                    break;
                case "primaryLanding=":
                    runwayNode.setPrimarylanding(ctx.RUNWAY_PRIMARY_LANDING.getText());
                    break;
                case "secondaryTakeoff=":
                    runwayNode.setSecondaryTakeoff(ctx.RUNWAY_SECONDARY_TAKEOFF.getText());
                    break;
                case "secondaryLanding=":
                    runwayNode.setSecondarylanding(ctx.RUNWAY_SECONDARY_LANDING.getText());
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterPattern_value(compParser.Pattern_valueContext ctx) {
        try {
            String attribute = ctx.pattern_value().getText();

            switch (attribute) {
                case "primaryPattern=":
                    runwayNode.setPatternAltitude(ctx.RUNWAY_PRIMARY_PATTERN.getText());
                    break;
                case "secondaryPattern=":
                    runwayNode.setSecondaryPattern(ctx.RUNWAY_SECONDARY_PATTERN.getText());
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    /* MARKINGS */
    @Override
    public void enterRunway_markings(compParser.Runway_markingsContext ctx) {
        try {
            String attribute = ctx.boolean_value().getText();
            String value = ctx.MARKINGS().getText();
            switch (attribute) {
                case "alternateThreshold=":
                    markingsNode.setAlternateThreshold(value);
                    break;
                case "alternateTouchdown=":
                    markingsNode.setAlternateTouchdown(value);
                    break;
                case "alternateFixedDistance=":
                    markingsNode.setAlternateFixedDistance(value);
                    break;
                case "alternatePrecision=":
                    markingsNode.setAlternatePrecision(value);
                    break;
                case "leadingZeroIdent=":
                    markingsNode.setLeadingZeroIdent(value);
                    break;
                case "noThreshHoldEndArrows=":
                    markingsNode.setNoThresholdEndArrwos(value);
                    break;
                case "edges=":
                    markingsNode.setEdges(value);
                    break;
                case "threshold=":
                    markingsNode.setThreshold(value);
                    break;
                case "fixed=":
                    markingsNode.setFixed(value);
                    break;
                case "touchdown=":
                    markingsNode.setTouchdown(value);
                    break;
                case "dashes=":
                    markingsNode.setDashes(value);
                    break;
                case "ident=":
                    markingsNode.setIdent(value);
                    break;
                case "precision=":
                    markingsNode.setPrecision(value);
                    break;
                case "edgePavement=":
                    markingsNode.setEdgePavement(value);
                    break;
                case "singleEnd=":
                    markingsNode.setSingleEnd(value);
                    break;
                case "primaryClosed=":
                    markingsNode.setPrimaryClosed(value);
                    break;
                case "secondaryClosed=":
                    markingsNode.setSecondaryClosed(value);
                    break;
                case "primaryStol=":
                    markingsNode.setPrimaryStol(value);
                    break;
                case "secondaryStol=":
                    markingsNode.setSecondaryStol(value);
                    break;
                case "primaryMarkingBias=":
                    runwayNode.setPrimMarkingBias(ctx.RUNWAY_PRIMARY_MARKING_BIAS.getText());
                    break;
                case "secondaryMarkingBias=":
                    runwayNode.setSecMarkBias(ctx.RUNWAY_SECONDARY_MARKING_BIAS.getText());
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    /* LIGHTS */
    @Override
    public void enterLights_attributes(compParser.Lights_attributesContext ctx) {
        try {
            String attribute = ctx.lights_attributes().getText();

            switch (attribute) {
                case "center=":
                    lightsNode.setCenter(ctx.lights_center.getText());
                    break;
                case "edge=":
                    lightsNode.setEdge(ctx.lights_edge.getText());
                    break;
                case "centerRed=":
                    lightsNode.setCenterRed(ctx.lights_centerred.getText());
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }


    /* OFFTHRESHOLD */
    @Override
    public void enterEnd_attr(compParser.End_attrContext ctx) {
        try {
            String attribute = ctx.end_attr().getText();
            String value = ctx.end_attr_values().getText();

            switch (attribute) {
                case "end=":
                    offthresholdNode.setEnd(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterLength_attr(compParser.Length_attrContext ctx) {
        try {
            String attribute = ctx.value_alt().getText();

            switch (attribute) {
                case "length=":
                    offthresholdNode.setLenght(ctx.length_attr().getText());
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    @Override
    public void enterSurface_attr(compParser.Surface_attrContext ctx) {
        try {
            String attribute = ctx.surface_attr().getText();
            String value = ctx.surface_types().getText();

            switch (attribute) {
                case "surface=":
                    offthresholdNode.setSurface(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }


	/* BLASTPAD */

    @Override
    public void enterBlastpad_node(compParser.Blastpad_nodeContext ctx) {
        try {
            String attribute = ctx.blastpad_attr().getText();
            String value = ctx.BLASTPAD().getText();

            switch (attribute) {
                case "end=":
                    blastpadNode.setEnd(value);
                    break;
                case "length=":
                    blastpadNode.setLenght(value);
                    break;
                case "width=":
                    blastpadNode.setWidth(value);
                    break;
                case "surface=":
                    blastpadNode.setSurface(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }

    /* OVERRUN */
    @Override
    public void enterOverrun_node(compParser.Overrun_nodeContext ctx) {
        try {
            String attribute = ctx.overrun_node().getText();
            String value = ctx.OVERRUN().getText();

            switch (attribute) {
                case "end=":
                    blastpadNode.setEnd(value);
                    break;
                case "length=":
                    blastpadNode.setLenght(value);
                    break;
                case "width=":
                    blastpadNode.setWidth(value);
                    break;
                case "surface=":
                    blastpadNode.setSurface(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }


    /* APPROACHLIGHTS */
    @Override
    public void enterApproachlights_attr(compParser.Approachlights_attrContext ctx) {
        try {
            String attribute = ctx.boolean_value().getText();
            String attribute_num = ctx.scrobes_approachlights().getText();
            String attribute_system = ctx.system_approachlights().getText();
            String attribute_end = ctx.end_attr().getText();
            String value = ctx.APPROACHLIGHTS().getText();

            switch (attribute) {
                case "reil=":
                    approachligthsNode.setReil(value);
                    break;
                case "touchdown=":
                    approachligthsNode.setTouchdown(value);
                    break;
                case "endLights=":
                    approachligthsNode.setEndLights(value);
                    break;
                default:
                    break;
            }

            switch (attribute_num) {
                case "strobes=":
                    approachligthsNode.setStrobes(value);
                    break;
                default:
                    break;
            }

            switch (attribute_system) {
                case "system=":
                    approachligthsNode.setSystem(value);
                    break;
                default:
                    break;
            }

            switch (attribute_end) {
                case "end=":
                    approachligthsNode.setEnd(value);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            int errorLine = ctx.ASPAS().getSymbol().getLine();
            System.out.println(errorLine + ": " + e.getMessage());
        }
    }
}