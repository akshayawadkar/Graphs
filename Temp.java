import java.util.LinkedList;
import java.util.Stack;

class Temp{

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
        }

        boolean hasCycle(){
            boolean[] visited = new boolean[v];
            boolean[] currStack = new boolean[v];

            for(int i = 0; i < v; i++){
                
                    if(helper(i, visited, currStack)){
                        return true;
                    }
                
            }


            return false;
        }

        boolean helper(int curr, boolean[] visited, boolean[] currstack){
            
            if(currstack[curr]){
                return true;
            }

            if(visited[curr]){
                return false;
            }

            visited[curr] = true;
            currstack[curr] = true;

            for(int i : adjMatrix[curr]){
                
                    if(helper(i, visited, currstack)){
                        return true;
                    }
                
            }
            currstack[curr] = false;
            return  false;
        }
         


        
    }

    public static void main(String[] args) {
        
        Graph graph = new Graph(5); 
        graph.addEdge(0, 1); 
        
        graph.addEdge(1, 2); 
        graph.addEdge(2, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.addEdge(3, 2); 

        // graph.addEdge(2, 3); 
               
         
               

        System.out.println(graph.hasCycle());
    

    }

}