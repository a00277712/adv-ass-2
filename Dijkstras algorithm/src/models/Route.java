package models;

public class Route {
    // name of town route going to
    private Town town;
    // distance to the given town
    private int distance;

    public Route(Town town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public Town getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }
}
