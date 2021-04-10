# Project 2: Nondeterministic Finite Automata

* Authors: AJ Trantham, Jost Leavell
* Class: CS361 Section 1
* Semester: Spring 2021

## Overview

This program simulates a Nondeterministic Finite Automata (NFA) and outputs it as a Deterministic Finite Automata (DFA). It takes input text files formatted accordingly and outputs the language and which strings in the input file are accepted in the DFA's language.

## Compiling and Using

To compile the program, run the following command from the NFA directory:

[you@onyx]$ javac fa/nfa/NFADriver.java

To run the program, run the following command from the NFA directory:

_[you@onyx]$ java fa.nfa.NFADriver ./[test-file-path]

## Discussion

 Figuring out the given implementation of the given DFA was a bit of a 
 struggle. Figuring out the best way to implement the BFS and how to fully
 utilize use a queue took us the longest time as it took three rewrites of 
 our getDFA() method. It finally fell into place when we finally began 
 storing NFAStates in our queue. Surprisingly, finding whether two states were 
 equivalent was a challenge. More surprisingly, finding the epsilon 
 transitions was fairly easy. 

## Testing

We succesfully pass the provided test cases, and the suggested test cases on Piazza on the Onyx server.

## Sources used

Java API 
