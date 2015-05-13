grammar comp;

/* GENERAL TOKENS */
NUM : [0-9]+ ;
INTLAT : [0-90] ;
STRING : ([a-z] | [A-Z])*;
UPPER : [A-Z];
CHAR : [A-Z] | [a-z];
ASPAS : '"' ;
CLOSE_TAG : '>';
STARTNODE : '<';
ENDNODE : '/>';
START_END_NODE : '</';
EQUAL : '=';

/* NODE NAMES TOKENS */
AIRPORT : 'Airport';
TOWER : 'Tower';
SERVICES : 'Services';
COM : 'Com';
RUNWAY : 'Runway';
MARKINGS : 'Markings';
LIGHTS : 'Lights';
OFFSETTHRESHOLD : 'OffsetThreshold';
BLASTPAD : 'BlastPad';
OVERRUN : 'Overrun';
APPROACHLIGHTS : 'ApproachLights';
ILS : 'Ils';
GLIDESLOPE : 'GlideSlope';
DME : 'Dme';
VISUALMODEL : 'VisualModel';
BIASXYZ : 'BiasXYZ';
RUNWAYALIAS : 'RunwayAlias';
VERTEX : 'Vertex';
WAYPOINT : 'Waypoint';
ROUTE : 'Route';
PREVIOUS : 'Previous';
NEXT : 'Next';
TAXIWAYPOINT : 'TaxiwayPoint';
TAXIWAYPARKING : 'TaxiwayParking';
TAXINAME : 'TaxiName';
TAXIWAYPATH : 'TAxiwayPath';
VASI : 'Vasi';

/* ATTRIBUTES TOKENS */
REGION : 'region';
COUNTRY : 'country';
STATE : 'state';
CITY : 'city';
NAME : 'name';
LAT : 'lat';
LON : 'lon';
ALT : 'alt';
MAGVAR : 'magvar';
IDENT : 'ident';
AIRPORT_TEST_RADIUS : 'airportTestRadius';
TRAFFIC_SCALAR : 'trafficScalar';
TYPE : 'type';
AVAILABILITY : 'availability';
FREQUENCY : 'frequency';
SURFACE : 'surface';
HEADING : 'heading';
LENGTH : 'length';
WIDTH : 'width';
NUMBER : 'number';
DESIGNATOR : 'designator';
PRIMARY_DESIGNATOR : 'primaryDesignator';
SECONDARY_DESIGNATOR : 'secondaryDesignator';
PATTERN_ALT : 'patternAltitude';
PRIMARY_TAKEOFF : 'primaryTakeoff';
PRIMARY_LANDING : 'primaryLanding';
PRIMARY_PATTERN : 'primaryPattern';
SECONDARY_TAKEOFF : 'secondaryTakeoff';
SECONDARY_LANDING : 'secondaryLanding';
SECONDARY_PATTERN : 'secondaryPattern';
PRIMARY_MARKING_BIAS : 'primaryMarkingBias';
SECONDARY_MARKING_BIAS : 'secondaryMarkingBias';
ALTERNATE_THRESHOLD : 'alternateThreshold';
ALTERNATE_TOUCHDOWN : 'alternateTouchdown';
ALTERNATE_FIXED_DISTANCE : 'alternateFixedDistance';
ALTERNATE_PRECISION : 'alternatePrecision';
LEADING_ZERO_IDENT : 'leadingZeroIdent';
NO_THRESHOLD_END_ARROWS : 'noThreshHoldEndArrows';
EDGES : 'edges';
THRESHOLD : 'threshold';
FIXED_DISTANCE : 'fixedDistance';
TOUCHDOWN : 'touchdown';
DASHES : 'dashes';
PRECISION : 'precision';
EDGE_PAVEMENT : 'edgePavement';
SINGLE_END : 'singleEnd';
PRIMARY_CLOSED : 'primaryClosed';
SECONDARY_CLOSED : 'secondaryClosed';
PRIMARY_STOL : 'primaryStol';
SECONDARY_STOL : 'secondaryStol';
CENTER : 'center';
CENTER_RED : 'centerRed';
END : 'end';
SYSTEM : 'system';
STROBES : 'strobes';
REIL : 'reil';
END_LIGHTS : 'endLights';
SIDE : 'side';
BIAS_X : 'biasX';
BIAS_Z : 'biasZ';
BIAS_Y : 'biasY';
SPACING : 'spacing';
PITCH : 'pitch';
RANGE : 'range';
BACK_COURSE : 'backCourse';
IMAGE_COMPLEXITY : 'imageComplexity';
INSTANCE_ID : 'instanceId';
WAYPOINT_TYPE : 'waypointType';
WAYPOINT_REGION : 'waypointRegion';
WAYPOINT_IDENT : 'waypointIdent';
ROUTE_TYPE : 'routeType';
ALTITUDE_MINIMUM : 'altitudeMinimum';
CLOSED : 'closed';
TRANSPARENT : 'transparent';
RED : 'red';
GREEN : 'green';
BLUE : 'blue';


