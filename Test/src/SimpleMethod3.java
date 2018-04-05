import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.LTOMLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.common.value.qual.MinLen;

public class SimpleMethod3 {
    @NonNegative @LTLengthOf(value = {"this.arr1","this.arr2"}, offset = {"1","0"}) int offset;
    int[] arr1 = new int[10];
    int[] arr2 = new int[10];

    void simple(int val){
        arr1[this.offset + 1] = val;
        arr2[this.offset] = val;
    }
    public static void main(String args[]) {
    }
}
