import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
DFS, store intermediate result. Every subtree return 2 values, 
ret[0] is number of nodes in subtree which are survived with cut, 
ret[1] is the number of cuts conducted in among the subtree.
if a parent finds its subtree's ret[0] is even, then cut.
*/
public class EvenTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Map<Integer, List<Integer>> adjlist = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<M; ++i){
            int a = in.nextInt();
            int b = in.nextInt();
            if(!adjlist.containsKey(a)){
                adjlist.put(a, new ArrayList<Integer>());
            }
            if(!adjlist.containsKey(b)){
                adjlist.put(b, new ArrayList<Integer>());
            }
            adjlist.get(a).add(b);
            adjlist.get(b).add(a);
        }
        int result = maxCut(adjlist);
        System.out.println(result);
    }
    public static int maxCut(Map<Integer, List<Integer>> adjlist){
        int root = -1;// construct dummy root first!
        for(int node: adjlist.keySet()){
            root = node;// any node can be root
            break;
        }
        adjlist.put(-1, new ArrayList<Integer>());
        adjlist.get(-1).add(root);
        adjlist.get(root).add(-1);
        root = -1;
        int[] result = maxCut(adjlist, root, new HashMap<Integer, Boolean>());
        return result[1] - 1;// the connection with dummy node always be cut!
    }
    public static int[] maxCut(Map<Integer, List<Integer>> adjlist, int root, Map<Integer, Boolean> visit){
        List<Integer> lst = adjlist.get(root);
        visit.put(root, true);
        int cut = 0;
        int num = 0;
        for(int adj: lst){
            if(visit.containsKey(adj) && visit.get(adj)) continue;
            int[] sub = maxCut(adjlist, adj, visit);
            int numOfNode = sub[0];
            int numOfCut = sub[1];
            cut += numOfCut;
            if(numOfNode%2 == 0) cut++;
            else num += numOfNode;
        }
         
        int[] ret = new int[2];
        ret[0] = num + 1;
        ret[1] = cut;
        visit.put(root, false);
        return ret;
    }
    
}
