package tests;

import models.Town;
import orchestration.DijkstraPathAlgorithm;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraPathAlgorithmTest {

    @org.junit.jupiter.api.Test
    void calculateShortestPathFromSource() {

        Town athlone = new Town("Athlone");
        Town ballinasloe = new Town("Ballinasloe");
        Town tubberclare = new Town("Tubberclare");
        Town horseleap = new Town("Horseleap");
        Town mulingar = new Town("Mulingar");
        Town kinnegrad = new Town("Kinnegrad");
        Town tang = new Town("Tang");

        athlone.addDestination(ballinasloe, 3);
        athlone.addDestination(tubberclare, 1);
        athlone.addDestination(horseleap, 5);
        athlone.addDestination(horseleap, 5);
        athlone.addDestination(mulingar, 3);

        ballinasloe.addDestination(kinnegrad, 4);

        tubberclare.addDestination(ballinasloe, 1);
        tubberclare.addDestination(kinnegrad, 4);

        horseleap.addDestination(tang, 2);

        mulingar.addDestination(tang, 2);
        mulingar.addDestination(horseleap, 1);

        kinnegrad.addDestination(tang, 3);

        DijkstraPathAlgorithm.calculateShortestPathFromSource(athlone);

        assertEquals(athlone.getDistance(), 0);
        assertEquals(ballinasloe.getDistance(), 2);
        assertEquals(tubberclare.getDistance(), 1);
        assertEquals(horseleap.getDistance(), 4);
        assertEquals(mulingar.getDistance(), 3);
        assertEquals(kinnegrad.getDistance(), 5);
        assertEquals(tang.getDistance(), 5);
    }
}