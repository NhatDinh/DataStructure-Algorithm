package sorting;

class InsertionSort {
    //O(N^2) run time, 0(1) memory
    String insertionSort(String str){
        char[] arr = str.toCharArray();
        for (int unsorted = 1; unsorted < arr.length; unsorted++){//O(N) run time
            //O(N) run time
            for (int sorted = 0; sorted < unsorted; sorted++){
                while (arr[unsorted] < arr[sorted]){
                    //swap sorted and unsorted element
                    char tmp = arr[sorted];
                    arr[sorted] = arr[unsorted];
                    arr[unsorted] = tmp;
                }
            }
            str = new String(arr);
            show(str);
        }
        //convert char arr to string
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
        InsertionSort is = new InsertionSort();
        is.insertionSort("ILOVEALGORITHMS");

    }
}
