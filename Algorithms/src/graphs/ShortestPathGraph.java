import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPathGraph
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };

    // A class to represent a subset for union-find
    class subset
    {
        int parent, rank;
    };

    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with V vertices and E edges
    ShortestPathGraph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST()
    {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();


        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display
        // the built MST
        System.out.println("Shortest path edges: ");
        for (i = 0; i < e; ++i)
            System.out.println("Fr: " + result[i].src+" -- " +
                    result[i].dest+" Response time == " + result[i].weight);
    }

    // Driver Program
    public static void main (String[] args) throws Exception
    {
        //read the SCCConections.txt file using BufferedReader class
        String file = "/Users/Nhat/Desktop/Github/DataStructures-Algorithms/Algorithms/src/graphs/ABCUtilityConnections.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String word;
        int src, dest, weight, index = 0, FILE_SIZE = 128;//init run on txt file give 135
        // Create a graph given in the above diagram
        ShortestPathGraph graph = new ShortestPathGraph(50, FILE_SIZE);

        //split and convert text line into int v and w to pass to the addEdge() method
        while ((word = br.readLine()) != null) {
            String[] arr_str = new String[3];
            arr_str = word.split(" ");
            src = Integer.parseInt(arr_str[0]);
            dest = Integer.parseInt(arr_str[1]);
            weight = Integer.parseInt(arr_str[2]);
            //System.out.println( "Fr: " + src + " To: " + dest + " Weight: " + weight + " At: " + index);
            graph.edge[index].src = src;
            graph.edge[index].dest = dest;
            graph.edge[index].weight = weight;
            index++;
        }

        graph.KruskalMST();
    }
}

