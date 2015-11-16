package graph;

/**
 * @author vtupe
 *Vertex class represents and defines the Graph Vertex properties
 *
 */
public class Vertex {

	int label;
	boolean wasVisited;

	public Vertex(int label){
		this.label=label;
		wasVisited=false;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}


}
