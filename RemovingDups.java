import java.util.Arrays;
public class DupsRemover{
    public static void main(String[] args){
    // Create a character array consiting of duplicates
    char[] arr = {'m', 'a', 'g', 'e', 'd', 'd', 'e'};
    // Sort array
    Arrays.sort(arr);
  // Create a new array to store unique characters in it
    char[] newArray = new char[arr.length];
  // create a variable to track the last unique character in the new array
    int uniqIndex = 0;
    // Loop through each character in the sorted array
    for (int i = 0; i < arr.length; i++){         
    // Check if the current character is the first character or different from the previous character
        if (i == 0 || arr[i] != arr[i - 1]){
    // Add the current character to the new array at the next available position
            newArray[uniqIndex] = arr[i];
            uniqIndex++;
            }
        }
 	 // Print the new array that has no duplicates
        System.out.print("New array : ");
        for(int i = 0; i < uniqIndex; i++){
            
            System.out.print(newArray[i] + " ");
        }
    }
}
