package Nodes;

/**
 * Created by André on 13/05/2015.
 */
public class Route {

    private String routeType;
    private String name;

    public Route(){
        this.routeType = null;
        this.name = null;
    }

    public void output(){
        System.out.println("===================================");
        System.out.println("========ROUTE -> attributes========");
        System.out.println("===================================");


        if(this.routeType != null){
            System.out.println("RouteType : " + this.routeType);
        }

        if(this.name != null){
            System.out.println("Name : " + this.name);
        }


        System.lineSeparator();
        System.lineSeparator();
    }

    public void setRouteType(String routeType) {
        routeType = routeType.replaceAll("^\"|\"$", "");
    }

    public void setName(String name) {
        this.name = name.replaceAll("^\"|\"$", "");

        if(this.name.length() > 8){
            this.name = null;
            throw new IllegalArgumentException("Name is out of bounds (8 char at maximum)");
        }
    }
}
