
import org.checkerframework.checker.index.qual.LTLengthOf;
import org.checkerframework.checker.index.qual.NonNegative;

public class SimpleMethod1{
    static String simpleMethod(int i, String str) {
        int CONSTANT = 10;
        char[] array = new char[CONSTANT];

        array[i] = str.charAt(i);
        return str;
    }
    public static void main(String args[]) {
        simpleMethod(11, "whatever");
    }
}

 /*
        boolean[] lookUpArray = new boolean[256];
        for (@NonNegative @LTLengthOf("lookUpArray") int i = 0; i < remove.length(); ++i) {
            lookUpArray[(int) remove.charAt(i)] = true;
        }
        for (@NonNegative @LTLengthOf("lookUpArray") int j = 0; j < str.length(); ++j) {
            if (lookUpArray[(int) str.charAt(j)] == true) {
                continue;
            }
        }
        */
 /*
        for (int index = 1; index < values.length; index++) {
            double value = values[index];
            if (isFinite(value) && isFinite(mean)) {
                // Art of Computer Programming vol. 2, Knuth, 4.2.2, (15)
                mean += (value - mean) / (index + 1);
            } else {
                mean = calculateNewMeanNonFinite(mean, value);
            }
        }
        */