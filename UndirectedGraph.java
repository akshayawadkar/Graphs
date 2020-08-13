import java.util.*;

class UndirectedGraph{

    static class Graph{
        int v;
        LinkedList<Integer> adjMatrix[];

        Graph(int v){
            this.v = v;
            adjMatrix = new LinkedList[v];
            for(int i = 0; i < v; i++){
                adjMatrix[i] = new LinkedList<>();
            }
        }



        void addEdge(int src, int dest){
            adjMatrix[src].add(dest);
            adjMatrix[dest].add(src);
            
        }

        void disp(){
            for(LinkedList ll : adjMatrix){
                System.out.println(ll);
            }
        }
    }



    public static void main(String[] args) {
        int V = 5; 
        Graph graph = new Graph(V); 
        graph.addEdge( 0, 1); 
        graph.addEdge( 0, 4); 
        graph.addEdge( 1, 2); 
        graph.addEdge( 1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4);
        graph.disp();
    }

}