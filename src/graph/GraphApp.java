package graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author vtupe
 *GraphApp class is driver class for Graph application to find shortest path between two nodes.
 *
 */
public class GraphApp {

	public static void main(String args[]){

		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the number of vertices");

			int n = Integer.parseInt(in.nextLine());

			Graph g = new Graph(n);

			for(int i=0; i<n; i++){
				g.addVertex(i);
			}

			for(int i=0; i<n; i++){

				String s= in.nextLine();
				String x[]= s.split(" ");

				for(int j=1; j<x.length; j++){
					g.edge(i, Integer.parseInt(x[j]));
				}
			}

			// for traversing graph using Breadth first search traversal method
			//g.bfs();

			in.nextLine();

			for(int i=0; i<3; i++){

				String s= in.nextLine();
				String x[]= s.split(" ");
				g.shortestPath(Integer.parseInt(x[0]), Integer.parseInt(x[1]));
			}
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
}
