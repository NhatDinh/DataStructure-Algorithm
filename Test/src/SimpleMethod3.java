import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.LTOMLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.common.value.qual.MinLen;

public class SimpleMethod3 {
    @NonNegative int size;
    int[] vDown = new int[size];
    //simpler version
    void method3(@NonNegative int size,@NonNegative int value){
        this.size = size;
        this.vDown = new int[this.size];
        vDown[1 + value] = 10;
    }
    public static void main(String args[]) {
    }
}

/*
    void method3(@NonNegative int size,@NonNegative int value){
        @NonNegative int offset = value;
        this.size_init = size;
        vDown[1 + offset ] = value;

    }
    */
