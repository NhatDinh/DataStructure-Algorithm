import java.util.*;
public class HeapSort {
    //convert unordered array into heap structure
    //O(N) run time
    static int[] max_heap(int[] arr, int last){

        //O(N) run time, 0(1) memory
        int largest = arr[0];
        for (int i = 0; i < last; i++){
            if (arr[i] > largest){
                largest = arr[i];

            }
        }
        //while root is not largest
        //0(N) run time, 0(1) memory
        while (arr[0] != largest) {
            for (int i = 0; i < (last - 1) / 2; i++) {
                //if left > parent and left > right
                if (arr[i * 2 + 1] > arr[i] && arr[i * 2 + 1] > arr[i * 2 + 2]) {
                    int tmp = arr[i];
                    arr[i] = arr[i * 2 + 1];
                    arr[i * 2 + 1] = tmp;
                }
                //if right > parent and right > left
                if (arr[i * 2 + 2] > arr[i] && arr[i * 2 + 2] > arr[i * 2 + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i * 2 + 2];
                    arr[i * 2 + 2] = tmp;
                }
            }
        }
        return arr;
    }

    //heap sort
    //O(NlogN) run time, 0(1) memory
    static int[] heapSort(int[] arr){
        int first = 0;
        int last = arr.length;
        //O(N) run time
        arr = max_heap(arr, last);
        //O(N) run time
        while (last > 0) {
            //swap first and last
            int tmp = arr[first];
            arr[first] = arr[last - 1];
            arr[last - 1] = tmp;
            last--;
            arr = max_heap(arr, last);
        }
        return arr;
    }

    //fill arr with 100 randomly generated distinct keys range 0 to 1000
    void fillArr(int[] arr){
        //technique to generate unique key
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i = 0; i < 100; i++){
            arr[i] = list.get(i);
        }
    }
    //utility method to print array
    static void show(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //3 run time
        int run = 1;
        while (run <= 2) {
            System.out.println("Run #" + run++);
            int[] arr = new int[100];
            //heap sort
            HeapSort hs = new HeapSort();
            hs.fillArr(arr);
            System.out.println("Unsorted array: ");
            show(arr);
            System.out.println("Sorted array: ");
            hs.heapSort(arr);
            show(arr);
        }
    }
}
