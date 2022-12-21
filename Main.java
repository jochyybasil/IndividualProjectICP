import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader routesReader;
    static BufferedReader airportsReader;

    public static void main(String[] args) {
        try {
            routesReader = new BufferedReader(new FileReader("routes.csv"));
            airportsReader = new BufferedReader(new FileReader("airports.csv"));

            // reading airports file
            String airportLine = airportsReader.readLine();
            while (airportLine != null) {
                String[] airport = airportLine.split(",");
                String airportLocation = airport[2] + ", " + airport[3];
                Airport.airportCodeLocation.put(airport[4], airportLocation);

                
                ArrayList<String> airportCodes = Airport.cityAirportsMap.get(airportLocation);
                if (airportCodes != null) {
                    airportCodes.add(airport[4]);
                    Airport.cityAirportsMap.put(airportLocation, airportCodes);
                } else {
                    ArrayList<String> newAirportIDs = new ArrayList<>();
                    newAirportIDs.add(airport[4]);
                    Airport.cityAirportsMap.put(airportLocation, newAirportIDs);
                }
                airportLine = airportsReader.readLine();
            }
            airportsReader.close();

            // reading routes file
            String routeLine = routesReader.readLine();
            while (routeLine != null) {
                String[] routee = routeLine.split(",");
                Route route =
                        new Route(
                                routee[0],
                                routee[1],
                                routee[4],
                                Integer.parseInt(routee[7]));

                
                ArrayList<Route> tempRoutesList = Route.routesMap.get(routee[2]);
                if (tempRoutesList == null) {
                    ArrayList<Route> routesList = new ArrayList<>();
                    routesList.add(route);
                    Route.routesMap.put(routee[2], routesList);
                } else {
                    tempRoutesList.add(route);
                    Route.routesMap.put(routee[2], tempRoutesList);
                }
                routeLine = routesReader.readLine();
            }
            routesReader.close();


            // use Stringbuilder for output filename
            StringBuilder inputFileName = new StringBuilder("accra-winnpeg.txt");
            BufferedReader inputFileReader =
                    new BufferedReader(new FileReader(String.valueOf(inputFileName)));
            StringBuilder outputFileName =
                    new StringBuilder(
                            inputFileName.delete(
                                    inputFileName.length() - 4, inputFileName.length()));
            outputFileName.append(".txt");

            File outputFile = new File(inputFileName + "_output.txt");
            PrintWriter writerObj = new PrintWriter(outputFile);
            String sourceLocation = inputFileReader.readLine();
            String destinationLocation = inputFileReader.readLine();

            ArrayList<String> SolutionPath = bfsAlgorithm.breadthFirstSearch(sourceLocation, destinationLocation);
        
            if (SolutionPath == null) {
                writerObj.write("Cannot any flight from" + sourceLocation +"to" + destinationLocation);

            } else {
                for (int i = 0; i < SolutionPath.size() - 1; i++) {
                    writerObj.println(SolutionPath.get(i));
                }
                String totalNumberOfStops = SolutionPath.get(SolutionPath.size() - 1);
                writerObj.println("Total stops: " + totalNumberOfStops);
            }
            writerObj.close();
            inputFileReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
