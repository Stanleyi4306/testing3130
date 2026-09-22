/*
 * Name:  Stanley Ihunyere
 * Prgramming language:  Java  
 * IDE: VS Code
 */

public class hw2 {
    public static void main(String[] args) {
// Part 2 - Create your own data set
        int arr[] = {44, 12, 37, 64, 90, 23, 78, 58, 85, 20, 11, 67};
        System.out.println("Original array: \n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Bubble Sort Result: \n");
        bubbleSort(arr);
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

        int arr2[] = {44, 12, 37, 64, 90, 23, 78, 58, 85, 20, 11, 67};
        System.out.println("Merge Sort Result: \n");
        mergeSort(arr2);
        for (int array : arr2) { System.out.print(array + " "); }
        System.out.println("\n");

        // Part 8 - linear search test cases
        System.out.println("Linear Search \n");
        int arr3[] = {9, 21, 43, 59, 92, 56, 33, 20, 69, 88, 11, 30};
      // linearSearch(arr3, 43, 0);
      System.out.println("Searching for 88 \n");
      linearSearch(arr3, 88, 0);
      // linearSearch(arr3, 73, 0);
       System.out.println("\n");

        // Part 10 - test cases 
        System.out.println("Binary Search \n");
     //  int result = binarySearch(arr, 85);
       int result2 = binarySearch(arr, 12);
       System.out.println("Searching for 12 \n");
       System.out.println(result2 == -1 ? "Target not found" : "Target found at index: " + result2);
     //  int result3 = binarySearch(arr, 100);
        
      //  System.out.println((result2 == -1) ? "Target not found" : "Target found at index: " + result2);
     //   System.out.println((result3 == -1) ? "Target not found" : "Target found at index: " + result3);


    } // Part 3 - Bubble Sort Algorithm
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i<arr.length-1; i++) {
            // Last i elements are already in place
            for (int j =0; j<arr.length-1-i; j++) { 
                if (arr[j] > arr[j+1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        

    }
    

// Part 4 
/**
 Question 1
What is the worst-case Big O time complexity of Bubble Sort?  
Answer: 0(n^2)

Question 2
Why does Bubble sort have this time complexity?
Answer: Because it uses nested loops, and in the worse case, it has to compare every element with every other element.

Question 3
If Bubble Sort processes 10 elements, approximately how many comparisons could be required compared with 1,000 elements?
Answer:
It can be up to n^2 comparisons so 1,000^2, which is 1,000,000 comparisons. For 10 elements, it would be 100 comparisons.
 */

// Part 5 - Merge Sort: Create a second function or method that sorts the original unsorted array using Merge Sort.

public static void mergeSort(int [] array) {

    int length = array.length;
    if (length <= 1) {return;} // base case
    
    int middle = length / 2;
    int [] leftArray = new int[middle];
    int [] rightArray = new int[length - middle];

    int i = 0; // index for left array
    int j = 0; // index for right array
    for (; i < length; i++) { // this loop adds elements to the left and right arrays
        if (i < middle) {
            leftArray[i] = array[i];
        } else {
            rightArray[j] = array[i];
            j++;
        }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);

    }
private static void merge(int [] leftArray, int [] rightArray, int [] array) {

    int leftSize = array.length / 2; // size of left array
    int rightSize = array.length - leftSize; // size of right array
    // check the condition for merging 
    int L = 0, r = 0, i = 0; // L is index for left array, r is index for right array, i is index for merged array
    while (L < leftSize && r < rightSize) { 
        // compare the elements of left and right array and merge them in sorted order
        if (leftArray[L] <= rightArray[r]) {
            array[i] = leftArray[L]; // if left element is smaller, add it to the merged array
            i++;
            L++;
        } else {
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
    // copy the remaining elements of left array, if any
    while (L < leftSize) {
        array[i] = leftArray[L];
        i++;
        L++;
    }
    // do the same for the right array
    while ( r < rightSize) {
        array[i] = rightArray[r];
        i++;
        r++;
    }
}

// Part 6
/**
 * Question 4
 * What is the Big O time complexity of Merge Sort?
 * Answer: O (n log n)
 * 
 * Question 5
 * Which algorithm generally performs better when the amount of data becomes very large?
 * Answer:
 * Merge sort performs better on larger datasets because it has a complexity of O(n log n),
 * whreas bubble sort has a complexity of O(n^2). Using a divde and conquer approach, merge
 * sort recursively divdes the data into smaller subarrays, and merges them back together in 
 * sorted order, avoiding the nested loop comparison that bubble sort uses which causes bubble
 * sort to be slower as data grows larger.
 * 
 * 
 * Question 6:  Complete the following
 * 
 * Bubble Sort = O(n^2)
 * Merge Sort = O(n log n)
 */



// Part 7
/**
 * Question 7: Using your original unsorted array, create a function or method that performs Linear Search.
 */

public static void linearSearch(int arr[], int target, int index) {
   if (index == arr.length) {
    System.out.println("Target not found");
    return;
   }

   if (arr[index] == target) {
    System.out.println("Target found at index: " + index);
    return;
   }

   linearSearch(arr, target, index + 1); // recursive call to search the next index

   }

   // Part 9: Binary Search
    /**
     * Use your sorted array from Bubble Sort or Merge Sort.

        Create a function or method that performs Binary Search.
    Binary Search must:

    Identify the middle value.
    Compare the target to the middle value.
    Eliminate half of the remaining search area.
    Continue until the target is found or no values remain
     */

    public static int binarySearch(int arr[], int target) {
        
        int left = 0;
        int right = arr.length - 1; // which is the last index of the array

        while (left <= right) {
            int mid = left + (right - left) / 2; // middle index
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; // check the right half of array
            } else {
                left = mid + 1; // check the left half of array
            }
        }
        return -1; // target not found
    }

}

// Part 11 Searching questions - Answer each question in 2–4 sentences.

/**
 * Question 7: What is the Big O time complexity of Linear Search?
 * Answer: O(n) because the  maximum number of comparisons you have to make scales
 * linearly with the size of the input data set. In the worse case, you may have to 
 * check every element in the array to find the target value. Best case being 0(1) 
 * if the target is found at the first index.
 * 
 * 
 * Question 8: What is the Big O time complexity of Binary Search?
 * Answer: O(log n)
 * Part of the reason is because the array must be sorted. It looks at
 * the middle element of the array, if the target is less than the middle 
 * element, it eliminates the right half of the array, and if greater, it
 * eliminates the left half of the array. This process continues until the 
 * target is found or no elements remain.
 * 
 * Question 9: Why does Binary Search require sorted data?
 * Answer: It requires sorted data because if not sorted it can mistakenly eliminate half 
 * of the array that may contain the target value. Which will cause it to return an incorrect result.
 * 
 * Question 10: Which search would you use if the data were not sorted?
 * Answeer: I would use linear search becaue I wouldn't have to worry
 * about my list being sorted and I can just compare every element in
 * the array to the target until the target is found or until the end is reached.
 * 
 * Question 11: Which search would generally be better for a very large sorted array?
 * Answer: Binary Search because if my target is less than the middle element,
 * I can eliminate the whole right half of the array, making the data smaller and 
 * smaller until the target is found.
 * 
 * 
 * Part 12 - Algorithm Comparison Table
 * 
 *  Algorithm    | Purpose  | Big O
 *  Bubble Sort  | Sorting  | O(n^2)
 *  Merge Sort   | Sorting  | O(n log n)
 *  Linear Search| Searching| O(n)
 *  Binary Search| Searching| O(log n) 
 * 
 * 
 */