WS: [ \t\n\r]+ -> skip ;

start : STARTNODE AIRPORT attributes CLOSE_TAG airport_nodes? START_END_NODE AIRPORT CLOSE_TAG
		{System.out.println("WELL DONE !");}
	;

airport_nodes : tower_node? services_node? com_node? runway_node? runwayalias_node? waypoint_node? helipad_node? taxi_nodes?;

taxi_nodes : taxiwaypoint_node taxiwayparking_node taxiname_node taxiwaypath_node;

attributes : (REGION value_string)?
			 (COUNTRY value_string)?
			 (STATE value_string)?
			 (CITY value_string)?
			 (NAME value_string)?
			 LAT value_lat
			 LON value_lon
			 ALT value_alt
			 (MAGVAR value_magvar)?
			 IDENT value_string
			 (TEST_RADIUS value_radius)?
			 (TRAFFIC_SCALAR value_tscalar)?
			 CLOSE_TAG;

value_string : ASPAS STRING* ASPAS; /* Falta semantica - max 48chars */

value_lat : ASPAS (lat_decimal | lat_degree) ASPAS;
lat_decimal : '-'? INTLAT ('.' NUM+)?;
lat_degree : NUM; /* FALTA SEMANTICA */

value_lon : ASPAS (lon_decimal | lon_degree) ASPAS;
lon_decimal : NUM; /* FALTA SEMANTICA */
lon_degree : NUM; /* FALTA SEMANTICA */

value_alt : ASPAS (NUM* ('.' NUM+)? ('M'|'F')?) ASPAS;
value_radius : ASPAS (NUM* ('M'|'F'|'N')?) ASPAS;

value_magvar : '-'? NUM* ('.' NUM+)?; /* FALTA SEMANTICA */
value_tscalar : NUM '.' NUM ; /* FALTA SEMANTICA */

/* TOWER NODE */
tower_node : STARTNODE TOWER tower_attributes ENDNODE;

tower_attributes : 	LAT value_lat
					LON value_lon
					ALT value_alt
					;

/* SERVICES NODE */
services_node : SERVICES fuel* CLOSE_SERVICES;

fuel : FUEL_TYPE typeOfFuel
	   FUEL_AVAILABILITY fuelAvail
	  ;

typeOfFuel : ASPAS ('73' | '87' | '100' | '130' | '145' | 'MOGAS' | 'JET' | 'JETA' | 'JETA1' | 'JETAP' | 'JETB' | 'JET4' | 'JET5' | 'UNKNOWN') ASPAS;

fuelAvail : ASPAS ('YES' | 'NO' | 'UNKNOWN' | 'PRIOR_REQUEST') ASPAS;


/* COM NODE */
com_node : STARTNODE COM com_attributes ENDNODE;

com_attributes : COM_FREQ freq_value
				 COM_TYPE com_types
				 NAME value_string
				 ;

freq_value : ASPAS  ASPAS; /* falta semantica */

