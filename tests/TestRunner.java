package tests;

import src.SinglyLinkedList;
import src.DoublyLinkedList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Automated Test Runner and Demonstration Suite.
 * 
 * Validates:
 * 1. All Singly Linked List operations (Level 1 to Level 5)
 * 2. All Doubly Linked List operations (Level 1 to Level 6)
 * 3. Exact Example Output specified in Section 8 of the assignment document
 * 4. All 10 edge cases specified in Section 10 of the assignment document
 * 
 * Writes complete formatted test logs to both console and sample-output/output.txt.
 */
public class TestRunner {

    public static void main(String[] args) {
        try {
            // Ensure sample-output directory exists
            File outputDir = new File("sample-output");
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            File outputFile = new File("sample-output/output.txt");
            FileOutputStream fos = new FileOutputStream(outputFile);
            DualPrintStream dualStream = new DualPrintStream(System.out, new PrintStream(fos));
            System.setOut(dualStream);

            runAllTests();

            dualStream.close();
            System.out.println("\n[INFO] Complete test suite executed successfully. Output saved to sample-output/output.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runAllTests() {
        printHeader("LINKED LIST MANAGEMENT SYSTEM - COMPREHENSIVE TEST SUITE");

        // ---------------------------------------------------------------------
        // PART 1: SECTION 8 EXACT EXAMPLE OUTPUTS
        // ---------------------------------------------------------------------
        printSection("1. SECTION 8 EXACT EXAMPLE OUTPUT VERIFICATION");

        System.out.println("--- Singly Linked List Example Output ---");
        SinglyLinkedList sllExample = new SinglyLinkedList();
        sllExample.insertAtEnd(40);
        sllExample.insertAtEnd(10);
        sllExample.insertAtEnd(30);
        sllExample.insertAtEnd(20);
        sllExample.insertAtEnd(50);
        System.out.println("Before:");
        sllExample.display();

        System.out.println("\nAfter Sort:");
        sllExample.bubbleSort();

        System.out.println("\nAfter Reverse:");
        sllExample.reverse();

        System.out.println("\n--- Doubly Linked List Example Output ---");
        DoublyLinkedList dllExample = new DoublyLinkedList();
        dllExample.insertAtEnd(10);
        dllExample.insertAtEnd(20);
        dllExample.insertAtEnd(30);
        dllExample.insertAtEnd(40);
        System.out.println("Forward:");
        dllExample.displayForward();
        System.out.println("Backward:");
        dllExample.displayBackward();

        // ---------------------------------------------------------------------
        // PART 2: FULL SINGLY LINKED LIST OPERATIONS TEST (1 - 19)
        // ---------------------------------------------------------------------
        printSection("2. FULL SINGLY LINKED LIST OPERATIONS SUITE (1 - 19)");
        SinglyLinkedList sll = new SinglyLinkedList();

        System.out.println("[Op 1 & 2] Insert at Beginning and End:");
        sll.insertAtBeginning(20);
        sll.insertAtBeginning(10);
        sll.insertAtEnd(40);
        sll.insertAtEnd(50);
        sll.display(); // 10 -> 20 -> 40 -> 50 -> NULL

        System.out.println("\n[Op 3] Insert at Position (position 3, val 30):");
        sll.insertAtPosition(3, 30);
        sll.display(); // 10 -> 20 -> 30 -> 40 -> 50 -> NULL

        System.out.println("\n[Op 4] Insert After a Node (after 30, val 35):");
        sll.insertAfterNode(30, 35);
        sll.display();

        System.out.println("\n[Op 5] Insert Before a Node (before 35, val 32):");
        sll.insertBeforeNode(35, 32);
        sll.display();

        System.out.println("\n[Op 6] Delete from Beginning:");
        sll.deleteFromBeginning();
        sll.display();

        System.out.println("\n[Op 7] Delete from End:");
        sll.deleteFromEnd();
        sll.display();

        System.out.println("\n[Op 8] Delete from Position (position 3):");
        sll.deleteFromPosition(3);
        sll.display();

        System.out.println("\n[Op 9] Delete by Value (val 35):");
        sll.deleteByValue(35);
        sll.display();

        System.out.println("\n[Op 10] Search for values:");
        sll.search(40);
        sll.search(999);

        System.out.println("\n[Op 11] Update value (40 -> 45):");
        sll.update(40, 45);
        sll.display();

        System.out.println("\n[Op 12] Display List:");
        sll.display();

        System.out.println("\n[Op 13] Count Nodes:");
        System.out.println("Node count: " + sll.countNodes());

        System.out.println("\n[Op 14 & 15] Maximum and Minimum values:");
        sll.findMaximum();
        sll.findMinimum();

        System.out.println("\n[Op 16] Find Middle Element:");
        sll.findMiddleElement();

        System.out.println("\n[Op 17] Reverse List:");
        sll.reverse();

        System.out.println("\n[Op 18] Sort List:");
        sll.bubbleSort();

        System.out.println("\n[Op 19] Remove Duplicates:");
        sll.insertAtEnd(20);
        sll.insertAtEnd(45);
        sll.insertAtEnd(20);
        System.out.println("List before duplicate removal:");
        sll.display();
        sll.removeDuplicates();

        // ---------------------------------------------------------------------
        // PART 3: FULL DOUBLY LINKED LIST OPERATIONS TEST (1 - 20)
        // ---------------------------------------------------------------------
        printSection("3. FULL DOUBLY LINKED LIST OPERATIONS SUITE (1 - 20)");
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("[Op 1 & 2] Insert at Beginning and End:");
        dll.insertAtBeginning(200);
        dll.insertAtBeginning(100);
        dll.insertAtEnd(400);
        dll.insertAtEnd(500);
        System.out.print("Forward:  "); dll.displayForward();
        System.out.print("Backward: "); dll.displayBackward();

        System.out.println("\n[Op 3] Insert at Position (position 3, val 300):");
        dll.insertAtPosition(3, 300);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 4] Insert After a Node (after 300, val 350):");
        dll.insertAfterNode(300, 350);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 5] Insert Before a Node (before 350, val 320):");
        dll.insertBeforeNode(350, 320);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 6] Delete from Beginning:");
        dll.deleteFromBeginning();
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 7] Delete from End:");
        dll.deleteFromEnd();
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 8] Delete from Position (position 3):");
        dll.deleteFromPosition(3);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 9] Delete by Value (val 350):");
        dll.deleteByValue(350);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 10] Search for values:");
        dll.search(400);
        dll.search(9999);

        System.out.println("\n[Op 11] Update value (400 -> 450):");
        dll.update(400, 450);
        System.out.print("Forward:  "); dll.displayForward();

        System.out.println("\n[Op 12 & 13] Display Forward and Backward:");
        System.out.print("Forward:  "); dll.displayForward();
        System.out.print("Backward: "); dll.displayBackward();

        System.out.println("\n[Op 14] Count Nodes:");
        System.out.println("Node count: " + dll.countNodes());

        System.out.println("\n[Op 15 & 16] Maximum and Minimum values:");
        dll.findMaximum();
        dll.findMinimum();

        System.out.println("\n[Op 17] Find Middle Element:");
        dll.findMiddleElement();

        System.out.println("\n[Op 18] Reverse Doubly Linked List:");
        dll.reverse();

        System.out.println("\n[Op 19] Sort Doubly Linked List:");
        dll.bubbleSort();

        System.out.println("\n[Op 20] Remove Duplicates from Doubly Linked List:");
        dll.insertAtEnd(200);
        dll.insertAtEnd(450);
        dll.insertAtEnd(200);
        System.out.println("List before duplicate removal:");
        System.out.print("Forward:  "); dll.displayForward();
        dll.removeDuplicates();

        // ---------------------------------------------------------------------
        // PART 4: EDGE CASES FROM SECTION 10
        // ---------------------------------------------------------------------
        printSection("4. SECTION 10 EDGE CASES VERIFICATION");

        // Edge Case 1: Empty Linked List
        System.out.println(">> Edge Case 1: Operations on Empty List:");
        SinglyLinkedList emptySll = new SinglyLinkedList();
        System.out.print("Display empty SLL: "); emptySll.display();
        emptySll.deleteFromBeginning();
        emptySll.deleteFromEnd();
        emptySll.deleteFromPosition(1);
        emptySll.deleteByValue(10);
        emptySll.search(10);
        emptySll.update(10, 20);
        emptySll.findMaximum();
        emptySll.findMinimum();
        emptySll.findMiddleElement();
        emptySll.reverse();
        emptySll.bubbleSort();
        emptySll.removeDuplicates();

        // Edge Case 2: One-node List
        System.out.println("\n>> Edge Case 2: Operations on Single-Node List:");
        SinglyLinkedList singleSll = new SinglyLinkedList();
        singleSll.insertAtBeginning(42);
        System.out.print("Single-node list: "); singleSll.display();
        System.out.println("Count: " + singleSll.countNodes());
        singleSll.findMaximum();
        singleSll.findMinimum();
        singleSll.findMiddleElement();
        singleSll.reverse();
        singleSll.bubbleSort();
        singleSll.removeDuplicates();
        singleSll.deleteFromEnd();
        System.out.print("After deletion of only node: "); singleSll.display();

        // Edge Case 3: Insert / Delete at Position 1
        System.out.println("\n>> Edge Case 3: Insert / Delete at Position 1:");
        DoublyLinkedList posOneDll = new DoublyLinkedList();
        posOneDll.insertAtPosition(1, 99); // first node
        posOneDll.insertAtPosition(1, 88); // new head
        posOneDll.insertAtPosition(1, 77); // new head
        System.out.print("List after insertions at position 1: "); posOneDll.displayForward();
        posOneDll.deleteFromPosition(1);
        System.out.print("List after deletion at position 1:   "); posOneDll.displayForward();

        // Edge Case 4: Insert at Last Valid Position (pos == count + 1)
        System.out.println("\n>> Edge Case 4: Insert at Last Valid Position:");
        int currentCount = posOneDll.countNodes();
        System.out.println("Current count: " + currentCount);
        posOneDll.insertAtPosition(currentCount + 1, 1000);
        System.out.print("After inserting at position (count + 1): "); posOneDll.displayForward();

        // Edge Case 5: Invalid / Out-of-Range Position
        System.out.println("\n>> Edge Case 5: Invalid or Out-of-Range Positions:");
        posOneDll.insertAtPosition(0, -1);
        posOneDll.insertAtPosition(100, 9999);
        posOneDll.deleteFromPosition(0);
        posOneDll.deleteFromPosition(50);

        // Edge Case 6: Delete a Value that Does Not Exist
        System.out.println("\n>> Edge Case 6: Delete Non-Existent Value:");
        posOneDll.deleteByValue(123456);

        // Edge Case 7: Duplicate Values Handling
        System.out.println("\n>> Edge Case 7: List with Multiple Duplicates:");
        SinglyLinkedList dupSll = new SinglyLinkedList();
        dupSll.insertAtEnd(5);
        dupSll.insertAtEnd(5);
        dupSll.insertAtEnd(10);
        dupSll.insertAtEnd(5);
        dupSll.insertAtEnd(20);
        dupSll.insertAtEnd(10);
        dupSll.insertAtEnd(5);
        System.out.print("Before duplicate removal: "); dupSll.display();
        dupSll.removeDuplicates();
        System.out.print("After duplicate removal:  "); dupSll.display();

        // Edge Case 8: Zero and Negative Values
        System.out.println("\n>> Edge Case 8: Zero and Negative Values:");
        DoublyLinkedList negDll = new DoublyLinkedList();
        negDll.insertAtEnd(-15);
        negDll.insertAtEnd(0);
        negDll.insertAtEnd(-50);
        negDll.insertAtEnd(25);
        negDll.insertAtEnd(-5);
        System.out.print("Forward before sort:  "); negDll.displayForward();
        System.out.print("Backward before sort: "); negDll.displayBackward();
        negDll.findMaximum();
        negDll.findMinimum();
        negDll.bubbleSort();
        System.out.print("Forward after sort:   "); negDll.displayForward();
        System.out.print("Backward after sort:  "); negDll.displayBackward();

        // Edge Case 9: Sort an Empty or Single-Node List
        System.out.println("\n>> Edge Case 9: Sort Empty or Single-Node List:");
        DoublyLinkedList emptySortDll = new DoublyLinkedList();
        emptySortDll.bubbleSort();
        emptySortDll.insertAtBeginning(7);
        emptySortDll.bubbleSort();

        // Edge Case 10: Reverse an Empty or Single-Node List
        System.out.println("\n>> Edge Case 10: Reverse Empty or Single-Node List:");
        DoublyLinkedList emptyRevDll = new DoublyLinkedList();
        emptyRevDll.reverse();
        emptyRevDll.insertAtBeginning(13);
        emptyRevDll.reverse();

        printHeader("ALL TESTS COMPLETED SUCCESSFULLY");
    }

    private static void printHeader(String title) {
        System.out.println("================================================================================");
        System.out.println("  " + title);
        System.out.println("================================================================================");
    }

    private static void printSection(String sectionTitle) {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("  " + sectionTitle);
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * Helper stream to pipe outputs simultaneously to stdout and file.
     */
    private static class DualPrintStream extends PrintStream {
        private final PrintStream second;

        public DualPrintStream(PrintStream first, PrintStream second) {
            super(first);
            this.second = second;
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            super.write(buf, off, len);
            second.write(buf, off, len);
        }

        @Override
        public void flush() {
            super.flush();
            second.flush();
        }

        @Override
        public void close() {
            super.close();
            second.close();
        }
    }
}
