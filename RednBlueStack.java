public class RednBlueStack {
    private int[] StackArr; // create an array that stores the two stacks' elements
    private int topRed; // index of the top of the red stack
    private int topBlue; // index of the top of the blue stack

    // constructor to initialize the StackArr and top indices
    public RednBlueStack(int C) {
        StackArr = new int[C];
        topRed = -1;
        topBlue = C;
    }

    // push an element onto the red stack
    public boolean pushRed(int value) {
        if (topRed + 1 < topBlue) { // check if there is space in the array for the new element
            StackArr[++topRed] = value; // increment topRed and add the new element to the array
            return true;
        } else {
            return false;
        }
    }

    // push an element onto the blue stack
    public boolean pushBlue(int value) {
        if (topBlue - 1 > topRed) { // check if there is space in the array for the new element
            StackArr[--topBlue] = value; // decrement topBlue and add the new element to the array
            return true;
        } else {
            return false;
        }
    }

    // pop an element off the red stack
    public Integer popRed() {
        if (topRed >= 0) { // check if there are any elements in the red stack
            return StackArr[topRed--]; // return the top element and decrement topRed
        } else {
            return null; // stack is empty
        }
    }

    // pop an element off the blue stack
    public Integer popBlue() {
        if (topBlue < StackArr.length) { // check if there are any elements in the blue stack
            return StackArr[topBlue++]; // return the top element and increment topBlue
        } else {
            return null; // stack is empty
        }
    }

    // peek at the top element of the red stack
    public Integer peekRed() {
        if (topRed >= 0) { // check if there are any elements in the red stack
            return StackArr[topRed]; // return the top element
        } else {
            return null; // stack is empty
        }
    }

    // peek at the top element of the blue stack
    public Integer peekBlue() {
        if (topBlue < StackArr.length) { // check if there are any elements in the blue stack
            return StackArr[topBlue]; // return the top element
        } else {
            return null; // stack is empty
        }
    }

    // check if the red stack is empty
    public boolean RedIsEmpty() {
        return topRed == -1;
    }

    // check if the blue stack is empty
    public boolean BlueIsEmpty() {
        return topBlue == StackArr.length;
    }

    public static void main(String[] args) {
        RednBlueStack stack = new RednBlueStack(100); // create a new RednBlueStack with capacity 100

        // testing the implemented methods
        stack.pushRed(1);
        stack.pushRed(2);
        stack.pushRed(3);
        stack.pushBlue(4);
        stack.pushBlue(5);
        stack.pushBlue(6);

        stack.popRed();
        stack.popBlue();
        stack.peekRed();
        stack.peekBlue();

        System.out.println("Elements in Red Stack:");
        // print the elements of the red stack 
        while (!stack.RedIsEmpty()) {
            System.out.println(stack.popRed());
        }

        System.out.println("Elements in Blue Stack:");
        // print the elements of the blue stack 
        while (!stack.BlueIsEmpty()) {
            System.out.println(stack.popBlue());
        }
    }
}
