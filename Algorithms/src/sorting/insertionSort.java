package sorting;

class insertionSort {
    // 0(n) run time with 0(1) memory
    static char[] sort(String str) {
        int len = str.length();
        char[] array = str.toCharArray();
        char[] sorted = new char[len];
        sorted[0] = array[0];

        for (int i = 1; i < str.length(); i++) {
            for (int n = 0; n < len - 1 ; n++) {
                if (array[i] < sorted[n]) {
                    char tmp = sorted[n];
                    sorted[n] = array[i];
                    array[i] = tmp;
                }
                else break;
            }
            sorted[i] = array[i];
            printSorted(sorted);
            System.out.println();

        }
        return sorted;
    }
    //utility method to print array
     static void printSorted(char[] array){
        char[] arr = array;
        for (int i = 0; i < array.length; i++){
            System.out.print(arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        sort("ILOVEALGORITHMS");
    }
}
