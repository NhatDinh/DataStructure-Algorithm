package union_find_maze;
import java.util.Random;

public class UnionFindMaze {
	int[] id;
	
	public int[] createMaze(int N, int M) {
		int[] id = new int[N*M];
		for(int i=0; i< N*M; i++) id[i] = i;
		return id;
	}
	
	public int find(int p) {
		return id[p];
	}
	
 	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i=0; i < id.length; i++) {
			if(id[i] == pid) id[i] = qid;
		}
	}
 	
 	//knock walls down
 	public void knockWalls() {
 		int[] grid = createMaze(10, 10);
 		while(grid != null) {
 		// create instance of Random class
 	        Random rand = new Random();
 			//pick random edges and remove from E
 			int random = rand.nextInt(100);
 			
 		}
 	}
	public static void main(String[] args) {
		
	}

}
