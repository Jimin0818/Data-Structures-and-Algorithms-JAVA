package Assignment3;
/*
1- generate random integer number array. It is recommended that you try different number ranges and distributions
to see which will give better differentiator results between algorithms.
2- sort the array using Insertion Sort, Heap Sort, Merge Sort and Quick Sort by calling their
corresponding methods sequentially.
3- record the time lapse each algorithm method takes to complete sorting the array.
4- BONUS: record the maximum memory usage each algorithm method takes to complete sorting the array.
 */

import java.util.Arrays;

public class ArraySort {

    //Condition 1: This method generates an array with the size "size: and inserts random numbers (between 1 to 100) into the array 
	//This method has a time complexity of O(N).
    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    //Condition 2: Sorts the given array using the different kinds of sorting algorithms
    
    //Insertion Sort
    //The best-case scenario is when the list is presorted with no data movement. Time Complexity of O(N).
    //The worst-case scenario is when the list of inverted. Hence, then algorithm will need p+1 comparisons for each pass. 
    //Time Complexity of O(N^2).
    private static int[] insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) { //If left value is greater than right value, it shifts all the values and inserts the right value(key)
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        return arr;
    }
    //Condition 3: Calculates the time for the insertion sort
    //Has time complexity of N(1), but calls the insertionSort method which has complexity of O(N) - O(N^2)
    private static double insertSortTime(int[] arr) {
    	 double startTime = System.nanoTime(); 
         insertionSort(arr);
         return (System.nanoTime() - startTime); 
    }
    
    //Heap Sort:
    //For the N nodes in the heap, it deletes the max, and store the delete key value at the end of the array
    //The time complexity of this sorting algorithm is O(N log N).
    private static void heapSort(int[] arr) {
        int N = arr.length;
        //Sorts the array into Max Heap
        for (int i = N / 2 - 1; i >= 0; i--)
            heap(arr, N, i);
        //Deletes and stores the max value, then replace the max (root) with the minimum, then sorts the tree again
        for (int i = N - 1; i > 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
    }

    //This method is apart of the heapSort() method, it creates the Max heap
    public static void heap(int []arr, int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < N && arr[l] > arr[largest])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heap(arr, N, largest);
        }
    }
    
    //Condition 3: Calculates the time for the heap sort algorithm 
    //Has time complexity of N(1), but calls the heapSort method which has complexity of O(NLOGN)
    private static double heapSortTime(int[] arr) {
    	double startTime = System.nanoTime();
        heapSort(arr);
        return (System.nanoTime() - startTime);
    }
    
    //Merge Sort: Time complexity of O(n log n)
    private static void mergeSort(int[] arr) {
        if (arr.length > 1)
        {	
        	
        	//Splits each of the array in the middle into two until each subarray only contains one value
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            
            //Recursively calls itself until the condition mentioned above is true 
            mergeSort(left);
            mergeSort(right);
            
            //Sorts the individual arrays
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length)
            {
                if (left[i] < right[j])
                {
                    arr[k++] = left[i++];
                }
                else
                {
                    arr[k++] = right[j++];
                }
            }
            //Merges the separated subarrays back together left first then right side
            while (i < left.length)
            {
                arr[k++] = left[i++];
            }

            while (j < right.length)
            {
                arr[k++] = right[j++];
            }
        }
    }
    //Condition 3: Calculates the time for the heap sort algorithm 
    //Has time complexity of N(1), but calls the mergeSort method which has complexity of O(NLOGN)
    private static double mergeSortTime(int[] arr) {
    	double startTime = System.nanoTime();
        mergeSort(arr);
        return (System.nanoTime() - startTime);
    }
    
    
    //Quick Sort:
    //This sorting algorithm has a best case time complexity of  O(n log n) when the pivot is assume to be always in the middle
    //and a worst case complexity of O(N^2)
    private static int[] quickSort(int[] arr, int low, int high, int cutoff) {
    	//When the subarray is smaller than the cutoff, it sorts the values
        if (arr.length <= cutoff)
        {
            insertionSort(arr);
        }
        //Makes sure it is in bound before dividing
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1, cutoff);
            quickSort(arr, pivotIndex + 1, high, cutoff);
        }
        return arr;
    }

    //This is a helper method called by the quickSort method to partition the array 
    //The time complexity of this method is O(N)
    private static int partition(int[] arr, int low, int high)
    {	
    	//Pivot is the last value of the array
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    //This is a helper method called by partition method which will move the current position into a temp 
    //to shift new value 
    //This method has a time complexity of O(1)
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Quick Sort with no cutoff 
    private static double quickSortNoCutTime(int[] arr) {
    	double startTime = System.nanoTime();
        quickSort(arr, 0, arr.length-1, 0);
    	return (System.nanoTime() - startTime);
    }
    //Quick Sort with cutoff of 10
    private static double quickSortCut10Time(int[] arr) {   
    	double startTime = System.nanoTime();
        quickSort(arr,0,arr.length-1, 10);
    	return (System.nanoTime() - startTime);
    }
    //Quick Sort with cutoff of 50
    private static double quickSortCut50Time(int[] arr) {
    	double startTime = System.nanoTime();
         quickSort(arr, 0, arr.length-1,50);
    	return (System.nanoTime() - startTime);
    }
    //Quick Sort with cutoff of 200
    private static double quickSortCut200Time(int[] arr) {
    	double startTime = System.nanoTime();
        quickSort(arr, 0, arr.length-1,200);
    	return (System.nanoTime() - startTime);
    }

    // This is the Main method: This method contains an enhanced for loop to generate all the required array sizes (s 50, 500, 1,000, 2,000, 5,000 and 10,000)
    // and then print out the time taken for each of the sorting algorithms
    public static void main(String[] args) {
        int[] sizes = {50, 500, 1000, 2000, 5000, 10000};
        for (int size : sizes) {
            System.out.println("FOR " + size + " ELEMENTS");
            int[] arr = generateArray(size);
            System.out.println("Insertion Sort with " + size + " Elements takes " + insertSortTime(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Heap Sort with " + size + " Elements takes " + heapSortTime(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Merge Sort with " + size + " Elements takes " + mergeSortTime(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Quick Sort with no cutoff and " + size + " Elements takes " + quickSortNoCutTime(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Quick Sort with 10 cutoff and " + size + " Elements takes " + quickSortCut10Time(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Quick Sort with 50 cutoff and " + size + " Elements takes " + quickSortCut50Time(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");
            System.out.println("Quick Sort with 200 cutoff and " + size + " Elements takes " + quickSortCut200Time(Arrays.copyOf(arr, arr.length)) + " Nanoseconds");   
            System.out.println();
        }
    }
    
}
