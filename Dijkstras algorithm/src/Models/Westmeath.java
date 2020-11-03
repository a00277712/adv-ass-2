package Models;

import java.util.HashSet;
import java.util.Set;

public class Westmeath {
    private Set<Town> towns = new HashSet<>();

    public void addTown(Town town) {
        towns.add(town);
    }

    public Set<Town> getTowns() {
        return towns;
    }
}