com_types : ASPAS ('APPROACH' | 'ASOS' | 'AWOS' | 'CENTER' | 'CLEARANCE' | 'CLEARANCE_PRE_TAXI' | 'CTAF' | 'DEPARTURE' | 'FSS' | 'GROUND' | 'MULTICOM' | 'REMOTE_CLEARANCE_DELIVERY' | 'TOWER' | 'UNICOM') ASPAS;


/* RUNWAY NODE */
runway_node : RUNWAY runway_attributes runway_nodes* CLOSE_RUNWAY;

runway_nodes : markings_node | lights_node | offsetthreshold_node | blastpad_node | overrun_node | approachlights_node | vasi_node | ils_node | runwaystart_node;

runway_attributes: LAT value_lat
				   LON value_lon
				   ALT value_alt
				   RUNWAY_SURFACE surface_types
				   RUNWAY_HEADING heading_values
				   RUNWAY_LENGTH  value_alt
				   RUNWAY_WIDTH value_alt
				   RUNWAY_NUMBER runway_number
				   (RUNWAY_DESIGNATOR designator_values)?
				   (RUNWAY_PRIMARY_DESIGNATOR primary_designator)?
				   (RUNWAY_SECONDARY_DESIGNATOR secondary_values)?
				   (RUNWAY_PATTERN_ALT value_alt)?
				   (RUNWAY_PRIMARY_TAKEOFF boolean_value)?
				   (RUNWAY_PRIMARY_LANDING boolean_value)?
				   (RUNWAY_PRIMARY_PATTERN pattern_value)?
				   (RUNWAY_SECONDARY_TAKEOFF boolean_value)?
				   (RUNWAY_SECONDARY_LANDING boolean_value)?
				   (RUNWAY_SECONDARY_PATTERN pattern_value)?
				   RUNWAY_PRIMARY_MARKING_BIAS runway_markings
				   RUNWAY_SECONDARY_MARKING_BIAS runway_markings
				   CLOSE_TAG;

surface_types : ASPAS ('ASPHALT' | 'BITUMINOUS' | 'BRICK' | 'CLAY' | 'CLEMENT' | 'CONCRETE' | 'CORAL' | 'DIRT' | 'GRASS' | 'GRAVEL' | 'ICE' | 'MACADAM' | 'OIL_TREATED, PLANKS' | 'SAND' | 'SHALE' | 'SNOW' | 'STEEL_MATS' | 'TARMAC' | 'UNKNOWN' | 'WATER') ASPAS;

heading_values : ASPAS (NUM* ('.' NUM+)?) ASPAS; /* falta semantica */

runway_number : ASPAS (NUM | NUM | 'EAST' | 'NORTH' | 'NORTHEAST' | 'NORTHWEST' | 'SOUTH' | 'SOUTHEAST' | 'SOUTHWEST' | 'WEST') ASPAS; /* falta semantica */

designator_values : ASPAS ('NONE' | 'C' | 'CENTER' | 'L' | 'LEFT' | 'R' | 'RIGHT' | 'W' | 'WATER' | 'A' | 'B') ASPAS; /* falta semantica */

primary_designator : designator_values; /* falta semantica */

secondary_values : designator_values; /* falta semantica */

boolean_value : ASPAS (('TRUE' | 'YES') | ('FALSE' | 'NO')) ASPAS; /* falta semantica */

pattern_value : ASPAS ('LEFT' | 'RIGHT') ASPAS; /* falta semantica */

runway_markings : ASPAS (NUM ('F' | 'N' | 'M')) ASPAS;

/* MARKINGS NODE */
markings_node : STARTNODE MARKINGS markings_attributes* ENDNODE;

markings_attributes : markings_attr ASPAS boolean_value ASPAS;

markings_attr : 'alternateThreshold=' | 'alternateTouchdown=' | 'alternateFixedDistance=' | 'alternatePrecision=' | 'leadingZeroIdent=' | 'noThreshHoldEndArrows=' | 'edges=' | 'threshold=' | 'fixed=' | 'touchdown=' | 'dashes=' | 'ident=' | 'precision=' | 'edgePavement=' | 'singleEnd=' | 'primaryClosed=' | 'secondaryClosed' | 'primaryStol=' | 'secondaryStol=';

