import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * RecursiveFileFinder
 * 
 * This program takes in a directory and then finds every Java file in that
 * directory
 */
public class RecursiveFileFinder {

    /***
     * Count files in a directory (including files in all subdirectories)
     * 
     * @param directory the directory to start in
     * @return the total number of file
     */
    private static int recursiveCounter(File[] dir) {
        int count = 0;
        for (File file : dir) {
            if (file.isDirectory()) {
                count += recursiveCounter(file.listFiles());
            } else if (file.isFile() && file.getName().endsWith(".java")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.printf(
                "====================\nJava File Finder V.42\n====================\n\n\nPlease enter a Directory to search: ");
        Scanner scanner = new Scanner(System.in);

        try {
            String path = scanner.nextLine();
            File startfile = new File(path);

            long startTime = System.currentTimeMillis();

            int amount = recursiveCounter(startfile.listFiles());

            final long elapsedTimeMillis = System.currentTimeMillis() - startTime;

            System.out.printf("\n\nfiles found\t%d\nprogram took\t%d mili seconds\n", amount, elapsedTimeMillis);

        } catch (Exception e) {
            System.out.printf("Sorry we couldn't find the directory you entered\n");
        }

    }
}