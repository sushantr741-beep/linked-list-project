package src;

import java.util.Scanner;

/**
 * Main application console driver for the Linked List Management System.
 * 
 * Provides interactive, menu-driven CLI interfaces for:
 * 1. Singly Linked List operations (Options 1 - 20)
 * 2. Doubly Linked List operations (Options 1 - 21)
 * 3. In-depth comparative analysis between Singly and Doubly Linked Lists
 * 4. Exit
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = readIntChoice("Enter your choice: ");

            switch (choice) {
                case 1:
                    handleSinglyLinkedListMenu(sll);
                    break;
                case 2:
                    handleDoublyLinkedListMenu(dll);
                    break;
                case 3:
                    displayComparison();
                    break;
                case 4:
                    System.out.println("\nThank you for using Linked List Management System. Exiting application...");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid choice! Please select an option between 1 and 4.\n");
            }
        }
    }

    // =========================================================================
    // Main Menu Display
    // =========================================================================
    private static void displayMainMenu() {
        System.out.println("==================================================");
        System.out.println("          LINKED LIST MANAGEMENT SYSTEM           ");
        System.out.println("==================================================");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Compare Singly vs Doubly Linked List");
        System.out.println("4. Exit");
    }

    // =========================================================================
    // Singly Linked List Menu Handler
    // =========================================================================
    private static void handleSinglyLinkedListMenu(SinglyLinkedList sll) {
        boolean inSllMenu = true;
        while (inSllMenu) {
            displaySllMenu();
            int choice = readIntChoice("Enter the choice:- ");

            switch (choice) {
                case 1: { // Insert at Beginning
                    int val = readIntInput("Enter value to insert at beginning: ");
                    sll.insertAtBeginning(val);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 2: { // Insert at End
                    int val = readIntInput("Enter value to insert at end: ");
                    sll.insertAtEnd(val);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 3: { // Insert at Position
                    int pos = readIntInput("Enter 1-based position: ");
                    int val = readIntInput("Enter value to insert: ");
                    sll.insertAtPosition(pos, val);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 4: { // Insert After a Node
                    int target = readIntInput("Enter target node value: ");
                    int val = readIntInput("Enter new value to insert after " + target + ": ");
                    sll.insertAfterNode(target, val);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 5: { // Insert Before a Node
                    int target = readIntInput("Enter target node value: ");
                    int val = readIntInput("Enter new value to insert before " + target + ": ");
                    sll.insertBeforeNode(target, val);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 6: { // Delete from Beginning
                    sll.deleteFromBeginning();
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 7: { // Delete from End
                    sll.deleteFromEnd();
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 8: { // Delete from Position
                    int pos = readIntInput("Enter 1-based position to delete: ");
                    sll.deleteFromPosition(pos);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 9: { // Delete by Value
                    int target = readIntInput("Enter value to delete: ");
                    sll.deleteByValue(target);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 10: { // Search
                    int val = readIntInput("Enter value to search: ");
                    sll.search(val);
                    break;
                }
                case 11: { // Update
                    int oldVal = readIntInput("Enter existing value to replace: ");
                    int newVal = readIntInput("Enter new replacement value: ");
                    sll.update(oldVal, newVal);
                    System.out.print("Current List: ");
                    sll.display();
                    break;
                }
                case 12: { // Display
                    System.out.print("Singly Linked List: ");
                    sll.display();
                    break;
                }
                case 13: { // Count Nodes
                    int count = sll.countNodes();
                    System.out.println("Total node count: " + count);
                    break;
                }
                case 14: { // Find Maximum
                    sll.findMaximum();
                    break;
                }
                case 15: { // Find Minimum
                    sll.findMinimum();
                    break;
                }
                case 16: { // Find Middle Element
                    sll.findMiddleElement();
                    break;
                }
                case 17: { // Reverse
                    sll.reverse();
                    break;
                }
                case 18: { // Sort
                    sll.bubbleSort();
                    break;
                }
                case 19: { // Remove Duplicates
                    sll.removeDuplicates();
                    break;
                }
                case 20: { // Exit
                    System.out.println("Returning to Main Menu...\n");
                    inSllMenu = false;
                    break;
                }
                default:
                    System.out.println("[ERROR] Invalid choice! Please select an option between 1 and 20.");
            }
            System.out.println();
        }
    }

    private static void displaySllMenu() {
        System.out.println("********** Operation on Singly Linked List **********");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Insert at Position");
        System.out.println("4. Insert After a Node");
        System.out.println("5. Insert Before a Node");
        System.out.println("6. Delete from Beginning");
        System.out.println("7. Delete from End");
        System.out.println("8. Delete from Position");
        System.out.println("9. Delete by Value");
        System.out.println("10. Search");
        System.out.println("11. Update");
        System.out.println("12. Display");
        System.out.println("13. Count Nodes");
        System.out.println("14. Find Maximum");
        System.out.println("15. Find Minimum");
        System.out.println("16. Find Middle Element");
        System.out.println("17. Reverse");
        System.out.println("18. Sort");
        System.out.println("19. Remove Duplicates");
        System.out.println("20. Exit");
    }

    // =========================================================================
    // Doubly Linked List Menu Handler
    // =========================================================================
    private static void handleDoublyLinkedListMenu(DoublyLinkedList dll) {
        boolean inDllMenu = true;
        while (inDllMenu) {
            displayDllMenu();
            int choice = readIntChoice("Enter the choice:- ");

            switch (choice) {
                case 1: { // Insert at Beginning
                    int val = readIntInput("Enter value to insert at beginning: ");
                    dll.insertAtBeginning(val);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 2: { // Insert at End
                    int val = readIntInput("Enter value to insert at end: ");
                    dll.insertAtEnd(val);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 3: { // Insert at Position
                    int pos = readIntInput("Enter 1-based position: ");
                    int val = readIntInput("Enter value to insert: ");
                    dll.insertAtPosition(pos, val);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 4: { // Insert After a Node
                    int target = readIntInput("Enter target node value: ");
                    int val = readIntInput("Enter new value to insert after " + target + ": ");
                    dll.insertAfterNode(target, val);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 5: { // Insert Before a Node
                    int target = readIntInput("Enter target node value: ");
                    int val = readIntInput("Enter new value to insert before " + target + ": ");
                    dll.insertBeforeNode(target, val);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 6: { // Delete from Beginning
                    dll.deleteFromBeginning();
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 7: { // Delete from End
                    dll.deleteFromEnd();
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 8: { // Delete from Position
                    int pos = readIntInput("Enter 1-based position to delete: ");
                    dll.deleteFromPosition(pos);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 9: { // Delete by Value
                    int target = readIntInput("Enter value to delete: ");
                    dll.deleteByValue(target);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 10: { // Search
                    int val = readIntInput("Enter value to search: ");
                    dll.search(val);
                    break;
                }
                case 11: { // Update
                    int oldVal = readIntInput("Enter existing value to replace: ");
                    int newVal = readIntInput("Enter new replacement value: ");
                    dll.update(oldVal, newVal);
                    System.out.print("Forward List: ");
                    dll.displayForward();
                    break;
                }
                case 12: { // Display Forward
                    System.out.print("Forward List:  ");
                    dll.displayForward();
                    break;
                }
                case 13: { // Display Backward
                    System.out.print("Backward List: ");
                    dll.displayBackward();
                    break;
                }
                case 14: { // Count Nodes
                    int count = dll.countNodes();
                    System.out.println("Total node count: " + count);
                    break;
                }
                case 15: { // Find Maximum
                    dll.findMaximum();
                    break;
                }
                case 16: { // Find Minimum
                    dll.findMinimum();
                    break;
                }
                case 17: { // Find Middle Element
                    dll.findMiddleElement();
                    break;
                }
                case 18: { // Reverse
                    dll.reverse();
                    break;
                }
                case 19: { // Sort
                    dll.bubbleSort();
                    break;
                }
                case 20: { // Remove Duplicates
                    dll.removeDuplicates();
                    break;
                }
                case 21: { // Exit
                    System.out.println("Returning to Main Menu...\n");
                    inDllMenu = false;
                    break;
                }
                default:
                    System.out.println("[ERROR] Invalid choice! Please select an option between 1 and 21.");
            }
            System.out.println();
        }
    }

    private static void displayDllMenu() {
        System.out.println("********** Operation on Doubly Linked List **********");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Insert at Position");
        System.out.println("4. Insert After a Node");
        System.out.println("5. Insert Before a Node");
        System.out.println("6. Delete from Beginning");
        System.out.println("7. Delete from End");
        System.out.println("8. Delete from Position");
        System.out.println("9. Delete by Value");
        System.out.println("10. Search");
        System.out.println("11. Update");
        System.out.println("12. Display Forward");
        System.out.println("13. Display Backward");
        System.out.println("14. Count Nodes");
        System.out.println("15. Find Maximum");
        System.out.println("16. Find Minimum");
        System.out.println("17. Find Middle Element");
        System.out.println("18. Reverse");
        System.out.println("19. Sort");
        System.out.println("20. Remove Duplicates");
        System.out.println("21. Exit");
    }

    // =========================================================================
    // Option 3: Compare Singly vs Doubly Linked List
    // =========================================================================
    private static void displayComparison() {
        System.out.println();
        System.out.println("==========================================================================================");
        System.out.println("                 COMPREHENSIVE COMPARISON: SINGLY VS DOUBLY LINKED LIST                   ");
        System.out.println("==========================================================================================");
        System.out.printf("%-24s | %-31s | %-31s%n", "Feature / Attribute", "Singly Linked List (SLL)", "Doubly Linked List (DLL)");
        System.out.println("-------------------------+---------------------------------+--------------------------------");
        System.out.printf("%-24s | %-31s | %-31s%n", "Node Structure", "data, next", "prev, data, next");
        System.out.printf("%-24s | %-31s | %-31s%n", "Pointers per Node", "1 pointer / reference", "2 pointers / references");
        System.out.printf("%-24s | %-31s | %-31s%n", "Memory Overhead", "Lower (1 reference per node)", "Higher (2 references per node)");
        System.out.printf("%-24s | %-31s | %-31s%n", "Traversal Direction", "Unidirectional (Forward only)", "Bidirectional (Forward/Backward)");
        System.out.printf("%-24s | %-31s | %-31s%n", "Insert at Beginning", "O(1)", "O(1)");
        System.out.printf("%-24s | %-31s | %-31s%n", "Insert at End", "O(n) without tail pointer", "O(1) with tail pointer");
        System.out.printf("%-24s | %-31s | %-31s%n", "Delete from Beginning", "O(1)", "O(1)");
        System.out.printf("%-24s | %-31s | %-31s%n", "Delete from End", "O(n) (needs predecessor)", "O(1) with tail pointer");
        System.out.printf("%-24s | %-31s | %-31s%n", "Delete given Node ref", "O(n) to find predecessor", "O(1) direct relink via prev/next");
        System.out.printf("%-24s | %-31s | %-31s%n", "Reverse Complexity", "O(n) time, O(1) space", "O(n) time, O(1) space");
        System.out.printf("%-24s | %-31s | %-31s%n", "Implementation Complexity", "Simpler pointer management", "More edge cases (prev & next)");
        System.out.printf("%-24s | %-31s | %-31s%n", "Typical Real-World Uses", "Stacks, Queues, Hash chaining", "Browser history, Undo/Redo, LRU");
        System.out.println("==========================================================================================");
        System.out.println("Key Takeaway:");
        System.out.println("  - Singly Linked Lists are ideal when memory overhead is critical and backward traversal");
        System.out.println("    or O(1) node deletion is not required.");
        System.out.println("  - Doubly Linked Lists excel when bidirectional traversal, fast deletion given a node");
        System.out.println("    reference, and constant-time operations at both ends (via head and tail) are needed.");
        System.out.println("==========================================================================================\n");
    }

    // =========================================================================
    // Robust Console Input Helpers
    // =========================================================================
    private static int readIntChoice(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid input! Please enter a valid integer choice.");
            }
        }
    }

    private static int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid number format! Please enter an integer value.");
            }
        }
    }
}
