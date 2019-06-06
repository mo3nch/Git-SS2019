package A10_DijkstraPQShortestPath;

import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = Integer.MAX_VALUE; // Summen im Graph dürfen nie mehr ergeben
		}
	}

	/**
	 * Berechnet *alle* kürzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein Rückgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) {
		VertexHeap heap = new VertexHeap(graph.numVertices());

		for (int i = 0; i < graph.numVertices(); i++)
		{
			heap.insert(new Vertex(i, Integer.MAX_VALUE));
		}

		dist[from] = 0;
		pred[from] = -1;
		heap.setCost(from, 0);

		while (!heap.isEmpty())
		{
			Vertex current = heap.remove();

			List<WeightedEdge> edges = graph.getEdges(current.vertex);

			for (WeightedEdge e :
					edges)
			{
				int newCost = current.cost + e.weight;

				if (dist[e.to_vertex] > newCost)
				{
					dist[e.to_vertex] = newCost;
					pred[e.to_vertex] = current.vertex;
					heap.setCost(e.to_vertex, newCost);
				}
			}

		}

		return (dist[to] != Integer.MAX_VALUE);

//	protected boolean calculatePath(int from, int to) {
//
//		// TODO: IHRE IMPLEMENTIERUNG
//		VertexHeap heap = new VertexHeap(graph.numVertices());
//
//		// Heap initialisieren mit allen Knoten und der dazugehörigen entfernung (Hier noch 9999)
//		for (int i = 0; i < graph.numVertices(); i++) {
//			heap.insert(new Vertex(i, dist[i]));
//		}
//
//		// Ersten Knoten (from) initialisieren. Kein Vorgänger und Kosten 0.
//		super.pred[from] = -1;
//		dist[from] = 0;
//		heap.setCost(from, 0);
//
//		// solange Knoten im heap sind immer den "wichtigsten" auslesen
//		while (!heap.isEmpty()) {
//			Vertex cur = heap.remove();
//			// wenn der "wichtigste" unser Ziel war, sind wir fertig
//			if (cur.vertex == to) return true;
//
//			// Aus dem Graph die Nachbarn des Knoten auslesen
//			List<WeightedEdge> neighbours = graph.getEdges(cur.vertex);
//			// Für jeden nachbarn die Kosten ermitteln:
//			// Kosten zum aktuellen Knoten + Kosten (über Kantengewicht) zum nächsten Knoten
//			for (WeightedEdge neighbour : neighbours) {
//				int sumDist = cur.cost + neighbour.weight;
//
//				// Wenn die errechneten Kosten zum nächsten Knoten kleiner sind als die gespeicherten
//				// Kosten zu diesem (im Distanz Array) dann Kosten anpassen. Als vorgänger des nächsten Knoten
//				// den aktuellen eintragen (im Vorgäger Array). Kosten des nächsten Knoten im Heap anpassen
//				if (sumDist < dist[neighbour.to_vertex]) {
//					super.pred[neighbour.to_vertex] = cur.vertex;
//					dist[neighbour.to_vertex] = sumDist;
//					heap.setCost(neighbour.to_vertex, sumDist);
//				}
//			}
//		}
//
//		// Wenn die Kosten im Distanzarray kleiner dem Startwert sind, wurde ein Weg gefunden
//		return (dist[to] != 9999);
	}
}
