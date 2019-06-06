package A06_Tiefensuche;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import A01_Stack.Stack;
import A01_Stack.StackEmptyException;
import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {

	@Override
	/**
	 * Sortierkriterium im Baum: Länge des Films
	 */
	protected int compare(Film a, Film b) {
		if (a.getLänge() > b.getLänge())
			return 1;
		else if (a.getLänge() < b.getLänge())
			return -1;

		return 0;
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node)
	{
		ArrayList<String> result = new ArrayList<>();

		if (node.getLeft() != null)
			result.addAll(getNodesInOrder(node.getLeft()));

		result.add(node.getValue().getTitel());

		if (node.getRight() != null)
			result.addAll(getNodesInOrder(node.getRight()));

		return result;
	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren Länge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale Länge des Spielfilms
	 * @param max Maximale Länge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {
		return getMinMaxPreOrder(getRoot(), min, max);
	}

	public List<String> getMinMaxPreOrder(Node<Film> node, double min, double max)
	{
		ArrayList<String> result = new ArrayList<>();

		if (node.getValue().getLänge() > min && node.getValue().getLänge() < max)
			result.add(node.getValue().getTitel());

		if (node.getLeft() != null)
			result.addAll(getMinMaxPreOrder(node.getLeft(), min, max));

		if (node.getRight() != null)
			result.addAll(getMinMaxPreOrder(node.getRight(), min, max));

		return result;
	}

}
