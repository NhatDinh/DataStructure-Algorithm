package vitrivr_task3;

/* Java program to find a Pair which has maximum score*/
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Random;
 import java.util.UUID;
 
 //GSOC 18' Vitrivr Task 3
/*
 * Generate a list of 100'000 tuples (x,id), 
 * where x is a value between 0 and 1000 and id is a unique identifier. 
 * Return the id of the 500 elements with the smallest x. 
 * You may return more than 500 elements, if the 500th element has the same value as the 501st, 502nd, etc., 
 * however, you should not return fewer than 500 elements. Make sure you do this efficiently.
 * Hint: this can be done in O(n)
 */

public class ResultList {
	public static ArrayList generateList() {
		ArrayList<Pair<String, Integer>> list = new ArrayList<Pair<String, Integer>>();
		Random rand = new Random(); //random Value
		String unique_id = UUID.randomUUID().toString(); //generate a unique identifier
		for(int i = 0; i < 10; i++) {
			int random_int = rand.nextInt(1001);
			list.add(new Pair<String, Integer> (unique_id, random_int));
			Pair<String, Integer> temp = list.get(i);
			System.out.println(temp);
		}	
		return list;
	}
   
 
    // Driver method to test above method
    public static void main (String[] args)
    { 
    	generateList();                      
    }
}
