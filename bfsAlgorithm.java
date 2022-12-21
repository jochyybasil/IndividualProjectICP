import java.util.*;

public class bfsAlgorithm {
    

        /**
     * The method takes in a source and destination and returns a list of all possible routes an
     * from the source to the destination
     *
     * @param sourceLocation city and country
     * @param destinationLocation city and country
     * @return an ArrayList of Strings.
     */
    public static ArrayList<String> breadthFirstSearch(String sourceLocation, String destinationLocation) {
        Queue<Node> frontier = new ArrayDeque<>();
        Set<String> exploredRoutes = new HashSet<>();
        ArrayList<String> airportCodes = Airport.cityAirportsMap.get(sourceLocation);
        for (String airportCode : airportCodes) {
            frontier.add(new Node(null, airportCode, 0, null));
        }
        while (frontier.size() > 0) {
            Node node = frontier.remove();
            exploredRoutes.add(node.getAirportCode());
            ArrayList<Route> successorStates = Route.routesMap.get(node.getAirportCode());
            if (successorStates != null) {
                for (Route successorState : successorStates) {
                    Node child =
                            new Node(
                                    node,
                                    successorState.getDestinationAirportCode(),
                                    successorState.getStops(),
                                    successorState.getAirlineCode());
                    String destinationCityAndCountry =
                            Airport.airportCodeLocation.get(child.getAirportCode());
                    if (!frontier.contains(child)
                            && !exploredRoutes.contains(child.getAirportCode())) {
                        if (destinationCityAndCountry != null) {
                            if (destinationCityAndCountry.equals(destinationLocation)) {
                                return child.solutionPath();
                            }
                        }
                        frontier.add(child);
                    }
                }
            }
        }
        return null;
    }
}
