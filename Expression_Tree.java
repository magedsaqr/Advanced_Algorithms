// Import Stack
import java.util.Stack;
//create a class named Node that has character data and chid nodes left and right
class Node {
    char data;
    Node Left, Right;
// constructor to initialize the attributes
    public Node(char data) {
        this.data = data;
        this.Left = null;
        this.Right = null;
    }
}
//create a class ExpressionTree that has variable root(the root of the tree) 
class ExpressionTree {
    Node root;

    public ExpressionTree() {
        this.root = null; //initialize to null
    }
//create method buildTree that takes a string representation of an arithmetic expression and builds an expression tree from it using stacks.
    public void buildTree(String expression) {
        Stack<Node> stack = new Stack<Node>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                Node node = new Node(c);
                stack.push(node);
            } else if (c == ')') {
                Node Right = stack.pop();
                
                Node operator = stack.pop();
                
                Node Left = stack.pop();
                
                operator.Left = Left;
                
                operator.Right = Right;
                
                stack.push(operator);
            } else {
                Node node = new Node(c);
                stack.push(node);
            }
        }
        this.root = stack.pop();
    }
// create method printTree that prints the tree in a suitable format
    public void printTree() {
        printSubtree(this.root, "");
    }
// create helper method printSubtree that prints the tree nodes recursively
    private void printSubtree(Node node, String indent) {
        if (node == null) {
            System.out.println(indent + "-");
            return;
        }
        System.out.println(indent + node.data);
        printSubtree(node.Left, indent + "  ");
        printSubtree(node.Right, indent + "  ");
    }
// create method evaluate that evaluates the arithmetic expression and returns the result
    public int evaluate() {
        return evaluateNode(this.root);
    }
// create helper method evaluateNode that evaluates the expression recursively. 
    private int evaluateNode(Node node) {
        if (node.Left == null && node.Right == null) {
            return Character.getNumericValue(node.data);
        } else {
            int leftValue = evaluateNode(node.Left);
            int rightValue = evaluateNode(node.Right);
            switch (node.data) {
                case '-':
                    return leftValue - rightValue;
                case '+':
                    return leftValue + rightValue;
                case '/':
                    return leftValue / rightValue;
                case '*':
                    return leftValue * rightValue;
                default:
                    return 0;
            }
        }
    }
// construct, print, and evaluate expression tree, and print the result.
    public static void main(String[] args) {
        String expression = "(((5+3)*2))/6)";
        ExpressionTree tree = new ExpressionTree();
        tree.buildTree(expression);
        tree.printTree();
        System.out.println("Value: " + tree.evaluate());
    }
}
