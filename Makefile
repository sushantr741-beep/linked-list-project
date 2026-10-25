# Makefile for Linked List Management System (Java)

JAVAC ?= javac
JAVA  ?= java

# Detect JDK path on macOS if JAVA_HOME is not set
ifeq ($(JAVA_HOME),)
    ifneq ($(wildcard /Library/Java/JavaVirtualMachines/temurin-26.jdk/Contents/Home/bin/javac),)
        JAVA_HOME := /Library/Java/JavaVirtualMachines/temurin-26.jdk/Contents/Home
        export JAVA_HOME
        export PATH := $(JAVA_HOME)/bin:$(PATH)
    endif
endif

SOURCES = src/SinglyLinkedList.java src/DoublyLinkedList.java src/Main.java
TEST_SOURCES = $(SOURCES) tests/TestRunner.java

.PHONY: all compile run test clean

all: compile

compile:
	@echo "Compiling Java source files..."
	$(JAVAC) $(SOURCES)

compile-test:
	@echo "Compiling Java test files..."
	$(JAVAC) $(TEST_SOURCES)

run: compile
	@echo "Starting Linked List Management System..."
	$(JAVA) src.Main

test: compile-test
	@echo "Executing automated test suite..."
	$(JAVA) tests.TestRunner

clean:
	@echo "Cleaning compiled class files..."
	rm -f src/*.class tests/*.class
