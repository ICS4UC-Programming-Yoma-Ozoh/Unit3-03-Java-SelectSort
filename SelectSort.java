import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads unsorted numbers from a file,
 * sorts them using Selection Sort, and writes them to a file.
 *
 * @author  Yoma Ozoh
 * @version 1.0
 * @since   2026-11-24
 */
public final class SelectSort {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private SelectSort() {
    }

    /**
     * Sorts an array of integers using the selection sort algorithm.
     *
     * @param listOfNum Array of integers to be sorted
     */
    public static void selectionSort(final int[] listOfNum) {
        // Get the length of the integer array
        final int n = listOfNum.length;
        // Loop through the array to find the smallest number for each position
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Loop through the rest of the
            //  unsorted array to find a smaller number
            for (int j = i + 1; j < n; j++) {
                // Check if the current number is
                // smaller than the current smallest
                if (listOfNum[j] < listOfNum[minIndex]) {
                    // Update the index of the smallest number
                    minIndex = j;
                }
            }

            //  store the number in temp
            final int temp = listOfNum[i];
            // Move the absolute smallest number found
            // into the current starting position
            listOfNum[i] = listOfNum[minIndex];
            // Move the temporarily stored number to
            // where the smallest number used to be
            listOfNum[minIndex] = temp;
        }
    }

    /**
     * Main method to execute file reading and sorting.
     *
     * @param args Command line arguments
     * @throws FileNotFoundException If an input file is not found
     */
    public static void main(final String[] args) throws FileNotFoundException {
        // Scanner object that reads the input file
        final Scanner scanner = new Scanner(new File("input.txt"));
        // PrintWriter object that writes to the output text file
        final PrintWriter writer = new PrintWriter(new File("output.txt"));
        // Loop through the file as long as there is another line of text
        while (scanner.hasNextLine()) {
            // Read the entire line of text into a String variable
            final String line = scanner.nextLine();
            // Skip the line if it is completely empty
            if (line.isEmpty()) {
                // Move to the next line in the loop
                continue;
            }
            // Split the line by spaces
            final String[] stringNumbers = line.split(" ");
            // Create a new integer array that has same size as the string array
            final int[] numbers = new int[stringNumbers.length];
            // Loop through every item in the string array
            for (int i = 0; i < stringNumbers.length; i++) {
                // Convert the string into an integer and save it in the array
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }

            // Pass the integer array to selection Sort to be sorted
            selectionSort(numbers);

            // Loop through the sorted integer array
            for (int i = 0; i < numbers.length; i++) {
                // Write the number to the output file
                writer.print(numbers[i]);
                // Check if the current number isn't the last one in the array
                if (i < numbers.length - 1) {
                    // Write a space after the number
                    writer.print(" ");
                }
            }
            // Move to the next line in the output file
            writer.println();
        }

        // Close the scanner so it stops reading the file
        scanner.close();
        // Close the writer so it saves the file properly
        writer.close();
        // Print a message to the console showing it finished
        System.out.println("Sorting done");
    }
}
