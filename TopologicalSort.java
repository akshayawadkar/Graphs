import java.util.*;

class TopologicalSort{

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

        void topologicalSort(){
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[v];

            for(int i = 0; i < v; i++){
                if(!visited[i]){
                    topologicalSortUtil(visited, stack, i);
                }
            }

            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }

        void topologicalSortUtil(boolean[] visited, Stack<Integer> stack, int curr){
            visited[curr] = true;

            for(int i : adjMatrix[curr]){
                if(!visited[i]){
                    topologicalSortUtil(visited, stack, i);
                }
            }

            stack.push(curr);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1);
        g.topologicalSort();
    }
}