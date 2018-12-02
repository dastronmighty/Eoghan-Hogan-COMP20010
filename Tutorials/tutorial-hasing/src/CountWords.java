
/**
 * CountWords
 * 
 * count the words from the sampletext file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class CountWords {

    private static void addToArray(int freq, String str, int[] freqList, String[] strList) {
        for (int i = 0; i < 10; i++) {
            if (freq > freqList[i]) {
                for (int j = 9; j > i; j--) {
                    freqList[j] = freqList[j - 1];
                    strList[j] = strList[j - 1];
                }
                freqList[i] = freq;
                strList[i] = str;
                break;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Integer> freq = new HashMap<String, Integer>();

        File doc = new File("../sampletext.txt");

        Scanner docScan = new Scanner(doc).useDelimiter("[^a-zA-Z]+");
        while (docScan.hasNext()) {
            String word = docScan.next().toLowerCase();
            Integer count = freq.get(word);
            if (count == null)
                count = 0;
            freq.put(word, 1 + count);
        }

        int[] freqArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        String[] strArr = new String[10];
        for (Entry<String, Integer> ent : freq.entrySet()) {
            addToArray(ent.getValue(), ent.getKey(), freqArr, strArr);
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-15s\tappeared\t%d times%s\n", strArr[i], freqArr[i],
                    (i == 0 ? " (the most)" : (i == 9 ? " (the 10th most)" : "")));
        }

    }
}