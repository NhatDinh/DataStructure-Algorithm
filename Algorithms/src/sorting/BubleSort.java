public class BubleSort {
    //O(N^2) run time, 0(1) memory
    String bubleSort(String str){
        char[] arr = str.toCharArray();
        int ops = 1;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    //swap i and j element
                    char tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    str = new String(arr);
                    System.out.println("OPS: #" + ops);
                    show(str);
                    ops++;
                }
            }
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
        BubleSort bbs = new BubleSort();
        bbs.bubleSort("ILOVEALGORITHMS");
    }
}
