package A12_DijkstraLand;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {
		
		int[] pred = new int[g.numVertices()];
		int[] dist = new int[g.numVertices()];
	
		// TODO
		// alles einmal auf Anfang setzten
		// Die Distanz wird der h�chste Wert
		// pred wird mit -1 belegt - das ist nicht erlaubt
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		// f�r den Startpunkt wird eine Distanz von 0 festgelegt - weil man ja
		// dort startet
		dist[von] = 0;

		VertexHeap heap = new VertexHeap(g.numVertices());
		// Heap bef�llen; es werden neue WeightedEdges hinzugef�gt - diese
		// beinhalten zur zeit alle MAX_VALUE, au�er der start (0);
		// dadurch ist der ganz oben am Heap --> weil .insert() die .swim()
		// aufruft und dadurch der Heap sortiert wird

		for (int i = 0; i < dist.length; i++) {
			heap.insert(new WeightedEdge(i, dist[i]));
		}

		while (!heap.isEmpty())
		{
			// nimmst das oberste elemente vom heap --> hat den g
			WeightedEdge current = heap.remove();
			// es wird eine neue ArrayList mit allen Verbunden Knoten "Nachbarn"
			// mit der Methode .getEdges von der Klasse Graph mit dem index des
			// aktuellen vertexes geladen
			ArrayList<WeightedEdge> nachbarn = (ArrayList<WeightedEdge>) g.getEdges(current.vertex);
			// jeder nachbar wird angeschaut
			for (WeightedEdge nachbar : nachbarn)
			{
				if (heap.contains(nachbar))
				{
					// nimmt den aktuell gespeicherten Wert der Distanz und
					// addiert das Gewicht des aktuellen nachbarn dazu
					int distance = dist[current.vertex] + nachbar.weight;

					// z�hlt eins dazu, wenn man in ein anderes Land kommt
					if (!g.getLand(current.vertex).equals(g.getLand(nachbar.vertex)))
					{
						distance++;
					}

					// wenn die neu errechnete distance k�rzer ist, dann wird
					// der Wert im dist[] ersetzt.
					// dadurch ist immer der kleinste, bis jetzt bekannte, Weg
					// im dist[]
					if (distance < dist[nachbar.vertex])
					{
						dist[nachbar.vertex] = distance;
						// set the previous of the connected vertex in pred[] to
						// the current
						pred[nachbar.vertex] = current.vertex;
						// update the weight of the connected vertex in the
						// heap, so it can "swim" up
						heap.setPriority(nachbar.vertex, distance);
					}
				}
			}
		}


		// pred ausgeben
		for(int i=0; i<pred.length; i++) {
			System.out.println(i + " �ber " + pred[i]);
		}
		
		
		// Way ausgeben
		System.out.println();
		ArrayList<Integer> way = predToWay(pred, von, nach);
		return way;
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>(); 
		
		// TODO
		int i = to;
		way.add(to);

		// baut den weg r�ckw�rts auf - startet beim Ziel --> in pred[]
		while (i != from) {
			way.add(0, i);
			i = pred[i];
		}
		
		return way;
	}
	

}
