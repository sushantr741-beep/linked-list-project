package src;

/**
 * SinglyLinkedList implementation.
 * 
 * Implements a linear singly linked list supporting all 19 operations
 * specified in the DSA Mini Project requirements.
 * Data structure uses custom Node objects with integer data and next references.
 */
public class SinglyLinkedList {

    /**
     * Inner Node class representing an element in the Singly Linked List.
     */
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    /**
     * Constructs an empty Singly Linked List.
     */
    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     * Checks if the list is empty.
     * @return true if head is null, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clears all elements from the list.
     */
    public void clear() {
        head = null;
    }

    /**
     * Gets the head node of the list.
     * @return head Node
     */
    public Node getHead() {
        return head;
    }

    // ==========================================
    // 1. Insert at Beginning - O(1)
    // ==========================================
    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        System.out.println("[SUCCESS] Node with value " + val + " inserted at the beginning.");
    }

    // ==========================================
    // 2. Insert at End - O(n) without tail reference
    // ==========================================
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            System.out.println("[SUCCESS] List was empty. Node with value " + val + " inserted as head.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("[SUCCESS] Node with value " + val + " inserted at the end.");
    }

    // ==========================================
    // 3. Insert at Position (1-based) - O(n)
    // ==========================================
    public boolean insertAtPosition(int pos, int val) {
        int count = countNodes();
        if (pos < 1 || pos > count + 1) {
            System.out.println("[ERROR] Invalid position " + pos + "! Valid range is 1 to " + (count + 1) + ".");
            return false;
        }

        if (pos == 1) {
            insertAtBeginning(val);
            return true;
        }

        Node newNode = new Node(val);
        Node current = head;
        // Traverse to node at position (pos - 1)
        for (int i = 1; i < pos - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Node with value " + val + " inserted at position " + pos + ".");
        return true;
    }

    // ==========================================
    // 4. Insert After a Node - O(n)
    // ==========================================
    public boolean insertAfterNode(int targetVal, int val) {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Target value " + targetVal + " not found.");
            return false;
        }

        Node current = head;
        while (current != null && current.data != targetVal) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR] Target value " + targetVal + " not found in the list.");
            return false;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Node with value " + val + " inserted after node with value " + targetVal + ".");
        return true;
    }

    // ==========================================
    // 5. Insert Before a Node - O(n)
    // ==========================================
    public boolean insertBeforeNode(int targetVal, int val) {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Target value " + targetVal + " not found.");
            return false;
        }

        // If target is at head
        if (head.data == targetVal) {
            insertAtBeginning(val);
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != targetVal) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("[ERROR] Target value " + targetVal + " not found in the list.");
            return false;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("[SUCCESS] Node with value " + val + " inserted before node with value " + targetVal + ".");
        return true;
    }

    // ==========================================
    // 6. Delete from Beginning - O(1)
    // ==========================================
    public boolean deleteFromBeginning() {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Cannot delete from beginning.");
            return false;
        }

        int deletedVal = head.data;
        head = head.next;
        System.out.println("[SUCCESS] Deleted node with value " + deletedVal + " from the beginning.");
        return true;
    }

    // ==========================================
    // 7. Delete from End - O(n)
    // ==========================================
    public boolean deleteFromEnd() {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Cannot delete from end.");
            return false;
        }

        if (head.next == null) {
            int deletedVal = head.data;
            head = null;
            System.out.println("[SUCCESS] Deleted single existing node with value " + deletedVal + ".");
            return true;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int deletedVal = current.next.data;
        current.next = null;
        System.out.println("[SUCCESS] Deleted node with value " + deletedVal + " from the end.");
        return true;
    }

    // ==========================================
    // 8. Delete from Position (1-based) - O(n)
    // ==========================================
    public boolean deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Cannot delete from position.");
            return false;
        }

        int count = countNodes();
        if (pos < 1 || pos > count) {
            System.out.println("[ERROR] Invalid position " + pos + "! Valid range is 1 to " + count + ".");
            return false;
        }

        if (pos == 1) {
            return deleteFromBeginning();
        }

        Node current = head;
        for (int i = 1; i < pos - 1; i++) {
            current = current.next;
        }

        int deletedVal = current.next.data;
        current.next = current.next.next;
        System.out.println("[SUCCESS] Deleted node with value " + deletedVal + " from position " + pos + ".");
        return true;
    }

    // ==========================================
    // 9. Delete by Value - O(n)
    // ==========================================
    public boolean deleteByValue(int targetVal) {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Cannot delete by value.");
            return false;
        }

        if (head.data == targetVal) {
            return deleteFromBeginning();
        }

        Node current = head;
        while (current.next != null && current.next.data != targetVal) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("[ERROR] Value " + targetVal + " not found in the list.");
            return false;
        }

        current.next = current.next.next;
        System.out.println("[SUCCESS] Deleted first occurrence of value " + targetVal + ".");
        return true;
    }

    // ==========================================
    // 10. Search - O(n)
    // ==========================================
    public int search(int val) {
        if (head == null) {
            System.out.println("[INFO] List is empty. Value " + val + " not found.");
            return -1;
        }

        Node current = head;
        int pos = 1;
        while (current != null) {
            if (current.data == val) {
                System.out.println("[FOUND] Value " + val + " found at position " + pos + " (1-based index).");
                return pos;
            }
            current = current.next;
            pos++;
        }

        System.out.println("[NOT FOUND] Value " + val + " does not exist in the list.");
        return -1;
    }

    // ==========================================
    // 11. Update - O(n)
    // ==========================================
    public boolean update(int oldVal, int newVal) {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Cannot update value.");
            return false;
        }

        Node current = head;
        int pos = 1;
        while (current != null) {
            if (current.data == oldVal) {
                current.data = newVal;
                System.out.println("[SUCCESS] Updated value " + oldVal + " to " + newVal + " at position " + pos + ".");
                return true;
            }
            current = current.next;
            pos++;
        }

        System.out.println("[ERROR] Value " + oldVal + " not found in the list. Update failed.");
        return false;
    }

    // ==========================================
    // 12. Display - O(n)
    // ==========================================
    public void display() {
        if (head == null) {
            System.out.println("Empty List: NULL");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    // ==========================================
    // 13. Count Nodes - O(n)
    // ==========================================
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // ==========================================
    // 14. Find Maximum - O(n)
    // ==========================================
    public Integer findMaximum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Maximum value cannot be determined.");
            return null;
        }

        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("[RESULT] Maximum value in the list: " + max);
        return max;
    }

    // ==========================================
    // 15. Find Minimum - O(n)
    // ==========================================
    public Integer findMinimum() {
        if (head == null) {
            System.out.println("[ERROR] List is empty! Minimum value cannot be determined.");
            return null;
        }

        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("[RESULT] Minimum value in the list: " + min);
        return min;
    }

    // ==========================================
    // 16. Find Middle Element - O(n)
    // ==========================================
    public Node findMiddleElement() {
        if (head == null) {
            System.out.println("[ERROR] List is empty! No middle element exists.");
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prevSlow = null;
        int slowPos = 1;

        int totalCount = countNodes();

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
            slowPos++;
        }

        if (totalCount % 2 != 0) {
            System.out.println("[RESULT] List length is ODD (" + totalCount + " nodes).");
            System.out.println("  -> Exact Middle Element at position " + slowPos + ": " + slow.data);
        } else {
            System.out.println("[RESULT] List length is EVEN (" + totalCount + " nodes).");
            System.out.println("  -> Defined Rule for Even Length: When a list has 2k nodes, there are two middle nodes");
            System.out.println("     (positions k and k+1). By standard fast/slow pointer method, the second/upper middle is selected.");
            System.out.println("  -> First Middle  (position " + (slowPos - 1) + "): " + prevSlow.data);
            System.out.println("  -> Second Middle (position " + slowPos + "): " + slow.data + " [Selected by Fast/Slow Pointer]");
        }
        return slow;
    }

    // ==========================================
    // 17. Reverse - O(n), extra space O(1)
    // ==========================================
    public void reverse() {
        if (head == null) {
            System.out.println("[WARNING] List is empty! Nothing to reverse.");
            return;
        }
        if (head.next == null) {
            System.out.println("[INFO] Single node list. Reverse is identical.");
            return;
        }

        System.out.println("Before Reverse:");
        System.out.print("  ");
        display();

        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;

        System.out.println("After Reverse:");
        System.out.print("  ");
        display();
    }

    // ==========================================
    // 18. Sort (Bubble Sort Ascending) - O(n^2)
    // ==========================================
    public void bubbleSort() {
        if (head == null || head.next == null) {
            System.out.println("[INFO] List is empty or has only 1 element. Already sorted.");
            return;
        }

        System.out.println("Before Sort:");
        System.out.print("  ");
        display();

        boolean swapped;
        Node ptr1;
        Node lptr = null;

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);

        System.out.println("After Sort:");
        System.out.print("  ");
        display();
    }

    // ==========================================
    // 19. Remove Duplicates - O(n^2), space O(1)
    // ==========================================
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            System.out.println("[INFO] List has 0 or 1 element. No duplicates possible.");
            return;
        }

        System.out.println("Before Removing Duplicates:");
        System.out.print("  ");
        display();

        int removedCount = 0;
        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    // Duplicate found: bypass node
                    runner.next = runner.next.next;
                    removedCount++;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        if (removedCount > 0) {
            System.out.println("[SUCCESS] Removed " + removedCount + " duplicate element(s).");
        } else {
            System.out.println("[INFO] No duplicate elements found.");
        }

        System.out.println("After Removing Duplicates:");
        System.out.print("  ");
        display();
    }
}
