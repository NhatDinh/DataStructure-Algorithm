//Recursively merge sub arrays
//TO-DO: MAKE SENSE HOW RECURSION WORKS IN THIS CASE
public class TopDownMergeSort {
    void merge(char[] arr, int mid, int left, int right){
        System.out.println("merge called");
    }


    void mergeSort(char[] arr, int left, int right, String str){
        String strT = new String(arr);
        show(strT, right);
        //recursively devide arr into 2 halves
        if(left < right){
            int mid = (left + right) /2;

            //call mergeSort on 1st half
            mergeSort(arr, left, mid, "1st half");
            //call mergeSort on 2nd half
            mergeSort(arr, mid + 1, right, "2nd half");

            //merge and sort the halves
            merge(arr, mid, left, right);
        }
    }

    //utility method to print array
    static void show(String str, int end){
        for (int i = 0; i <= end ; i++){
            System.out.print(str.charAt(i) + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopDownMergeSort ms = new TopDownMergeSort();
        String str = "ILOVEALGORITHMS";
        int start = 0;
        int end = str.length() - 1;
        char[] arr = str.toCharArray();
        ms.mergeSort(arr, start, end, "start");
    }
}
