package com.learnbycoding.shortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordShortestPath {

	int V;
	int E;
    List<Edge> edges;
    Map<Integer, VertexData> dist;
    
    class VertexData{
   
    	int distance;
    	int parent;
 
    	public VertexData(){
    		this.parent=Integer.MIN_VALUE;
    		this.distance=Integer.MAX_VALUE;
    	}
    }
    
	class Edge {
		int src;
		int dest;
		int weight;
		public Edge(int src , int dest ,int weight) {
			this.src=src;
			this.dest=dest;
			this.weight =weight;
		}
	}

	public BellmanFordShortestPath(int v, int e) {
		this.V = v;
		this.E = e;
		
		edges= new ArrayList<Edge>();
		dist= new HashMap<Integer,VertexData>();
		
		for(int i=0;i<this.V;i++){

	        VertexData vertexData= new VertexData();
			dist.putIfAbsent(i, vertexData);
		}
	}
	
	private void addEdge(int src, int dest , int weight){
		Edge newEdge= new Edge(src, dest, weight);		
		edges.add(newEdge);
	}
	
	
	private void getShortestPathToAllVerticesFromSrc(int source) throws Exception{
		
		VertexData vertexData = dist.get(source);
		vertexData.distance=source;
		dist.put(source, vertexData);
		
		//This loop should go for V-1 times
		for(int i=0;i<(this.V-1);i++){
			
			System.out.println("Iteration -> " + (i+1));
			for(int j=0;j<edges.size();j++){
				Edge edge= edges.get(j);
				int src= edge.src;
				int dest= edge.dest;
				int edgeWeight = edge.weight;
				int srcDist=dist.get(src).distance;
				int destDist= dist.get(dest).distance;
			
				System.out.println("Src is -> " + src + ". Dest is -> "+ dest+ ". Weight is -> " + edgeWeight + " srcDist -> " + srcDist) ;
				if(srcDist !=Integer.MAX_VALUE && destDist > srcDist+edgeWeight){
					
					VertexData vertData=dist.get(dest);
					vertData.distance=srcDist+edgeWeight;
					vertData.parent= src;
					dist.put(dest, vertData);
				}
			}
		}
		
		
		//Check if there are cycless
		for(int j=0;j<edges.size();j++){
			Edge edge= edges.get(j);
			int src= edge.src;
			int dest= edge.dest;
			int edgeWeight = edge.weight;
			int srcDist=dist.get(src).distance;
			int destDist= dist.get(dest).distance;
			
			if(destDist > srcDist+edgeWeight){
			  throw new Exception("Negative cycle detected");
			}
		}
		
		printAllShortPath(source);
	}
	
	private void printAllShortPath(int source){

		System.out.println("Vertex  " + "  Dist from Source " + "   Parent is");
		for(int i=0;i<this.V;i++){
			System.out.println(i + "           " +  dist.get(i).distance +  "                     " + dist.get(i).parent);
		}
	}

	public static void main(String[] args) throws Exception {

		int V=5;
		int E=8;
		
		BellmanFordShortestPath bellmanFord = new BellmanFordShortestPath(V, E);
		bellmanFord.addEdge(0, 1, -1);
		bellmanFord.addEdge(0, 2, 4);
		bellmanFord.addEdge(1, 2, 3);
		bellmanFord.addEdge(1, 3, 2);
		bellmanFord.addEdge(1, 4, 2);
		bellmanFord.addEdge(3, 2, 5);
		bellmanFord.addEdge(3, 1, 1);
		bellmanFord.addEdge(4, 3, -3);
		
		bellmanFord.getShortestPathToAllVerticesFromSrc(0);
		
	}
}
