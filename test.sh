#!/usr/bin/env bash
# Script to compile and run the comprehensive automated test suite

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

if ! command -v javac >/dev/null 2>&1; then
    echo "[ERROR] 'javac' compiler could not be found. Please ensure JDK is installed and JAVA_HOME is configured."
    exit 1
fi

echo "Compiling sources and test runner..."
javac src/SinglyLinkedList.java src/DoublyLinkedList.java src/Main.java tests/TestRunner.java

echo "Running test suite..."
java tests.TestRunner
