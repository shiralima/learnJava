#!/bin/bash

cd TicTacToeGame/

javac *.java

cd ..

java TicTacToeGame.Tournament

cd TicTacToeGame/

# Check the exit status of the previous command if 0 - succes
if [ $? -eq 0 ]; then
  # remove all class files
  rm *.class
fi
