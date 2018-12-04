
/**
 * CountWordsDictionary
 */

import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class CountWordsDictionary {

    public static int horner(String s, int a) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            result = s.charAt(i) + (a * result);
        return result;
    }

    public static int cyclicShift(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); ++i) {
            h = (h << 7) | (h >>> 25);
            h += (int) s.charAt(i);
        }
        return h;
    }

    public static int hashCode(String s) {
        int hash = 0;
        int skip = Math.max(1, s.length() / 8);
        for (int i = 0; i < s.length(); i += skip)
            hash = (hash * 37) + s.charAt(i);
        return hash;

    }

    public static void main(String[] args) throws FileNotFoundException {

        int[] collisions = { 0, 0, 0, 0 };
        File doc = new File("../words.txt");

        for (int i = 0; i < 4; i++) { // loop for each method
            Scanner docScan = new Scanner(doc).useDelimiter("[^a-zA-Z]+");
            Set<Integer> set = new HashSet<>();
            set.clear();
            while (docScan.hasNext()) {
                String word = docScan.next();

                // check which method to use
                int code = (i == 0 ? horner(word, 41)
                        : (i == 1 ? horner(word, 17) : (i == 2 ? cyclicShift(word) : (i == 3 ? hashCode(word) : 0))));
                if (!set.add(code)) {
                    collisions[i]++;
                }

            }

        }

        System.out.printf("Collisions using polynomial evaluation with 41:\t\t%d\n", collisions[0]);
        System.out.printf("Collisions using polynomial evaluation with 17:\t\t%d\n", collisions[1]);
        System.out.printf("Collisions using a cyclic shift with 7:\t\t\t%d\n", collisions[2]);
        System.out.printf("Collisions using the old java hashCode:\t\t\t%d\n", collisions[3]);

    }

}