package Orchestration;

import Models.Town;
import Models.Westmeath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    public static Westmeath calculateShortestPathFromSource(Westmeath graph, Town source) {
        source.setDistance(0);

        Set<Town> settledTowns = new HashSet<>();
        Set<Town> unsettledTowns = new HashSet<>();

        unsettledTowns.add(source);

        while (unsettledTowns.size() != 0) {
            Town currentTown = getLowestDistanceTown(unsettledTowns);
            unsettledTowns.remove(currentTown);
            for (Map.Entry<Town, Integer> adjacencyPair:
                    currentTown.getAdjacentTowns().entrySet()) {
                Town adjacentTown = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledTowns.contains(adjacentTown)) {
                    calculateMinimumDistance(adjacentTown, edgeWeight, currentTown);
                    unsettledTowns.add(adjacentTown);
                }
            }
            settledTowns.add(currentTown);
        }
        return graph;
    }

    private static Town getLowestDistanceTown(Set < Town > unsettledTowns) {
        Town lowestDistanceTown = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Town town: unsettledTowns) {
            int townDistance = town.getDistance();
            if (townDistance < lowestDistance) {
                lowestDistance = townDistance;
                lowestDistanceTown = town;
            }
        }
        return lowestDistanceTown;
    }

    private static void calculateMinimumDistance(Town evaluationTown,
                                                 Integer edgeWeigh, Town sourceTown) {
        Integer sourceDistance = sourceTown.getDistance();
        if (sourceDistance + edgeWeigh < evaluationTown.getDistance()) {
            evaluationTown.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Town> shortestPath = new LinkedList<>(sourceTown.getShortestPath());
            shortestPath.add(sourceTown);
            evaluationTown.setShortestPath(shortestPath);
        }
    }
}
