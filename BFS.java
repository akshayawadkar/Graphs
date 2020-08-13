import java.util.LinkedList;

class BFS{
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

        void bfs(int start){

            LinkedList<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[v];
            q.add(start);
            visited[start] = true;

            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    int curr = q.poll();
                    System.out.print(curr+" ");
                    for(int child : adjMatrix[curr]){
                        if(!visited[child]){
                            visited[child] = true;
                            q.add(child);
                        }
                    }
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
        g.bfs(2);


        
    }
}