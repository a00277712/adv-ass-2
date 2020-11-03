package Models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Town {
    private String name;

    private List<Town> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Town, Integer> adjacentTowns = new HashMap<>();

    public void addDestination(Town destination, int distance) {
        adjacentTowns.put(destination, distance);
    }

    public Town(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<Town, Integer> getAdjacentTowns() {
        return adjacentTowns;
    }

    public void setAdjacentTowns(Map<Town, Integer> adjacentNodes) {
        this.adjacentTowns = adjacentNodes;
    }
}
