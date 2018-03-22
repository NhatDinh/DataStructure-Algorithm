package union_find_maze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class UnionFindMaze {
    static class Maze {
        HashMap<Integer, Integer> vertical_edges = new HashMap<>();
        HashMap<Integer, Integer> horizontal_edges = new HashMap<>();

        void fillEdges(int grid_size) {
            for (int i = 1; i < grid_size * grid_size; i++) {
                Integer key = new Integer(i);
                Integer horizontal_value = new Integer(i + 1);
                Integer vertical_value = new Integer(i + grid_size);
                vertical_edges.put(key, vertical_value);
                horizontal_edges.put(key, horizontal_value);
            }
        }

        Integer removeEdge(Integer key) {
            Integer removed_edge_val = new Integer(0);//initialization
            System.out.print("Removed Edge: <Key:" + key);
            if (this.vertical_edges.get(key) != null) {
                removed_edge_val = new Integer(this.vertical_edges.get(key));
                System.out.println("-Val:" + removed_edge_val + ">\n" );
                this.vertical_edges.remove(key);
            }
            else if (this.horizontal_edges.get(key) != null){
                removed_edge_val = new Integer(this.horizontal_edges.get(key));
                System.out.println("-Val:" + removed_edge_val +">\n");
                this.horizontal_edges.remove(key);
            }
            else; //if vertical value and horizontal value is null, dont do anything
            return removed_edge_val;
            //Integer horizonta_value = maze.vertical_edges.get(key);

        }

        Integer pickRandomEdge() {
            Random rand = new Random(); //instance of java.util.Random class
            //To keep random_edge random, I will not apply any set of rule to it
            Integer random_edge = new Integer(rand.nextInt(25));
            return random_edge;
        }

    }
    static class UnionMaze{
        HashMap<Integer, Integer> empty_vertical_edges = new HashMap<>();
        HashMap<Integer, Integer> empty_horizontal_edges = new HashMap<>();
        ArrayList<Integer> id = new ArrayList<Integer>(25);

        //set elements in array id to itself
        void fillId(){
            for(int i=0;i<=25;i++){
                Integer element = new Integer(i);
                this.id.add(element);
            }
        }

        Integer find(Integer p) {
            int p_int = p.intValue();
            return id.get(p_int);
        }

        void union(Integer p, Integer q) {
            Integer pid = id.get(p);
            Integer qid = id.get(q);
            for (int i = 1; i < id.size(); i++) {
                if (id.get(i) == pid) id.set(i, qid) ;
            }
        }

    }

    public static void main(String[] args) {
        int i =0;
        Maze maze = new Maze();
        UnionMaze union_maze = new UnionMaze();
        maze.fillEdges(5);//a maze of grid size 10*10
        union_maze.fillId();//
        Integer edge = maze.pickRandomEdge();//pick a random edge to remove
        while(i < 5){
            Integer edge_val = maze.removeEdge(edge);

            Integer u = union_maze.find(edge);
            Integer v = union_maze.find(edge_val);
            if (u != v) union_maze.union(u, v);
            else;
            i++;
        }
    }
}


