import java.util.*;

class DisjointSet{
     static class Node{
         long data;
         Node parent;
         int rank;
     }
     Map<Long, Node> map = new HashMap<>();

     public void makeSet(long data){
         Node node = new Node();
         node.parent = node;
         node.data = data;
         node.rank = 0;
         map.put(data, node);
     }


     public boolean union(long data1, long data2){
         Node node1 =  map.get(data1);
         Node node2 =  map.get(data2);

         Node parent1 = findSet(node1);
         Node parent2 = findSet(node2);

         if(parent1.data == parent2.data){
             return false;
         }
        if(parent1.rank >= parent2.rank){
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
         
         
         return true;
     }

     public long findSet(long data){
         return findSet(map.get(data)).data;
     }

     public Node findSet(Node node){
        

         if(node.parent == node){
             return node;
         }

         node.parent = findSet(node.parent);
         return node.parent;
     }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet();

        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);
        set.makeSet(7);

        set.union(1, 2);
        set.union(2, 3);
        set.union(4, 5);
        set.union(6, 7);
        set.union(5, 6);
        set.union(3, 7);
        
        System.out.println(set.findSet(1));
        System.out.println(set.findSet(2));
        System.out.println(set.findSet(3));
        System.out.println(set.findSet(4));
        System.out.println(set.findSet(5));
        System.out.println(set.findSet(6));
        System.out.println(set.findSet(7));
 
        

    }


}