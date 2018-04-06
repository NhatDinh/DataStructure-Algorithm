public class ShellSort {
    //0(NlogN^2) run time, 0(1) memory
    String shellSort(String str){
        char[] arr = str.toCharArray();
        int length = arr.length;
        //O(logN) run time
        for(int gap = length/2; gap > 0; gap/=2 ){
            //O(N) run time
            for (int pos = 0; pos < length - gap; pos++){
                if (arr[pos+gap] < arr[pos]){
                    //swap
                    char tmp = arr[pos];
                    arr[pos] = arr[pos+gap];
                    arr[pos+gap] = tmp;
                    str = new String(arr);
                    show(str);
                    //O(logN) run time
                    while (pos - gap >= 0 && arr[pos] < arr[pos-gap]){
                        //swap
                        char tmpTmp = arr[pos];
                        arr[pos] = arr[pos-gap];
                        arr[pos-gap] = tmpTmp;
                        str = new String(arr);
                        show(str);
                    }

                }
            }
        }
        return  str;
    }

    //utility method to print array
    static void show(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) + ",");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        ss.shellSort("EASYSHELLSORTQUESTION");
    }
}
