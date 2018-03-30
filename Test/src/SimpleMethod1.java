import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;

public class SimpleMethod1 {
    int[] fields_arr = new int[10];
    void simpleMethod( @IndexFor(value = {"this.fields_arr", "para_arr","local_arr"}) int i, int[] para_arr) {
        int[] local_arr = new int[10];
        this.fields_arr[i] = i;
        para_arr[i] = i;
        local_arr[i] = i;
    }
    public static void main(String args[]) {
    }
}

/*
 public class SimpleMethod1{

    int[] fields_arr = new int[10];
    void simpleMethod(@NonNegative @IndexFor("this.fields_arr") int i, int[] para_arr) {
        int[] local_arr = new int[10];
        this.fields_arr[i] = i;
        //local_arr[i] = i;
    }
    public static void main(String args[]) {
    }
}
*/



