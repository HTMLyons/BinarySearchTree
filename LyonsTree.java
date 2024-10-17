//scanner to receive user input

import java.util.Scanner;

// Create a Node class
class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// Create the binary search Tree class
class BinaryTree {
    Node root;

    public void insert(int value) {
        root = insertVal(root, value);
    }

    // Add a node
    private Node insertVal(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertVal(root.left, value);
        } else if (value > root.value) {
            root.right = insertVal(root.right, value);
        }
        return root;
    }

    public void delete(int value) {
        root = deleteVal(root, value);
    }

    // Delete a node
    private Node deleteVal(Node root, int value) {
        if (root == null) return root;

        if (value < root.value) {
            root.left = deleteVal(root.left, value);
        } else if (value > root.value) {
            root.right = deleteVal(root.right, value);
        } else {
            // Node found
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.value = minValue(root.right);
            root.right = deleteVal(root.right, root.value);
        }
        return root;
    }

    // Minimum value within a tree
    private int minValue(Node root) {
        int minVal = root.value;
        while (root.left != null) {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    // Print nodes by InOrder
    public void printInOrder() {
        printInOrderVal(root);
        System.out.println();
    }

    private void printInOrderVal(Node root) {
        if (root != null) {
            printInOrderVal(root.left);
            System.out.print(root.value + " ");
            printInOrderVal(root.right);
        }
    }

    // Print nodes by PreOrder
    public void printPreOrder() {
        printPreOrderVal(root);
        System.out.println();
    }

    private void printPreOrderVal(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printPreOrderVal(root.left);
            printPreOrderVal(root.right);
        }
    }

    // Print nodes by PostOrder
    public void printPostOrder() {
        printPostOrderVal(root);
        System.out.println();
    }

    private void printPostOrderVal(Node root) {
        if (root != null) {
            printPostOrderVal(root.left);
            printPostOrderVal(root.right);
            System.out.print(root.value + " ");
        }
    }
}

// Create a class for the application itself
public class LyonsTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree myTree = new BinaryTree();
        boolean running = true;

        // list all available menu options
        while (running) {
            System.out.println("Welcome Menu:");
            System.out.println("1. Create a binary search tree");
            System.out.println("2. Add a node");
            System.out.println("3. Delete a node");
            System.out.println("4. Print nodes by InOrder");
            System.out.println("5. Print nodes by PreOrder");
            System.out.println("6. Print nodes by PostOrder");
            System.out.println("7. Exit program");
            System.out.print("Please choose an available option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    myTree = new BinaryTree();
                    for (int i = 1; i <= 7; i++) {
                        myTree.insert(i);
                    }
                    System.out.println("You have created a binary tree.");
                    break;

                case 2:
                    System.out.print("Choose a value for the new node: ");
                    int addValue = scanner.nextInt();
                    myTree.insert(addValue);
                    System.out.println("Node added: " + addValue);
                    break;

                case 3:
                    System.out.print("Choose a value to delete: ");
                    int deleteValue = scanner.nextInt();
                    myTree.delete(deleteValue);
                    System.out.println("Node deleted: " + deleteValue);
                    break;

                case 4:
                    System.out.print("InOrder: ");
                    myTree.printInOrder();
                    break;

                case 5:
                    System.out.print("PreOrder: ");
                    myTree.printPreOrder();
                    break;

                case 6:
                    System.out.print("PostOrder: ");
                    myTree.printPostOrder();
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Please select an appropriate menu option.");
            }
        }

        scanner.close();
    }
}
