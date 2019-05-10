package A11_DijkstraDGShortestPath;
import java.util.List;


public interface Graph {

	public int numVertices();
	public boolean isDirected();
	public boolean hasEdge(int u, int v);
	public int getEdgeWeight(int u, int v);
	public void addEdge(int u, int v);
	public void addEdge(int u, int v, int weight);
	public void addEdge(int u, int v, int weight, boolean charge);
	public void removeEdge(int u, int v);
	public List<WeightedEdge> getEdges(int v);
}
