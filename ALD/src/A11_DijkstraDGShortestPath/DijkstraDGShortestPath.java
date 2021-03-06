package A11_DijkstraDGShortestPath;

import java.util.List;

public class DijkstraDGShortestPath extends FindWay {
    private int[] dist;
    private boolean[] visited;

    public DijkstraDGShortestPath(Graph graph) {
        super(graph);
    }

    /**
     * Startentfernung initialisieren
     */
    protected void initPathSearch() {
        int numv = graph.numVertices();
        dist = new int[numv];
        visited = new boolean[numv];
        for (int i = 0; i < numv; i++) {
            dist[i] = 9999;        // Summen im Graph d�rfen nie mehr ergeben
        }
    }

    /**
     * Berechnet *alle* k�rzesten Wege ausgehend vom Startknoten
     *
     * @param from Startknoten
     */
    protected boolean calculatePath(int from, int to, boolean useChargeRoads) {
        dist[from] = 0;
        while (true) {
            int v = findNearestUnvisitedVertex();
            if (v == -1) {
                return (dist[to] != 9999);
            }
            visited[v] = true;
            List<WeightedEdge> edges = graph.getEdges(v);
            for (WeightedEdge we : edges) {
                if ((!useChargeRoads && !we.isCharge()) || useChargeRoads) {
                    int newcost = dist[v] + we.weight;
                    int tov = we.to_vertex;
                    if (newcost < dist[tov]) {
                        dist[tov] = newcost;
                        pred[tov] = v;

                    }

                }
            }
        }


    }

    private int findNearestUnvisitedVertex() {
        int min = 9999;
        int min_pos = -1;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min && !visited[i]) {
                min_pos = i;
                min = dist[i];
            }
        }
        return min_pos;
    }
}
