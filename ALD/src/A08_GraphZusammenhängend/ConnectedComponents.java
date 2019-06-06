package A08_GraphZusammenhängend;

import basisAlgorithmen.Graph;
import basisAlgorithmen.WeightedEdge;

import java.util.LinkedList;

public class ConnectedComponents {
	
	/**
	 * Retourniert die Anzahl der zusammenhängenden Komponenten eines Graphen
	 * @param g zu prüfender Graph
	 * @return Anzahl der Komponenten
	 */
	public int getNumberOfComponents(Graph g) {
		boolean[] visited = new boolean[g.numVertices()];
		int i, counter = 0;

		while ((i = findFirstUnvisitedVertex(visited)) != -1)
		{
			walk(g, visited, i);
			++counter;
		}


		return counter;
	}

	private int findFirstUnvisitedVertex(boolean[] visited)
	{
		for (int i = 0; i < visited.length; i++)
		{
			if (visited[i] == false)
				return i;
		}

		return -1;
	}

	private void walk(Graph g, boolean[] visited, int start)
	{
		LinkedList<WeightedEdge> edges = new LinkedList<>(g.getEdges(start));
		java.util.Stack<Integer> vertices = new java.util.Stack<>();

		visited[start] = true;

		while (!edges.isEmpty())
		{
			WeightedEdge e = edges.remove();
			if (visited[e.to_vertex] == true)
				continue;

			vertices.push(e.to_vertex);
		}

		while (!vertices.empty())
		{
			walk(g, visited, vertices.pop());
		}
	}

}
