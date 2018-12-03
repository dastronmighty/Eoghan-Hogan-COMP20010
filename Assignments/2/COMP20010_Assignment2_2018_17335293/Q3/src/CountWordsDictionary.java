
/**
 * CountWordsDictionary
 */

import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;

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

    public static int countCollisions(Map<Integer, Integer> m) {
        int collisions = 0;
        for (Entry<Integer, Integer> ent : m.entrySet()) {
            if (ent.getValue() > 1) {
                collisions += ent.getValue();
            }
        }
        return collisions;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Map<Integer, Integer> poly41 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> poly17 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> shift7 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> javaHash = new HashMap<Integer, Integer>();

        File doc = new File("../words.txt");

        Scanner docScan = new Scanner(doc).useDelimiter("[^a-zA-Z]+");

        while (docScan.hasNext()) {
            String word = docScan.next();

            int hashed = horner(word, 41); // get hash code of word
            Integer count = poly41.get(hashed); // get the count of how many times that hash has appeared
            if (count == null)
                count = 0;
            poly41.put(hashed, 1 + count); // add 1 to the count of that unique hash

            hashed = horner(word, 17);
            count = poly17.get(hashed);
            if (count == null)
                count = 0;
            poly17.put(hashed, 1 + count);

            hashed = cyclicShift(word);
            count = shift7.get(hashed);
            if (count == null)
                count = 0;
            shift7.put(hashed, 1 + count);

            hashed = hashCode(word);
            count = javaHash.get(hashed);
            if (count == null)
                count = 0;
            javaHash.put(hashed, 1 + count);

        }

        System.out.printf("Collisions using polynomial evaluation with 41:\t\t%d\n", countCollisions(poly41));
        System.out.printf("Collisions using polynomial evaluation with 17:\t\t%d\n", countCollisions(poly17));
        System.out.printf("Collisions using a cyclic shift with 7:\t\t\t%d\n", countCollisions(shift7));
        System.out.printf("Collisions using the old java hashCode:\t\t\t%d\n", countCollisions(javaHash));

    }

}