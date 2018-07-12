import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.LinkedList;

//STRONGLY CONNECTED COMPONENTS
class SCCGraph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    public SCCGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)  { adj[v].add(w); }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    SCCGraph getTranspose()
    {
        SCCGraph g = new SCCGraph(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // Print strongly connected components
    void printSCCs()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        SCCGraph gr = getTranspose();

        // Mark all the vertices as not visited
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        //read the SCCConections.txt file using BufferedReader class
        String file = "/Users/Nhat/Desktop/Github/DataStructures-Algorithms/Algorithms/src/graphs/SCCConections.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String word;
        int v, w, FILE_SIZE = 135;//init run on txt file give 135

        // Create a graph given in the above diagram
        SCCGraph g = new SCCGraph(FILE_SIZE);

        //split and convert text line into int v and w to pass to the addEdge() method
        while ((word = br.readLine()) != null) {
            String[] arr_str = new String[2];
            arr_str = word.split(" ");
            v = Integer.parseInt(arr_str[0]);
            w = Integer.parseInt(arr_str[1]);
            System.out.println( v + " - " + w);
            g.addEdge(v, w);
        }

        //print out results
        System.out.println("Strongly connected components are: ");
        g.printSCCs();
    }
}