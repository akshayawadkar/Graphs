import java.util.ArrayList;

public class Kruskals {

     static class Edge{
         int src;
         int dest;
         int weight;
         Edge(int src, int dest, int weight){
             this.src = src;
             this.dest = dest;
             this.weight  = weight;
         }
     }

     static class Graph{
         int v;
         ArrayList<Edge> edges = new ArrayList<>();

         Graph(int v){
             this.v = v;
         }

         public void addEdge(int src, int dest,  int weight){
             Edge edge =  new Edge(src, dest, weight);
             edges.add(edge);
         }


     }

     public static void main(String[] args) {
         
        Graph g  = new Graph(6);
        g.addEdge(0, 1, 4);
     }
}