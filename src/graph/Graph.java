package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author vtupe
 * Graph class implementing Graph with shortest path algorithm and BFS traversal
 */
public class Graph {

	private final int MAX_VERTS=20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue<Integer> q;
	private int dist[];
	private Set<Integer> visited;
	private Set<Integer> unVisited;

	public Graph(int n){

		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVerts=0;
		
		q = new LinkedList<Integer>();

		for(int j=0; j<MAX_VERTS; j++){
			for(int k=0; k<MAX_VERTS; k++){

				if(j==k)
					adjMat[j][k]=0;
				else
					adjMat[j][k]=Integer.MAX_VALUE;
			}
		}
	}

	public void addVertex(int label){

		vertexList[nVerts++] = new Vertex(label);
	}

	public void edge(int start, int end){

		adjMat[start][end]=1;
	}

	public void displayVertex(int v){

		System.out.println("Vertex : "+ vertexList[v].label);
	}

	public int getAdjUnvisitedVertex(int v){

		for(int j=0; j<nVerts; j++){

			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
				return j;
		}
		return -1;
	}

	/**
	 * Breadth First search graph traversal algorithm to traverse the graph
	 * 
	 */
	public void bfs(){

		vertexList[0].wasVisited = true;
		displayVertex(0);
		q.add(0);
		int v2;

		while(!q.isEmpty()){

			int v1= (int) q.remove();

			while((v2 = getAdjUnvisitedVertex(v1)) != -1){

				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				q.add(v2);
			}
		}
	}

	/**
	 * Dijkstra's Shortest path algorithm to find shortest path between two nodes.
	 * @param source - source node from which shortest path has to be find
	 * @param destination - destination node up to which shortest path has to be find
	 * 
	 */
	public void shortestPath(int source, int destination)
	{
		dist = new int[nVerts];
		visited = new HashSet<Integer>();
		unVisited = new HashSet<Integer>();

		int candidateNode;

		for (int i = 0; i < nVerts; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}

		unVisited.add(source);
		dist[source] = 0;
		while (!unVisited.isEmpty())
		{
			candidateNode = getNodeWithMinimumDistanceFromUnVisited();
			unVisited.remove(candidateNode);
			visited.add(candidateNode);
			updateNeighboursDistance(candidateNode);
		}

		for (int i = 0; i < dist.length - 1; i++)
		{
			if (i == destination)
				System.out.println("Shortest distance form  " +source + " to " + i + " is "+ dist[i]);
		}
	}


	private int getNodeWithMinimumDistanceFromUnVisited()
	{
		int min;
		int node = 0;

		Iterator<Integer> iterator = unVisited.iterator();
		node = iterator.next();
		min = dist[node];
		for (int i = 0; i < dist.length; i++)
		{
			if (unVisited.contains(i))
			{
				if (dist[i] <= min)
				{
					min = dist[i];
					node = i;
				}
			}
		}
		return node;
	}

	private void updateNeighboursDistance(int candidateNode)
	{
		int edgeDistance = -1;
		int newDistance = -1;

		for (int destNode = 0; destNode < nVerts; destNode++)
		{
			if (!visited.contains(destNode))
			{
				if (adjMat[candidateNode][destNode] != Integer.MAX_VALUE)
				{
					edgeDistance = adjMat[candidateNode][destNode];
					newDistance = dist[candidateNode] + edgeDistance;
					if (newDistance < dist[destNode])
					{
						dist[destNode] = newDistance;
					}
					unVisited.add(destNode);
				}
			}
		}
	}

}
