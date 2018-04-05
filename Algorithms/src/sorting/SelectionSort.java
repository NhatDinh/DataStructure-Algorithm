package sorting;

public class SelectionSort {
    //0(N^2) run time, 0(1) memory
    String selectionSort(String str) {
        char[] arr = str.toCharArray();
        int pos = 0;
        int smallest_pos = 0;

        //O(N) run time
        while (pos < str.length()){
            str = new String(arr);
            show(str);
            //init smallest
            char smallest = arr[pos];
            //Get smallest element
            //O(N) run time
            for(int i = pos; i < arr.length; ++i){
                if ( arr[i] <= smallest){
                    smallest = arr[i];
                    smallest_pos = i;
                }
            }
            //swap pos and smallest pos elements
            arr[smallest_pos] = arr[pos];
            arr[pos] = smallest;
            pos++;
        }
        return str;
    }

    //utility method to print array
    static void show(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        ss.selectionSort("ILOVEALGORITHMS");
    }
}
