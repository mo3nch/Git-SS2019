package A11_DijkstraDGShortestPath;

public class WeightedEdge {
	public int from_vertex;
	public int to_vertex;
	public int weight;
	private boolean charge;

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public WeightedEdge(int from_vertex, int to_vertex, int weight) {
		this.from_vertex = from_vertex;
		this.to_vertex = to_vertex;
		this.weight = weight;

	}

	public boolean isCharge() {
		return charge;
	}
}
