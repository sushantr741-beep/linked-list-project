# Linked List Management System

[![Language: Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.oracle.com/java/)
[![JDK: 21+](https://img.shields.io/badge/JDK-21%2B%20%2F%2026-blue.svg)](https://adoptium.net/)
[![Build: Passing](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![Course: DSA Mini Project](https://img.shields.io/badge/Course-DSA%20Mini%20Project-purple.svg)]()

A modular, menu-driven console application engineered for practicing and demonstrating fundamental and advanced Linked List data structures. Developed for the **2nd Year College Level Data Structures and Algorithms (DSA)** curriculum.

---

## Table of Contents
- [Objective](#objective)
- [Language Used: Java](#language-used-java)
- [Features](#features)
- [Repository Structure](#repository-structure)
- [Singly Linked List](#singly-linked-list)
- [Doubly Linked List](#doubly-linked-list)
- [Operations](#operations)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)
- [Time Complexity](#time-complexity)
- [Edge Cases Handled](#edge-cases-handled)
- [Viva & Evaluation Guide](#viva--evaluation-guide)
- [Author](#author)

---

## Objective

The objective of this project is to implement a complete, robust, and interactive Linked List Management System that:
1. Implements both **Singly Linked Lists** and **Doubly Linked Lists** from scratch using custom, strongly-typed `Node` classes without relying on built-in collections (e.g., `java.util.LinkedList` or `ArrayList`).
2. Provides full coverage of core operations including insertions, deletions, searching, updates, bidirectional traversals, counting, min/max extraction, middle-element determination, link reversal, sorting, and duplicate elimination.
3. Offers an interactive, menu-driven terminal interface with robust error-handling preventing crashes from invalid inputs.
4. Provides an in-depth analytical comparison between Singly and Doubly Linked Lists (memory consumption, pointer overhead, asymptotic complexity, and practical applications).
5. Thoroughly handles and verifies ten standard edge cases (empty lists, single-node lists, boundary insertions, signed integers, etc.).

---

## Language Used: Java

This project is implemented in **Java (OpenJDK / Standard Edition)**.

### Why Java for Linked Lists?
- **Object Reference Model:** Uses explicit reference pointers (`node.next`, `node.prev`) enabling true node-chaining mechanics while avoiding raw platform-dependent pointer arithmetic pitfalls.
- **Automatic Garbage Collection (GC):** When nodes are unlinked during deletions or duplicate removal, the JVM's Garbage Collector safely reclaims memory through reachability analysis from GC roots, preventing memory leaks and dangling pointer vulnerabilities.
- **Cross-Platform Compatibility:** Runs identically across macOS, Linux, and Windows.
- **Robust Encapsulation:** Node definitions are encapsulated as static nested classes inside the list containers.

---

## Features

- **Interactive Menu-Driven Interface:** Clear ASCII menus matching the exact assignment specifications.
- **Singly Linked List Module:** 19 dedicated operations supporting standard and boundary scenarios.
- **Doubly Linked List Module:** 20 dedicated operations supporting bidirectional traversal and $O(1)$ tail operations.
- **Comparative Analysis Tool:** Side-by-side terminal comparison between Singly and Doubly Linked Lists.
- **Automated Regression Suite:** A comprehensive test runner that validates all operations and edge cases and logs verified output to `sample-output/output.txt`.
- **Complete Academic Documentation:** Includes a full project report (`docs/project-report.pdf` & `docs/project-report.md`) and a 15-question Viva preparation guide (`docs/viva-questions.md`).

---

## Repository Structure

```
Linked-List-Management-System/
|
|-- .gitignore                  # Git ignore rules for compiled classes & system artifacts
|-- Makefile                    # Build automation (compile, run, test, clean)
|-- README.md                   # Complete project documentation & guide
|-- run.sh                      # Shell script to launch interactive console menu
|-- test.sh                     # Shell script to execute automated regression test suite
|
|-- src/
|   |-- SinglyLinkedList.java   # Custom Singly Linked List class (19 operations)
|   |-- DoublyLinkedList.java   # Custom Doubly Linked List class (20 operations)
|   |-- Main.java               # Interactive console application and menus
|
|-- sample-output/
|   |-- output.txt              # Captured verified execution output log
|
|-- docs/
|   |-- project-report.md       # Comprehensive Markdown project report
|   |-- project-report.pdf      # Formatted 2-page PDF project report
|   |-- viva-questions.md       # Detailed answers to all 15 Viva evaluation questions
|
`-- tests/
    `-- TestRunner.java         # Automated test harness covering operations & edge cases
```

---

## Singly Linked List

A linear data structure where each node stores:
- `data`: Integer payload.
- `next`: Object reference pointing to the succeeding node (`null` at the tail).

The list maintains a single reference: `head`. In accordance with the project instructions, end insertion traverses the list in $O(n)$ time without a tail reference.

### Visual Representation
```
head -> [ 40 | next ] -> [ 10 | next ] -> [ 30 | next ] -> [ 20 | next ] -> [ 50 | null ]
```

---

## Doubly Linked List

A bidirectional data structure where each node stores:
- `data`: Integer payload.
- `prev`: Object reference pointing to the preceding node (`null` at the head).
- `next`: Object reference pointing to the succeeding node (`null` at the tail).

The list maintains both `head` and `tail` references, enabling $O(1)$ operations at both ends and reverse traversal.

### Visual Representation
```
       head                                                                   tail
        |                                                                      |
NULL <- [ prev | 10 | next ] <-> [ prev | 20 | next ] <-> [ prev | 30 | next ] <-> [ prev | 40 | next ] -> NULL
```

---

## Operations

### Singly Linked List Operations Menu (1 - 20)
1. **Insert at Beginning:** Adds node before head. $O(1)$.
2. **Insert at End:** Traverses to the last node and attaches the new node. $O(n)$.
3. **Insert at Position:** 1-based position insertion. Handles position 1, middle, last valid position ($pos = count + 1$), and invalid positions.
4. **Insert After a Node:** Inserts new node immediately after the first matching target node.
5. **Insert Before a Node:** Inserts new node immediately before the first matching target node (updates head if target is head).
6. **Delete from Beginning:** Removes head and advances head to `head.next`. $O(1)$.
7. **Delete from End:** Removes the last node and sets the second-to-last node's `next` to `null`. $O(n)$.
8. **Delete from Position:** Deletes node at 1-based position and preserves all links.
9. **Delete by Value:** Deletes the first node containing the target value.
10. **Search:** Sequentially searches for a value and returns its 1-based position.
11. **Update:** Replaces the data of the first matching node with a new value.
12. **Display:** Prints list in format: `40 -> 10 -> 30 -> 20 -> 50 -> NULL`.
13. **Count Nodes:** Traverses and returns the total number of nodes.
14. **Find Maximum:** Traverses and returns the largest value.
15. **Find Minimum:** Traverses and returns the smallest value.
16. **Find Middle Element:** Uses Floyd's fast/slow pointers. Defines rule for even-length lists ($2k$ nodes: returns upper middle at $k+1$ and reports both central nodes).
17. **Reverse:** In-place pointer reversal (`prev`, `current`, `next`). $O(n)$ time, $O(1)$ auxiliary space.
18. **Sort:** Ascending Bubble Sort with data swapping and early-exit `swapped` optimization. $O(n^2)$.
19. **Remove Duplicates:** Unsorted duplicate removal using runner pointer while maintaining valid links. $O(n^2)$ time, $O(1)$ space.
20. **Exit:** Returns to the Main Application Menu.

### Doubly Linked List Operations Menu (1 - 21)
Includes all operations above with:
- **Insert at End:** $O(1)$ utilizing `tail` reference.
- **Delete from End:** $O(1)$ utilizing `tail` reference.
- **Display Forward:** `NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL`
- **Display Backward:** `NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL`
- **Reverse:** In-place swapping of `prev` and `next` for all nodes, updating `head` and `tail`.

---

## How to Run

### Prerequisites
- JDK 17, 21, or newer (OpenJDK / Eclipse Temurin).
- Standard terminal with `make` or `bash`.

### Option 1: Using Makefile (Recommended)
```bash
# 1. Compile the project
make compile

# 2. Run the interactive console application
make run

# 3. Run the automated test suite
make test

# 4. Clean compiled classes
make clean
```

### Option 2: Using Shell Scripts
```bash
# Run interactive console application
./run.sh

# Run automated test suite
./test.sh
```

### Option 3: Direct Manual Compilation
```bash
# Compile all source files
javac src/SinglyLinkedList.java src/DoublyLinkedList.java src/Main.java tests/TestRunner.java

# Run interactive application
java src.Main

# Run automated test suite
java tests.TestRunner
```

---

## Sample Output

### 1. Singly Linked List Example Output (Section 8 Brief)
```
Before:
40 -> 10 -> 30 -> 20 -> 50 -> NULL

After Sort:
10 -> 20 -> 30 -> 40 -> 50 -> NULL

After Reverse:
50 -> 40 -> 30 -> 20 -> 10 -> NULL
```

### 2. Doubly Linked List Example Output (Section 8 Brief)
```
Forward:
NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL

Backward:
NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL
```

### 3. Singly vs Doubly Comparison Table (Main Menu Option 3)
```
==========================================================================================
                 COMPREHENSIVE COMPARISON: SINGLY VS DOUBLY LINKED LIST                   
==========================================================================================
Feature / Attribute      | Singly Linked List (SLL)        | Doubly Linked List (DLL)       
-------------------------+---------------------------------+--------------------------------
Node Structure           | data, next                      | prev, data, next               
Pointers per Node        | 1 pointer / reference           | 2 pointers / references        
Memory Overhead          | Lower (1 reference per node)    | Higher (2 references per node) 
Traversal Direction      | Unidirectional (Forward only)   | Bidirectional (Forward/Backward)
Insert at Beginning      | O(1)                            | O(1)                           
Insert at End            | O(n) without tail pointer       | O(1) with tail pointer         
Delete from Beginning    | O(1)                            | O(1)                           
Delete from End          | O(n) (needs predecessor)        | O(1) with tail pointer         
Delete given Node ref    | O(n) to find predecessor        | O(1) direct relink via prev/next
Reverse Complexity       | O(n) time, O(1) space           | O(n) time, O(1) space          
Implementation Complexity| Simpler pointer management      | More edge cases (prev & next)  
Typical Real-World Uses  | Stacks, Queues, Hash chaining   | Browser history, Undo/Redo, LRU
==========================================================================================
```

*(Full automated execution log is preserved in [sample-output/output.txt](sample-output/output.txt)).*

---

## Time Complexity

| Operation | Singly Linked List (SLL) | Doubly Linked List (DLL) | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Insert at Beginning** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Insert at End** | $O(n)$ (without tail) | $O(1)$ (with tail) | $O(1)$ |
| **Insert at Position** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Delete from Beginning** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Delete from End** | $O(n)$ | $O(1)$ | $O(1)$ |
| **Delete from Position** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Search by Value** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Update by Value** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Display (Forward)** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Display (Backward)** | $O(n)$ (requires reverse) | $O(n)$ | $O(1)$ |
| **Count Nodes** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Find Minimum / Maximum** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Find Middle Element** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Reverse** | $O(n)$ | $O(n)$ | $O(1)$ |
| **Bubble Sort** | $O(n^2)$ | $O(n^2)$ | $O(1)$ |
| **Remove Duplicates** | $O(n^2)$ | $O(n^2)$ | $O(1)$ |

---

## Edge Cases Handled

The implementation has been verified against all 10 edge cases specified in Section 10 of the assignment brief:
1. **Empty Linked List:** Safely checks for empty states on deletion, search, update, min/max, middle, sort, reverse, and duplicate removal without `NullPointerException`s.
2. **One-Node List:** Ensures operations like reversal, sorting, and duplicate removal leave the list unchanged, and deletion resets `head` and `tail` to `null`.
3. **Insert/Delete at Position 1:** Correctly updates the `head` pointer and maintains `head.prev = null` in DLL.
4. **Insert at Last Valid Position ($pos = count + 1$):** Successfully appends node to tail.
5. **Invalid or Out-of-Range Position:** Validates bounds ($pos < 1$ or $pos > count + 1$) and reports diagnostics without mutating the list.
6. **Delete Non-Existent Value:** Safely traverses without finding a match, prints a user-friendly error, and leaves links intact.
7. **Duplicate Values:** Completely cleanses multiple and consecutive duplicates (e.g. `5 -> 5 -> 10 -> 5 -> 20 -> 10 -> 5` becomes `5 -> 10 -> 20`).
8. **Zero and Negative Numbers:** Numerical comparisons in `findMaximum`, `findMinimum`, and `bubbleSort` seamlessly handle mixed negative and non-negative integers.
9. **Sort Empty or Single-Node List:** Immediately reports that the list is already sorted.
10. **Reverse Empty or Single-Node List:** Returns immediately with identical state.

---

## Viva & Evaluation Guide

A dedicated evaluation preparation document containing comprehensive answers to all 15 Viva questions from the project brief is available in:
- **[docs/viva-questions.md](docs/viva-questions.md)**

Topics covered:
- Linked lists vs Arrays
- Roles of `head`, `next`, and `prev`
- Asymptotic complexities of insertion, deletion, and search
- Fast/Slow pointer middle finding mechanics
- Java Object References vs C++ Pointers and Garbage Collection
- In-place reversal and Bubble Sort derivations

---

## Author

- **Student:** 2nd Year Computer Science / IT Student
- **Course:** Data Structures and Algorithms (DSA)
- **Project:** Linked List Management System Mini Project