/* LIGHTS NODE */
lights_node : STARTNODE LIGHTS lights_attributes* ENDNODE;

lights_attributes : lights_center | lights_edge | lights_centerred;

lights_center : 'center=' ASPAS runway_lights ASPAS;

lights_edge : 'edge=' ASPAS runway_lights ASPAS;

lights_centerred : 'centerRed=' ASPAS boolean_value ASPAS;

runway_lights : 'NONE' | 'LOW' | 'MEDIUM' | 'HIGH';

/* OFFSET_THRESHOLD NODE */
offsetthreshold_node : STARTNODE OFFSETTHRESHOLD offsetthreshold_attr* ENDNODE;

offsetthreshold_attr : end_attr | length_attr | width_attr | surface_attr;

end_attr : 'end=' ASPAS end_attr_values ASPAS;
end_attr_values : 'PRIMARY' | 'SECONDARY';

length_attr : 'length=' value_alt;

surface_attr: 'surface=' surface_types;

/* BLASTPAD NODE */
blastpad_node : STARTNODE BLASTPAD blastpad_attr* ENDNODE;

blastpad_attr : end_attr | length_attr | width_attr | surface_attr;

/* OVERRUN NODE */
overrun_node : STARTNODE OVERRUN overrun_attr* ENDNODE;

overrun_attr : end_attr | length_attr | width_attr | surface_attr;

/* APPROACH LIGHTS NODE */
approachlights_node : STARTNODE APPROACHLIGHTS approachlights_attr* ENDNODE;

approachlights_attr : end_attr | system_approachlights | scrobes_approachlights | reil_approachlights | touchdown_approachlights | endlights_approachlights;

system_approachlights : ASPAS ('NONE' | 'ALSF1' | 'ALSF2' | 'CALVERT' | 'CALVERT2' | 'MALS' | 'MALSF' | 'MALSR' | 'ODALS' | 'RAIL' | 'SALS' | 'SALSF' | 'SSALF' | 'SSALR' | 'SSALS') ASPAS;

scrobes_approachlights : ASPAS NUM ASPAS;

reil_approachlights : ASPAS boolean_value ASPAS;

touchdown_approachlights : ASPAS boolean_value ASPAS;

endlights_approachlights : ASPAS boolean_value ASPAS;

/* VASI NODE */
vasi_node : STARTNODE VASI vasi_attr* ENDNODE;

vasi_attr : end_attr | type_vasi | side_vasi | biasX | biasZ | spacing_vasi | pitch_vasi;

type_vasi : ASPAS ('PAPI2 (2 light PAPI)' | 'PAPI4 (4 light PAPI)' | 'PVASI (Pulsating VASI)' | 'TRICOLOR Tri Color VASI' | 
	               'TVASI colored VASI in a shared-"T" shape' | 'VASI21 2 rows, 1 box/row' | 'VASI22 2 rows, 2 boxes/row' | 'VASI23 2 rows, 3 boxes/row' |  
                   'VASI31 3 rows, 1 box/row' | 'VASI32 3 rows, 2 boxes/row' | 'VASI33 3 rows, 3 boxes/row (far row has only two boxes, 8 light system)' | 
                   'BALL (presently remapped to PVASI)' | 'APAP (panels)' | 'PANELS (presently remapped to PAP2)') ASPAS;

side_vasi : ASPAS ('LEFT' | 'RIGHT') ASPAS;

spacing_vasi : ASPAS NUM ASPAS;

pitch_vasi : ASPAS NUM ASPAS;

/* ILS NODE */
ils_node : ILS ils_attr CLOSE_TAG ils_nodes* CLOSE_ILS;

ils_nodes : glideslope_node | dme_node | visualmodel_node;

