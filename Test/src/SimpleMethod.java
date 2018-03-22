import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;

public class SimpleMethod {
    @NonNegative protected int size;
    int[] arr = new int[size];
    void method1(int[] arr_m,@IndexFor(value = {"#1","this.arr"}) int m){
        @NonNegative int n = m;
        int[] arr_n = new int[n];

        //array accesses
        this.arr[m] = m+1;
        this.arr[n] = n+1;
        arr_n[n] = m+1;
        arr_m[m] = arr_n[n];
    }
    public static void main(String args[]) {
    }
}

/*
@NonNegative @IndexFor(value = {"#1"})
@NonNegative @IndexFor("arr_n")

    void method2(int[] arr, @NonNegative @LTLengthOf(value = "#1") int m){
        @NonNegative @IndexFor("arr") int n = m;
        int[] array = new int[n];
        array[n] = 0;
    }
    */