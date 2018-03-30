import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.LTOMLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.common.value.qual.MinLen;

public class SimpleMethod3 {
    @NonNegative @LTLengthOf(value = {"this.array1","this.array2"}, offset = "1") int offset;
    int[] array1 = new int[10];
    int[] array2 = new int[10];

    void simple(int val,@NonNegative int offset){
        this.offset = offset;
        array1[1 + offset] = val;
        array2[1 + offset] = val;

    }
    public static void main(String args[]) {
    }
}
