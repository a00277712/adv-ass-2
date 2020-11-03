package orchestration;

import models.Route;
import models.Town;

import java.util.*;

public class DijkstraPathAlgorithm {
    public static void calculateShortestPathFromSource(Town source) {
        // distance to start is always going to be 0
        source.setDistance(0);

        //create lists to track which towns have been calculated and which haven't
        List<Town> settledTowns = new LinkedList<>();
        List<Town> unsettledTowns = new LinkedList<>();

        // add start(athlone) to unsettled towns
        unsettledTowns.add(source);

        // loop until all towns calculated
        while (unsettledTowns.size() != 0) {
            // get the closest town, first loop will be source
            Town currentTown = getLowestDistanceTown(unsettledTowns);
            // remove the closest town from unsettled towns
            unsettledTowns.remove(currentTown);
            //for each route out of current town if haven't already calculated best route
            for (Route route: currentTown.getRoutes()) {
                Town adjacentTown = route.getTown();
                Integer distance = route.getDistance();
                if (!settledTowns.contains(adjacentTown)) {
                    calculateMinimumDistance(adjacentTown, distance, currentTown);
                    // add all adjacent towns that haven't been settled to list as they show up
                    if(!unsettledTowns.contains(adjacentTown)){
                        unsettledTowns.add(adjacentTown);
                    }
                }
            }
            settledTowns.add(currentTown);
        }
        return;
    }

    private static Town getLowestDistanceTown(List<Town> unsettledTowns) {
        Town lowestDistanceTown = null;
        int lowestDistance = Integer.MAX_VALUE;
        // get the unsettled town with the lowest distance
        for (Town town: unsettledTowns) {
            int townDistance = town.getDistance();
            if (townDistance < lowestDistance) {
                lowestDistance = townDistance;
                lowestDistanceTown = town;
            }
        }
        return lowestDistanceTown;
    }

    // town going to, distance of current route, town coming from
    private static void calculateMinimumDistance(Town evaluationTown, Integer distance, Town sourceTown) {
        // get distance from start to current town
        Integer sourceDistance = sourceTown.getDistance();
        // if distance to current town plus distance to destination is less then old route replace it
        if (sourceDistance + distance < evaluationTown.getDistance()) {
            evaluationTown.setDistance(sourceDistance + distance);
            LinkedList<Town> shortestPath = new LinkedList<>(sourceTown.getShortestPath());
            shortestPath.add(sourceTown);
            evaluationTown.setShortestPath(shortestPath);
        }
    }
}
