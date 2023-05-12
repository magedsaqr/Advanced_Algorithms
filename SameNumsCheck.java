import java.util.Arrays;
//create a public class named SameNumsChecker
public class SameNumsChecker{
    public static void main(String[] args){
// initialize two integer arrays with values
        int[] array_1 = {1, 2, 3, 4, 5};
        int[] array_2 = {5, 0, 3, 2, 1};

//sort the arrays in ascending order
        Arrays.sort(array_1);
        Arrays.sort(array_2);

//Check if the sorted arrays have the same set of numbers
        boolean SameNums = Arrays.equals(array_1, array_2);
//print the output
        System.out.println("Do both arrays have the same set of numbers? \n" + SameNums);
    }
}
