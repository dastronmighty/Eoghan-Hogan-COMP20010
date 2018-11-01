#!/bin/bash
echo "Compiling..."
javac src/Point2D/Point2D.java
echo "running..."
cd src
java Point2D.Point2D
