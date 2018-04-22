public class QuickSort {
    //partion
    int partion(char[] arr, int start, int end) {
        //i: loop index, j: smaller elements index
        char pivot = arr[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                j++;
                //swap arr[i] and arr[j]
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                String str = new String(arr);
                show(str);
            }
        }
        //swap pivot and arr[j+1]
        char tmp = arr[end];
        arr[end] = arr[j+1];
        arr[j+1] = tmp;
        String str = new String(arr);
        show(str);
        return j;
    }

    //O(N^2) run time, O(logN) memory
    void quickSort(char[] arr, int start, int end){
        int pivot;
        if( start < end) {
            pivot = partion(arr, start, end);
            //Recursively sort parts of arr
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }
    //utility method to print array
    static void show(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        //String str = "AFBGCDE";
        String str = "ILOVEALGORITHMS";
        int start = 0;
        int end = str.length() - 1;
        char[] arr = str.toCharArray();
        qs.quickSort(arr, start, end);
    }
}