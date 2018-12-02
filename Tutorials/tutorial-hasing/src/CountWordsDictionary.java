
/**
 * CountWordsDictionary
 */

import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;

public class CountWordsDictionary {

    // Function that returns value of poly[0]x(n-1) +
    // poly[1]x(n-2) + .. + poly[n-1]
    public static int horner(int poly[], int x) {
        // Initialize result
        int result = poly[0];
        // Evaluate value of polynomial using Horner's method
        for (int i = 1; i < poly.length; i++) {
            result = result * x + poly[i];
        }

        return result;
    }

    public static int[] createPoly(String s) {
        int[] poly = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            poly[i] = (i % 2 == 0 ? 1 : -1) * s.charAt(i);
        }
        return poly;
    }

    public static int polynomialEvalution(String s, int a) {
        int[] poly = createPoly(s);
        return horner(poly, a);
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

        int mod = 1000000;

        Scanner docScan = new Scanner(doc).useDelimiter("[^a-zA-Z]+");
        while (docScan.hasNext()) {
            String word = docScan.next();

            int hashed = polynomialEvalution(word, 41) % mod;
            Integer count = poly41.get(hashed);
            if (count == null)
                count = 0;
            poly41.put(hashed, 1 + count);

            hashed = polynomialEvalution(word, 17) % mod;
            count = poly17.get(hashed);
            if (count == null)
                count = 0;
            poly17.put(hashed, 1 + count);

            hashed = cyclicShift(word) % mod;
            count = shift7.get(hashed);
            if (count == null)
                count = 0;
            shift7.put(hashed, 1 + count);

            hashed = hashCode(word) % mod;
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