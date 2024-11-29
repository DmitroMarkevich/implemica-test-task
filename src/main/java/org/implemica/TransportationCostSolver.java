package org.implemica;

import java.util.*;

public class TransportationCostSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(getDefaultInputData());
        int testCaseCount = scanner.nextInt();

        for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
            // Reading the number of cities
            int cityCount = scanner.nextInt();
            Map<String, Integer> cityNameToIndexMap = new HashMap<>();

            // Initializing the graph for the cities
            List<List<Edge>> cityGraph = initializeGraph(cityCount, scanner, cityNameToIndexMap);

            int routeQueryCount = scanner.nextInt();
            processRouteQueries(scanner, cityNameToIndexMap, cityGraph, routeQueryCount);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Initializes the graph for the cities based on input data.
     *
     * @param cityCount          the number of cities
     * @param scanner            the scanner to read input data
     * @param cityNameToIndexMap a map that stores city names and their respective indices
     * @return a list of lists representing the graph where each city has a list of its neighbors and travel costs
     */
    private static List<List<Edge>> initializeGraph(int cityCount, Scanner scanner, Map<String, Integer> cityNameToIndexMap) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int cityIndex = 0; cityIndex < cityCount; cityIndex++) {
            String cityName = scanner.next();
            cityNameToIndexMap.put(cityName, cityIndex);
            graph.add(readCityConnections(scanner)); // Reading the city's neighbors and their travel costs
        }
        return graph;
    }

    /**
     * Reads the connections (neighbors and travel costs) of a city.
     *
     * @param scanner the scanner to read input data
     * @return a list of edges representing the city's neighbors and their travel costs
     */
    private static List<Edge> readCityConnections(Scanner scanner) {
        int neighborCount = scanner.nextInt();
        List<Edge> connections = new ArrayList<>();
        for (int i = 0; i < neighborCount; i++) {
            int neighborIndex = scanner.nextInt() - 1;
            int travelCost = scanner.nextInt();
            connections.add(new Edge(neighborIndex, travelCost));
        }
        return connections;
    }

    /**
     * Processes the route queries by calculating the shortest path cost between two cities.
     *
     * @param scanner            the scanner to read input data
     * @param cityNameToIndexMap a map that stores city names and their respective indices
     * @param graph              the graph representing the cities and their connections
     * @param routeQueryCount    the number of route queries
     */
    private static void processRouteQueries(Scanner scanner, Map<String, Integer> cityNameToIndexMap, List<List<Edge>> graph, int routeQueryCount) {
        // For each route query, calculate the shortest path cost
        for (int queryIndex = 0; queryIndex < routeQueryCount; queryIndex++) {
            String sourceCity = scanner.next();
            String destinationCity = scanner.next();
            // Finding the shortest path from source to destination
            int shortestPathCost = calculateShortestPath(graph, cityNameToIndexMap.get(sourceCity), cityNameToIndexMap.get(destinationCity));
            System.out.println(shortestPathCost);
        }
    }

    /**
     * Calculates the shortest path from the source city to the destination city using Dijkstra's algorithm.
     *
     * @param graph           the graph representing the cities and their connections
     * @param sourceNode      the index of the source city
     * @param destinationNode the index of the destination city
     * @return the minimum cost to travel from the source city to the destination city
     */
    private static int calculateShortestPath(List<List<Edge>> graph, int sourceNode, int destinationNode) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE); // Initializing distances to infinity
        distance[sourceNode] = 0; // The distance to the source city is 0

        // Priority queue to choose the next city with the smallest distance
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        priorityQueue.offer(new Edge(sourceNode, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentNode = currentEdge.target;

            // If we have reached the destination city, return the cost
            if (currentNode == destinationNode) {
                return distance[destinationNode];
            }

            for (Edge neighborEdge : graph.get(currentNode)) {
                int updatedDistance = distance[currentNode] + neighborEdge.cost;
                if (updatedDistance < distance[neighborEdge.target]) {
                    distance[neighborEdge.target] = updatedDistance;
                    priorityQueue.offer(new Edge(neighborEdge.target, updatedDistance));
                }
            }
        }

        // If no path exists, return the distance (infinity)
        return distance[destinationNode];
    }

    /**
     * Provides the default input data for the program to use (taken from the example).
     *
     * @return a string containing the default input data
     */
    private static String getDefaultInputData() {
        return """
                1
                4
                gdansk
                2
                2 1
                3 3
                bydgoszcz
                3
                1 1
                3 1
                4 4
                torun
                3
                1 3
                2 1
                4 1
                warszawa
                2
                2 4
                3 1
                2
                gdansk warszawa
                bydgoszcz warszawa
                """;
    }

    /**
     * A record that represents an edge in the graph.
     * It contains the target city index and the cost to travel to that city.
     */
    private record Edge(int target, int cost) {
    }
}