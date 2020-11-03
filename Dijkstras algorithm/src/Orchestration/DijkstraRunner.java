package Orchestration;

import Models.Town;
import Models.Westmeath;

public class DijkstraRunner {
    public static void main(String[] args) {
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

        Westmeath westmeath = new Westmeath();

        westmeath.addTown(athlone);
        westmeath.addTown(ballinasloe);
        westmeath.addTown(tubberclare);
        westmeath.addTown(horseleap);
        westmeath.addTown(mulingar);
        westmeath.addTown(kinnegrad);
        westmeath.addTown(tang);

        westmeath = DijkstraAlgorithm.calculateShortestPathFromSource(westmeath, athlone);

        for (Town town: westmeath.getTowns()) {
            System.out.println(town.toString());
        }
    }
}
