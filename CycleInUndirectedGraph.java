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
            adjMatrix[dest].add(src);
        }

        boolean hasCycle(){
            boolean[] visited = new boolean[v];
            for(int i = 0; i < v; i++){
                System.out.println("here");
                if(!visited[i]){
                    if(isCycleUtil(i, visited, -1)){
                        return true;
                    }
                }
            }
            System.out.println("here");
            return false;
        }

        boolean isCycleUtil(int curr, boolean[] visited, int parent){
            visited[curr] = true;
            for(int i : adjMatrix[curr]){
                if(!visited[i]){
                    if(isCycleUtil(i, visited, curr)){
                        return true;
                    }
                }else if(i != parent){
                    return true;
                }
            }
            System.out.println("here");
            return false;
        }
    }

    public static void main(String[] args) {
        
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 

        System.out.println(g1.hasCycle());
    }
}