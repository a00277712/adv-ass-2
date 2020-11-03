package models;

import java.util.LinkedList;
import java.util.List;

public class Town {
    private String name;
    List<Route> routes = new LinkedList<>();

    private List<Town> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    public void addDestination(Town destination, int distance) {
        routes.add(new Route(destination, distance));
    }

    public Town(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder route
                = new StringBuilder();

        for (Town town: shortestPath) {
            route.append("->" + town.name);
        }
        return name + ": " + distance + ": " + route.toString() + "->" + name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Town> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Town> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
