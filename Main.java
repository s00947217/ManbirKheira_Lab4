// Lab 4 - Sorting Algorithms (Bubble Sort and Insertion Sort)
// Your Name: Manbir S Kheira

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        // Bubble sort implementation with timing
        System.out.println("\n\nBubble sort results ----------------------------------------------");
        long startTimeBubble = System.nanoTime(); // * Start timing for bubble sort
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(new ArrayList<>(integerList)); // passing a copy of integerList
        long endTimeBubble = System.nanoTime(); // * End timing for bubble sort
        Lab4.outputList(bubbleSortedList);
        long elapsedTimeBubble = endTimeBubble - startTimeBubble; // * Calculate elapsed time for bubble sort
        System.out.println("\nBubble Sort Time: " + elapsedTimeBubble + " nanoseconds");

        // Insertion sort implementation with timing
        System.out.println("\n\nInsertion sort results -------------------------------------------");
        long startTimeInsertion = System.nanoTime(); // * Start timing for insertion sort
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(new ArrayList<>(integerList)); // passing a copy of integerList
        long endTimeInsertion = System.nanoTime(); // * End timing for insertion sort
        Lab4.outputList(insertionSortedList);
        long elapsedTimeInsertion = endTimeInsertion - startTimeInsertion; // * Calculate elapsed time for insertion sort
        System.out.println("\nInsertion Sort Time: " + elapsedTimeInsertion + " nanoseconds");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        // Step 1 - Implement insertion sort algorithm here
      
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;

            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j = j - 1;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        // Step 2 - Implement the bubble sort algorithm here
       
        int n = integerList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    // Swap integerList[j] and integerList[j + 1]
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.println();
    }
}

// Question: If you were implementing a sort algorithm for a new language, which sort would you use?
// Answer: I think I would use insertion sort for smaller lists because it's more simple to do. Bubble sort not so good for big data, it’s too slow.

// Question: Was there a difference in time taken by bubble sort and insertion sort?
// Answer: Yes, insertion sort was faster. Bubble sort takes more time because it has bigger time complexity (O(n^2)), so makes sense.

// Question: Which sort algorithm has an easier implementation (in terms of understanding) to you?
// Answer: Bubble sort feels simpler for me because it’s just keep swapping elements until sorted. Easy to see what it’s doing.

