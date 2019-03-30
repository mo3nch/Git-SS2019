package A05_Breitensuche;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breitensuche extends BaseTree<Integer> {

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {
		return performBreadthSearch(start, -1);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {
		return performBreadthSearch(start, level);
	}



	public List<Integer> performBreadthSearch(Node<Integer> start, int level)
	{
		List<Integer> result = new ArrayList<>();
		Queue<Node<Integer>> visited = new LinkedList<>();
		Node<Integer> current = null;

		visited.add(start);

		while (!visited.isEmpty())
		{
			current = visited.remove();
			current.calculateHeight(start);
			if (level == -1 ||
				current.getHeight() == level)
				result.add(current.getValue());

			if (current.getLeft() != null)
				visited.add(current.getLeft());

			if (current.getRight() != null)
				visited.add(current.getRight());
		}

		return result;
	}
}
