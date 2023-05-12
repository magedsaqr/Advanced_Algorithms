//create public class MinHeapSort
public class MinHeapSort {
    public void Sort(int[] arr){
        
        int n = arr.length;

        // construct min heap
        for (int i=n / 2 - 1; i>=0; i--){
            // Starting from the last non-leaf node
            Heap(arr,n,i);
        }

        // take elements from the min heap in sorted order
        for (int i = n - 1; i >= 0; i--){
            // Swap the last element with the root element in heap
            int temp = arr[0];

            arr[0] = arr[i];

            arr[i] = temp;

            // Restore the heap property for the remaining elements
            Heap(arr, i, 0);
        }
    }

    // Helper function to heapify a subtree rooted at index i
    private void Heap(int[] arr, int n, int i){
        // Find the smallest element among the root, left child and right child
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]){
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]){
            smallest = right;
        }

        // Swap and continue heaping if root is not smallest
        if (smallest != i){
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            Heap(arr, n, smallest);
        }
    }
    

    // Function to print an array
    public static void NewArray(int[] arr){
        // Iterate over the elements of the array and print them to the console
        for (int value : arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args){
        // Create an input array
        int[] arr = { 1, 12, 7, 15, 6, 19 };

        // Create an instance of the MinHeapSort class and call the Sort method to sort the array
        MinHeapSort MHS = new MinHeapSort();
        MHS.Sort(arr);

        // Print the sorted array to the console
        System.out.println(" New sorted array:");
        NewArray(arr);
    }

}