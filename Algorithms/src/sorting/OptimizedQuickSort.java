import java.util.*;
//My chosen strategy is to choose  pivot as last element.
public class OptimizedQuickSort {
    //a. getPivot(arr, lo, hi)nreturn pivot as last element in sub arr
    double getPivot(double[] arr, int lo, int hi){
        double pivot = arr[hi];
        System.out.println("Pivot is: " + pivot);
        return pivot;
    }

    //b. insertionSort when sub arr length is less than < 30
    void insertionSort(double[] arr, int lo, int hi){
        for (int unsorted = 1; unsorted < arr.length; unsorted++){//O(N) run time
            //O(N) run time
            for (int sorted = 0; sorted < unsorted; sorted++){
                //shift sorted to the right
                while (arr[unsorted] < arr[sorted]){
                    //swap sorted and unsorted element
                    double tmp = arr[sorted];
                    arr[sorted] = arr[unsorted];
                    arr[unsorted] = tmp;
                }
            }
        }
    }

    //partion
    int partion(double[] arr, int start, int end) {
        //i: loop index, j: smaller elements index
        double pivot = arr[end];
        getPivot(arr, start, end);
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                j++;
                //swap arr[i] and arr[j]
                double tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        //swap pivot and arr[j+1]
        double tmp = arr[end];
        arr[end] = arr[j+1];
        arr[j+1] = tmp;
        return j;
    }

    //O(N^2) run time, O(logN) memory
    void quickSort(double[] arr, int start, int end){
        long startTime = System.nanoTime();
        int pivot;
        if( start < end) {
            pivot = partion(arr, start, end);
            //Recursively sort parts of arr
            //if sub arr length < 30
            if(arr.length < 30){
                insertionSort(arr, start, end);
                insertionSort(arr, pivot + 1, end);
            }
            else {
                quickSort(arr, start, pivot - 1);
                quickSort(arr, pivot + 1, end);
            }
        }
        //show sorted array
        System.out.print("Sorted array: ");
        show(arr);
        //show run time
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Run time: " + totalTime);
    }

    //utility method to fill array w random generated doubles
     void fillArr(double[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100) / 100.0;
        }
    }
    //utility method to print array
    static void show(double[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OptimizedQuickSort qs = new OptimizedQuickSort();
        int size = 10^3;
        int size1 = 10^4;
        int size2 = 10^5;
        int size3 = 10^6;
        double[] arr = new double[size];
        double[] arr1 = new double[size1];
        double[] arr2 = new double[size2];
        double[] arr3 = new double[size3];

        qs.fillArr(arr);
        qs.fillArr(arr1);
        qs.fillArr(arr2);
        qs.fillArr(arr3);

        System.out.println("1. Array with 10^3 length:");
        qs.quickSort(arr, 0, arr.length-1);
        System.out.println("2. Array with 10^4 length:");
        qs.quickSort(arr1, 0, arr1.length - 1);
        System.out.println("3. Array with 10^5 length:");
        qs.quickSort(arr2, 0, arr2.length - 1);
        System.out.println("4. Array with 10^6 length:");
        qs.quickSort(arr3, 0, arr.length - 1);
    }
}
