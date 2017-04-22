package com.learnbycoding.shortestPath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DijsktraMinPQandAdjacencyList {

	// A class to represent a node in adjacency list
	class AdjListNode
	{
	    int dest;
	    int weight;
	};
	
	AdjListNode head;
	
	// A class to represent a graph. A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices in graph)
	class  Graph
	{
	    int V;
	    List<AdjListNode>[] array;
	};
	
	// A utility function to create a new adjacency list node
	private AdjListNode newAdjListNode(int dest, int weight)
	{
	     AdjListNode newNode = new AdjListNode();
	     newNode.dest = dest;
	     newNode.weight = weight;
	    return newNode;
	}
	
	// A utility function that creates a graph of V vertices
	private Graph createGraph(int V)
	{
	     Graph graph = new Graph();
	     graph.V = V;
	 
	    // Create an array of adjacency lists. Size of array will be V
	    graph.array = new LinkedList[V];
	 
	     // Initialize each adjacency list as empty by making head as NULL
	    for (int i = 0; i < V; ++i)
	        graph.array[i] = new LinkedList<DijsktraMinPQandAdjacencyList.AdjListNode>();
	 
	    return graph;
	}
	
	// Adds an edge to an undirected graph
	void addEdge(Graph graph, int src, int dest, int weight)
	{
	    // Add an edge from src to dest.  A new node is added to the adjacency
	    // list of src.  The node is added at the begining
	    AdjListNode newNode = newAdjListNode(dest, weight);
	    graph.array[src].add(newNode);
	     
	    // Since graph is undirected, add an edge from dest to src also
	    newNode = newAdjListNode(src, weight);
	    graph.array[dest].add(newNode);
	}
	

	// class to represent a min heap node
	class MinHeapNode
	{
	    int  v;
	    int dist;
	};
	 
	// Structure to represent a min heap
	class MinHeap
	{
	    int size;      // Number of heap nodes present currently
	    int capacity;  // Capacity of min heap
	    int[] pos;       // This is needed for decreaseKey()
	    MinHeapNode[] array;
	};
	
	// A utility function to create a new Min Heap Node
	private MinHeapNode newMinHeapNode(int v, int dist)
	{
	    MinHeapNode minHeapNode =new MinHeapNode();
	    minHeapNode.v = v;
	    minHeapNode.dist = dist;
	    return minHeapNode;
	}
	 
	// A utility function to create a Min Heap
	private MinHeap createMinHeap(int capacity)
	{
	    MinHeap minHeap = new MinHeap();
	    minHeap.pos = new int[capacity];
	    minHeap.size = 0;
	    minHeap.capacity = capacity;
	    minHeap.array = new MinHeapNode[capacity];
	    return minHeap;
	}
	 
	// A utility function to swap two nodes of min heap. Needed for min heapify
	void swapMinHeapNode( MinHeapNode a,  MinHeapNode b)
	{
	    MinHeapNode t = a;
	    a = b;
	    b = t;
	}
	
	// A standard function to heapify at given idx
	// This function also updates position of nodes when they are swapped.
	// Position is needed for decreaseKey()
	void minHeapify(MinHeap minHeap, int idx)
	{
	    int smallest, left, right;
	    smallest = idx;
	    left = 2 * idx + 1;
	    right = 2 * idx + 2;
	 
	    if (left < minHeap.size &&
	        minHeap.array[left].dist < minHeap.array[smallest].dist )
	      smallest = left;
	 
	    if (right < minHeap.size &&
	        minHeap.array[right].dist < minHeap.array[smallest].dist )
	      smallest = right;
	 
	    if (smallest != idx)
	    {
	        // The nodes to be swapped in min heap
	        MinHeapNode smallestNode = minHeap.array[smallest];
	        MinHeapNode idxNode = minHeap.array[idx];
	 
	        // Swap positions
	        minHeap.pos[smallestNode.v] = idx;
	        minHeap.pos[idxNode.v] = smallest;
	 
	        // Swap nodes
	        swapMinHeapNode(minHeap.array[smallest], minHeap.array[idx]);
	 
	        minHeapify(minHeap, smallest);
	    }
	}
	
	/// A utility function to check if the given minHeap is empty or not
	boolean isEmpty(MinHeap minHeap)
	{
	    return (minHeap.size == 0);
	}
	
	// Standard function to extract minimum node from heap
	private MinHeapNode extractMin(MinHeap minHeap)
	{
	    if (isEmpty(minHeap))
	        return null;
	 
	    // Store the root node
	    MinHeapNode root = minHeap.array[0];
	 
	    // Replace root node with last node
	     MinHeapNode lastNode = minHeap.array[minHeap.size - 1];
	    minHeap.array[0] = lastNode;
	 
	    // Update position of last node
	    minHeap.pos[root.v] = minHeap.size-1;
	    minHeap.pos[lastNode.v] = 0;
	 
	    // Reduce heap size and heapify root
	    --minHeap.size;
	    minHeapify(minHeap, 0);
	 
	    return root;
	}
	
	// Function to decrease dist value of a given vertex v. This function
	// uses pos[] of min heap to get the current index of node in min heap
	void decreaseKey(MinHeap minHeap, int v, int dist)
	{
	    // Get the index of v in  heap array
	    int i = minHeap.pos[v];
	 
	    // Get the node and update its dist value
	    minHeap.array[i].dist = dist;
	 
	    // Travel up while the complete tree is not hepified.
	    // This is a O(Logn) loop
	    while (minHeap.array[i].dist < minHeap.array[(i - 1) / 2].dist)
	    {
	        // Swap this node with its parent
	        minHeap.pos[minHeap.array[i].v] = (i-1)/2;
	        minHeap.pos[minHeap.array[(i-1)/2].v] = i;
	        swapMinHeapNode(minHeap.array[i],  minHeap.array[(i - 1) / 2]);
	 
	        // move to parent index
	        i = (i - 1) / 2;
	    }
	}
	 
	// A utility function to check if a given vertex
	// 'v' is in min heap or not
	boolean isInMinHeap(MinHeap minHeap, int v)
	{
	   if (minHeap.pos[v] < minHeap.size)
	     return true;
	   return false;
	}
	
	
	// A utility function used to print the solution
	void printArr(int dist[], int n)
	{
	    System.out.printf("Vertex   Distance from Source\n");
	    for (int i = 0; i < n; ++i)
	    	System.out.printf("%d \t\t %d\n", i, dist[i]);
	}
	
	
	// The main function that calulates distances of shortest paths from src to all
	// vertices. It is a O(ELogV) function
	void dijkstra( Graph graph, int src)
	{
	    int V = graph.V;// Get the number of vertices in graph
	    int[] dist=new int[V];      // dist values used to pick minimum weight edge in cut
	 
	    // minHeap represents set E
	    MinHeap minHeap = createMinHeap(V);
	 
	    // Initialize min heap with all vertices. dist value of all vertices 
	    for (int v = 0; v < V; ++v)
	    {
	        dist[v] = Integer.MAX_VALUE;
	        minHeap.array[v] = newMinHeapNode(v, dist[v]);
	        minHeap.pos[v] = v;
	    }
	 
	    // Make dist value of src vertex as 0 so that it is extracted first
	    minHeap.array[src] = newMinHeapNode(src, dist[src]);
	    minHeap.pos[src]   = src;
	    dist[src] = 0;
	    decreaseKey(minHeap, src, dist[src]);
	 
	    // Initially size of min heap is equal to V
	    minHeap.size = V;
	 
	    // In the followin loop, min heap contains all nodes
	    // whose shortest distance is not yet finalized.
	    while (!isEmpty(minHeap))
	    {
	        // Extract the vertex with minimum distance value
	         MinHeapNode minHeapNode = extractMin(minHeap);
	        int u = minHeapNode.v; // Store the extracted vertex number
	 
	        // Traverse through all adjacent vertices of u (the extracted
	        // vertex) and update their distance values
	        List<AdjListNode> crawl = graph.array[u];
	        Iterator<AdjListNode> pCrawl = crawl.iterator();
	       // int i=1;
	        while (pCrawl.hasNext())
	        {
	        	AdjListNode node=pCrawl.next();
	            int v =node.dest;
	 
	            // If shortest distance to v is not finalized yet, and distance to v
	            // through u is less than its previously calculated distance
	            if (isInMinHeap(minHeap, v) && dist[u] != Integer.MAX_VALUE && 
	            		node.weight + dist[u] < dist[v])
	            {
	                dist[v] = dist[u] +node.weight;
	 
	                // update distance value in min heap also
	                decreaseKey(minHeap, v, dist[v]);
	            }
	            
	        }
	    }
	 
	    // print the calculated shortest distances
	    printArr(dist, V);
	}
	 
	public static void main(String[] args) {
		// create the graph given in above fugure
	    int V = 9;
	    DijsktraMinPQandAdjacencyList dijkstra= new DijsktraMinPQandAdjacencyList();
	    Graph graph = dijkstra.createGraph(V);
	    dijkstra.addEdge(graph, 0, 1, 4);
	    dijkstra.addEdge(graph, 0, 7, 8);
	    dijkstra.addEdge(graph, 1, 2, 8);
	    dijkstra.addEdge(graph, 1, 7, 11);
	    dijkstra.addEdge(graph, 2, 3, 7);
	    dijkstra.addEdge(graph, 2, 8, 2);
	    dijkstra.addEdge(graph, 2, 5, 4);
	    dijkstra.addEdge(graph, 3, 4, 9);
	    dijkstra.addEdge(graph, 3, 5, 14);
	    dijkstra.addEdge(graph, 4, 5, 10);
	    dijkstra.addEdge(graph, 5, 6, 2);
	    dijkstra.addEdge(graph, 6, 7, 1);
	    dijkstra.addEdge(graph, 6, 8, 6);
	    dijkstra.addEdge(graph, 7, 8, 7);
	 
	    dijkstra.dijkstra(graph, 0);
	}

}