ils_attr : lat_attr | lon_attr | alt_attr | heading_attr | freq_attr | end_attr | range_ils | magvar_attr | ident_ils | width_attr | name_ils | backcourse_ils;

lat_attr : 'lat=' value_lat;

lon_attr : 'lon=' value_lon;

alt_attr : 'alt=' value_alt;

heading_attr : 'heading=' ASPAS NUM '.' NUM ASPAS;

freq_attr : 'frequency=' ASPAS NUM '.' NUM ASPAS;

range_ils : 'range=' ASPAS NUM 'N'? ASPAS;

magvar_attr : 'magvar=' ASPAS NUM '.' NUM ASPAS;

ident_ils : 'ident=' ASPAS STRING ASPAS;

width_attr : 'width=' ASPAS NUM '.' NUM ASPAS;

name_ils : 'name=' ASPAS STRING ASPAS;

backcourse_ils : 'backCourse=' ASPAS boolean_value ASPAS;

/* RUNWAYSTART_NODE */
runwaystart_node : STARTNODE 'RunwayStart' type_runwaystart? lat_attr lon_attr alt_attr heading_attr end_runwaynode? ENDNODE;

type_runwaystart : TYPE ASPAS 'RUNWAY' ASPAS;

end_runwaynode : 'end=' ASPAS end_attr_values ASPAS ; 

/* GLIDESLOPE NODE */
glideslope_node : STARTNODE GLIDESLOPE glideslope_attr ENDNODE;

glideslope_attr : lat_attr | lon_attr | alt_attr | pitch_vasi | range_ils;

/* DME NODE */
dme_node : STARTNODE DME dme_attr ENDNODE;

dme_attr : lat_attr | lon_attr | alt_attr | range_ils;

/* VISUAL_MODEL NODE */
visualmodel_node : VISUALMODEL visualmodel_attr CLOSE_TAG biasxyz_node CLOSE_VISUALMODEL;

visualmodel_attr : heading_attr | imagecomplexity_visualmodel | name_visualmodel | instanceid_visualmodel;

imagecomplexity_visualmodel : 'imageComplexity=' ASPAS imagecomplexity_visualmodel_values ASPAS;
imagecomplexity_visualmodel_values : 'VERY_SPARSE' | 'SPARSE' | 'NORMAL' | 'DENSE' | 'VERY_DENSE';

name_visualmodel : 'name=' ASPAS name_visualmodel_values ASPAS;
name_visualmodel_values : STRING '-' STRING '-' STRING '-' STRING '-' STRING;

instanceid_visualmodel : 'instanceId=' ASPAS instanceid_visualmodel_values ASPAS;
instanceid_visualmodel_values : STRING '-' STRING '-' STRING '-' STRING '-' STRING;

/* BIAS_XYZ NODE */
biasxyz_node : STARTNODE BIASXYZ bias_attr ENDNODE;

bias_attr : biasX | biasY | biasZ;

biasX : 'biasX=' ASPAS NUM ASPAS;

biasY : 'biasY=' ASPAS NUM ASPAS;

biasZ : 'biasY=' ASPAS NUM ASPAS;


/* RUNWAYALIAS NODE */
runwayalias_node : STARTNODE RUNWAYALIAS runwayalias_attr{2} ENDNODE;

runwayalias_attr : 'number=' ASPAS runway_number ASPAS 
                   'designator=' ASPAS designator_values ASPAS
                   ;

/* VERTEX NODE */
vertex_node : STARTNODE VERTEX vertex_attr* ENDNODE;

vertex_attr : biasX | biasZ | lon_attr | lat_attr;


/* WAYPOINT NODE */
waypoint_node : WAYPOINT waypoint_attr CLOSE_TAG route_node* CLOSE_WAYPOINT;

waypoint_attr : lat_attr | lon_attr | waypointtype_waypoint | magvar_attr | waypointregion_waypoint | waypointident_waypoint;

waypointtype_waypoint : 'waypointType=' ASPAS waypointtype_waypoint_values ASPAS;
waypointtype_waypoint_values : 'NAMED' | 'UNNAMED' | 'VOR' | 'NDB' | 'OFF_ROUTE' | 'IAF' | 'FAF';

