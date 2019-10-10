package fsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class Digraph<V> {

	final static Logger logger = Logger.getLogger(Digraph.class);

	public static class Edge<V> {
		private V vertex;
		private String label;

		public Edge(V v, String c) {
			vertex = v;
			label = c;
		}

		public String getLabel() {
			return label;
		}

		public V getVertex() {
			return vertex;
		}

		@Override
		public String toString() {
			return "Edge [vertex=" + vertex + ", label=" + label + "]";
		}

	}

	/**
	 * A Map is used to map each vertex to its list of adjacent vertices.
	 */

	private Map<V, List<Edge<V>>> neighbors = new HashMap<V, List<Edge<V>>>();

	private int nr_edges;

	/**
	 * Add a vertex to the graph. Nothing happens if vertex is already in graph.
	 */
	public void add(V vertex) {
		if (neighbors.containsKey(vertex))
			return;
		neighbors.put(vertex, new ArrayList<Edge<V>>());
	}

	public String getInitialVertex() {
		for (Entry<V, List<Edge<V>>> entry : neighbors.entrySet()) {
			String state = (String) entry.getKey();
			String[] asd = state.split(";");
			boolean var = true;
			for (String character : asd) {
				if (!character.equals(asd[0]) && !character.equals("U")) {
					var = false;
					break;
				}
			}
			if (var) {
				return state;
			}
		}

		return "";
	}

	/**
	 * Add an edge to the graph; if either vertex does not exist, it's added. This
	 * implementation allows the creation of multi-edges and self-loops.
	 */
	public void add(V from, V to, String label) {

		List<String> currentLabels = getLabel(from, to);

		if (!currentLabels.isEmpty() && currentLabels.contains(label))
			return;

		this.add(from);
		this.add(to);
		neighbors.get(from).add(new Edge<V>(to, label));
	}

	/**
	 * True iff graph contains vertex.
	 */
	public boolean contains(V vertex) {
		return neighbors.containsKey(vertex);
	}

	/**
	 * Check first if the label exists in the edge
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public List<String> getLabel(V from, V to) {
		List<String> labelList = new ArrayList<>();
		try {
			for (Edge<V> e : neighbors.get(from)) {
				if (e.vertex.equals(to))
					labelList.add(e.label);
			}
		} catch (NullPointerException e) {
			return labelList;
		}

		return labelList;
	}

	public Entry<V, List<Edge<V>>> getVertex(String vertexLabel) {
		for (Entry<V, List<Edge<V>>> entry : neighbors.entrySet()) {
			String state = (String) entry.getKey();
			if (state.equals(vertexLabel))
				return entry;
		}
		return null;
	}

	public Map<V, List<Edge<V>>> getNeighbors() {
		return neighbors;
	}

	public int getNumberOfEdges() {
		int sum = 0;
		for (List<Edge<V>> outBounds : neighbors.values()) {
			sum += outBounds.size();
		}
		return sum;
	}

	public List<V> inboundNeighbors(V inboundVertex) {
		List<V> inList = new ArrayList<V>();
		for (V to : neighbors.keySet()) {
			for (Edge<?> e : neighbors.get(to))
				if (e.vertex.equals(inboundVertex))
					inList.add(to);
		}
		return inList;
	}

	public int inDegree(V vertex) {
		return inboundNeighbors(vertex).size();
	}

	public boolean isEdge(V from, V to) {
		for (Edge<V> e : neighbors.get(from)) {
			if (e.vertex.equals(to))
				return true;
		}
		return false;
	}

	public List<V> outboundNeighbors(V vertex) {
		List<V> list = new ArrayList<V>();
		try {
			for (Edge<V> e : neighbors.get(vertex))
				list.add(e.vertex);
		} catch (NullPointerException e) {
			return list;
		}
		return list;
	}

	public int outDegree(int vertex) {
		return neighbors.get(vertex).size();
	}

	/**
	 * String representation of graph.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (V v : neighbors.keySet())
			s.append("\n    " + v + " -> " + neighbors.get(v));
		return s.toString();
	}
}