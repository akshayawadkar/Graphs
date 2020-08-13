import java.util.LinkedList;

class CycleInUndirectedGraph{

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

                if(hasCycleUtil(visited, currStack, i)){
                    return true;
                }

            }

            return false;
        }

        boolean hasCycleUtil(boolean[] visited, boolean[] currStack, int curr){

            if(currStack[curr] == true){
                return true;
            }

            if(visited[curr] == true){
                return false;
            }

            visited[curr] = true;
            currStack[curr] = true;
            for(int i : adjMatrix[curr]){
                if(!visited[i]){
                    hasCycleUtil(visited, currStack, i);
                }
            }
            currStack[curr] = false;
            return false;
        }
    }



    public static void main(String[] args) {
     
        Graph graph = new Graph(5); 
        graph.addEdge(0, 1); 
        
        graph.addEdge(1, 2); 
        graph.addEdge(2, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.addEdge(3, 3); 
               

        System.out.println(graph.hasCycle());
    }
}