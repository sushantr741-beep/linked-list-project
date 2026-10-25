#!/usr/bin/env bash
# Script to compile and launch the interactive Linked List Management System

set -e

# Detect JAVA_HOME if not already set
if [ -z "$JAVA_HOME" ]; then
    if [ -d "/Library/Java/JavaVirtualMachines/temurin-26.jdk/Contents/Home" ]; then
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-26.jdk/Contents/Home"
    elif [ -x "/usr/libexec/java_home" ]; then
        export JAVA_HOME=$(/usr/libexec/java_home 2>/dev/null || true)
    fi
fi

if [ -n "$JAVA_HOME" ] && [ -d "$JAVA_HOME/bin" ]; then
    export PATH="$JAVA_HOME/bin:$PATH"
fi

# Verify javac and java are accessible
if ! command -v javac >/dev/null 2>&1; then
    echo "[ERROR] 'javac' compiler could not be found. Please ensure JDK is installed and JAVA_HOME is configured."
    exit 1
fi

echo "Compiling Linked List Management System..."
javac src/SinglyLinkedList.java src/DoublyLinkedList.java src/Main.java

echo "Launching application..."
java src.Main
