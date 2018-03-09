package recursion;

/*
 * Input: 4 discs
 * Method: Divide and conquer
 * 
 * -Move 3 discs from rod A to rod B = tOH(n-1, A, B, C)
 *  |--Move 2 discs from rod A to rod C  = tOH(n-2, A, C, B) 
 *     |--Move 1 disc from rod A to rod B   = tOH(n-3, A, B, C)
 *     |--Move 2nd disc from rod A to rod C = tOH(n  , A, C, B)
 *     |--Move 1 disc from rod B to rod C   = tOH(n-3, B, C, A)
 *     
 *  |-- Move 3rd disc from rod A to rod B = tOH(n, A, B, C)
 *  
 *  |--Move 2 discs from rod C to rod B  = tOH(n-2, C, B, A)
 *     |--Move 1 disc from rod C to rod A   = tOH(n-3, C, A, B)
 *     |--Move 2nd disc from rod C to rod B = tOH(n  , C, B, A)
 *     |--Move 1 disc from rod A to rod B   = tOH(n-3, A, B, C)
 *     
 *  |--Move 4th disc from rod A to rod C = tOH(n, A, C,B)
 * 
 * -Move 3 discs from rod B to rod C = tOH(n-1, C, B, A)  
 *  |--Move 2 discs from rod B to rod A  = tOH(n-2, B, A, C)
 *     |--Move 1 disc from rod B to rod C   = tOH(n-3, B, C, A)
 *     |--Move 2nd disc from rod B to rod A = tOH(n  , B, A, C)
 *     |--Move 1 disc from rod C to rod A   = tOH(n-3, C, A, B)
 *     
 *  |--Move 3rd disc from rod B to rod C = tOH(n-1, B, C, A)
 *  
 *  |--Move 2 discs from rod A to rod C  = tOH(n-2, A, C, B)
 *     |--Move 1 disc from rod A to rod B   = tOH(n-3, C, A, B)
 *     |--Move 2nd disc from rod A to rod C = tOH(n  , C, B, A)
 *     |--Move 1 disc from rod B to rod C   = tOH(n-3, A, B, C)
 *  
 * => Recursive problem
 *  */

public class TowerOfHanoi {
	 static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
	    {
	        if (n == 1)
	        {
	            System.out.println("1 from " +  from_rod + " to " + to_rod);
	            return;
	        }
	        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
	        System.out.println(n + " from " +  from_rod + " to " + to_rod);
	        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
	    }
	     
	    public static void main(String args[])
	    {
	        int n = 4; // Number of discs
	        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
	    }

}