waypointregion_waypoint : 'waypointRegion=' ASPAS STRING ASPAS; /* falta semantica */

waypointident_waypoint : 'waypointIdent=' ASPAS STRING ASPAS; /* faltas semantica */

/* ROUTE NODE */
route_node : ROUTE route_attr* CLOSE_TAG route_nodes* CLOSE_ROUTE;

route_nodes : previous_node | next_node;

route_attr : routetype | name_route;

routetype : 'routeType=' ASPAS routetype_values ASPAS;
routetype_values : 'VICTOR' | 'JET' | 'BOTH';

name_route : 'name=' ASPAS STRING ASPAS; /* falta semantica */

/* PREVIOUS NODE */
previous_node : STARTNODE PREVIOUS previous_attr* ENDNODE;

previous_attr : waypointtype_waypoint | waypointregion_waypoint | waypointident_waypoint | altitudeMinimum_attr;

altitudeMinimum_attr : 'altitudeMinimum=' ASPAS NUM '.' NUM ASPAS; /* falta semantica */

/* NEXT NODE */
next_node : STARTNODE NEXT next_attr* ENDNODE;

next_attr : waypointtype_waypoint | waypointregion_waypoint | waypointident_waypoint | altitudeMinimum_attr;


/* HELIPAD NODE*/
helipad_node : STARTNODE 'Helipad ' lat_attr lon_attr alt_attr surface_attr heading_attr length_helipad width_helipad type_helipad closed_helipad? transparent_helipad? red_helipad? green_helipad? blue_helipad? ENDNODE;

length_helipad : 'length=' NUM '.' NUM ('M'|'F')? ;

width_helipad : 'width=' NUM '.' NUM ('M'|'F')? ;

type_helipad : 'type=' type_helipad_values ;
type_helipad_values : 'NONE'|'CIRCLE'|'H'|'MEDICAL'|'SQUARE';

closed_helipad : 'closed=' boolean_value;

transparent_helipad : 'transparent= ' boolean_value;

red_helipad : 'red=' NUM; /*FALTA SEMANTICA*/

green_helipad : 'green=' NUM; /*FALTA SEMANTICA*/

blue_helipad : 'blue=' NUM; /*FALTA SEMANTICA*/


/* TAXiWAY_POINT NODE */
taxiwaypoint_node : STARTNODE TAXIWAYPOINT taxiwaypoint_attr* ENDNODE;

taxiwaypoint_attr: index_taxiway | type_taxiway | orientation_taxiway | lat_attr | lon_attr | biasX | biasZ;

index_taxiway : 'index=' ASPAS NUM ASPAS; /* falta semantica */

type_taxiway : TYPE ASPAS type_taxiway_values ASPAS;
type_taxiway_values : 'NORMAL' | 'HOLD_SHORT' | 'ILS_HOLD_SHORT' | 'HOLD_SHORT_NO_DRAW' | 'ILS_HOLD_SHORT_NO_DRAW';

orientation_taxiway : 'orientation=' ASPAS orientation_taxiway_values ASPAS;
orientation_taxiway_values : 'FORWARD' | 'REVERSE';

/*TAXIWAYPARKING NODE  */
taxiwayparking_node : STARTNODE TAXIWAYPARKING taxiwayparking_attr* ENDNODE;

taxiwayparking_attr : index_taxiway | lat_attr | lon_attr | biasX | biasZ | heading_attr | radius_taxiway | type_parking | name_parking | number_parking | airlinecodes_parking | pushback_parking | teeoffset1_parking | teeoffset2_parking | teeoffset3_parking  | teeoffset4_parking;

radius_taxiway : 'radius=' ASPAS NUM '.' NUM ASPAS; /* semantica */

