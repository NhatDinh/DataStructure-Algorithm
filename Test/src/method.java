import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.common.value.qual.MinLen;

public class method {
    int[] content;
    @NonNegative @LTLengthOf("this.content") int index;
    public int method() {
        return content[index];
    }


        /*
        for (int i = 0; i < x; i++) {
            for (int z = 0; z < y; z++) {
                array[x][y] = x;
            }
            array[y][x] = y;
        }
        */

    public static void main(String args[]) {

    }
}
