import java.util.LinkedList;

class DFS{
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
        
        void dfs(int start){
            boolean[] visited = new boolean[v];
             
            dfsUtil(visited, start);
        }

        void dfsUtil(boolean[] visited, int curr){
            visited[curr] =  true;
            System.out.print(curr+" ");

            for(int i : adjMatrix[curr]){
                if(!visited[i]){
                    dfsUtil(visited, i);
                }
            }

        }


         
    }



    public static void main(String[] args) {
     
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        g.dfs(2);


        
    }
}