type_parking : TYPE ASPAS type_parking_values ASPAS;
type_parking_values : 'NONE' | 'DOCK_GA' | 'FUEL' | 'GATE_HEAVY' | 'GATE_MEDIUM' | 'GATE_SMALL' | 'RAMP_CARGO' | 'RAMP_GA' | 'RAMP_GA_LARGE' | 'RAMP_GA_MEDIUM' | 'RAMP_GA_SMALL' | 'RAMP_MIL_CARGO' | 'RAMP_MIL_COMBAT' | 'VEHICLE' ;

name_parking : 'name=' ASPAS name_parking_values ASPAS;
name_parking_values : 'PARKING' | 'DOCK' | 'GATE' | 'GATE_UPPER' | 'NONE' | 'N_PARKING' | 'NE_PARKING' | 'NW_PARKING' | 'SE_PARKING' | 'SW_PARKING' | 'W_PARKING' | 'E_PARKING';

number_parking : 'number=' ASPAS NUM ASPAS; /* semantica */

airlinecodes_parking : 'airlineCodes=' ASPAS STRING ASPAS; /* semantica */

pushback_parking : 'pushBack=' ASPAS NUM ASPAS; /* ver documentação */

teeoffset1_parking : 'teeOffset1=' ASPAS NUM '.' NUM; /* semantica */

teeoffset2_parking : 'teeOffset2=' ASPAS NUM '.' NUM; /* semantica */

teeoffset3_parking : 'teeOffset3=' ASPAS NUM '.' NUM; /* semantica */

teeoffset4_parking : 'teeOffset4=' ASPAS NUM '.' NUM; /* semantica */

/* TAXINAME NODE */
taxiname_node : STARTNODE TAXINAME taxiname_attr* ENDNODE;

taxiname_attr : index_taxiname | name_taxiname;

index_taxiname : 'index=' ASPAS NUM ASPAS; /* semantica */

name_taxiname : 'name=' ASPAS STRING ASPAS; /* semantica */

/* TAXIWAY PATH NODE */
taxiwaypath_node : STARTNODE TAXIWAYPATH taxiwaypath_attr* ENDNODE;

taxiwaypath_attr : type_taxiwaypath | start_taxiwaypath | end_taxiwaypath | width_attr | weightlimit_taxiwaypath | surface_attr | drawsurface | drawdetail | centerline_taxiwaypath | centerlinelighted_taxiwaypath | leftedge_taxiwaypath | leftedgelighted_taxiwaypath | rightedge_taxiwaypath | rightedgelighted_taxiwaypath | runway_number | designator | name_taxiwaypath;

type_taxiwaypath : TYPE ASPAS type_taxiwaypath_values ASPAS;
type_taxiwaypath_values : 'RUNWAY' | 'PARKING' | 'TAXI' | 'PATH' | 'CLOSED' | 'VEHICLE';

start_taxiwaypath : 'start=' ASPAS NUM ASPAS; /* semantica */

end_taxiwaypath : 'end=' ASPAS NUM ASPAS; /* semantica */

weightlimit_taxiwaypath : 'weightLimit=' ASPAS NUM '.' NUM ASPAS;

centerline_taxiwaypath : 'centerLine=' ASPAS boolean_value ASPAS; /* semantica */

centerlinelighted_taxiwaypath : 'centerLineLighted' ASPAS boolean_value ASPAS; /* semantica */

leftedge_taxiwaypath : 'leftEdge=' ASPAS boolean_value ASPAS; /* semantica */

leftedgelighted_taxiwaypath : 'leftEdgeLighted=' ASPAS boolean_value ASPAS; /* semantica */

rightedge_taxiwaypath : 'rightEdge=' ASPAS boolean_value ASPAS; /* semantica */

rightedgelighted_taxiwaypath : 'rightEdgeLighted=' ASPAS boolean_value ASPAS; /* semantica */

name_taxiwaypath : 'name=' ASPAS STRING ASPAS; /* semantica */

drawsurface : 'drawSurface=' ASPAS boolean_value ASPAS;

drawdetail : 'drawDetail=' ASPAS boolean_value ASPAS;

designator : 'designator=' ASPAS designator_values ASPAS;