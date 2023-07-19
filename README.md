# Functional Programming in Java - FunctionGroups

> This repository contains Java code for functional programming assignments focused on implementing various functions using method chains and handling parameterized types carefully. The assignments cover topics like finding the least element, flattening a map, implementing higher-order functions, and defining groups of bijections.

## Table of Contents

- [Description](#description)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Functional Programming in a Single Method Chain](#functional-programming-in-a-single-method-chain)
  - [Least Element](#least-element)
  - [Flatten a Map](#flatten-a-map)
- [Higher Order Functions](#higher-order-functions)
  - [NamedBiFunction Interface](#namedbifunction-interface)
  - [Zip Method](#zip-method)
- [Function Groups](#function-groups)
  - [BijectionGroup](#bijectiongroup)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Description

This repository contains Java code for functional programming assignments, focusing on the use of method chains and parameterized types. The assignments cover a variety of tasks, such as finding the least element, flattening a map, implementing higher-order functions, and defining groups of bijections.

## Prerequisites

To run the Java code in this repository, ensure you have the following installed:

- Java Development Kit (JDK) 1.8 (or a version compliant with Java 8)
- IntelliJ IDEA (recommended, but other IDEs can be used)

## Usage

Clone the repository "FunctionGroups" to your local machine and open it in IntelliJ IDEA or your preferred IDE. Compile and run the Java classes to execute the functional programming assignments.

## Functional Programming in a Single Method Chain

### Least Element

In this task, the goal is to find the least element from a collection of given elements that are comparable. The method chain returns a `java.util.Optional<T>`, and additional code is written to handle any potential exceptions and convert it to an object of type T.

### Flatten a Map

The task here is to flatten a map to a sequence of strings, where each element in the list is formatted as "key -> value" (key-value pairs are converted to strings in this specific format).

## Higher Order Functions

### NamedBiFunction Interface

A static nested interface, `NamedBiFunction`, is defined in `HigherOrderUtils`, extending `java.util.Function.BiFunction` with an additional method declaration `String name()` to provide a name for each instance of the class. The class also contains public static instances of `NamedBiFunction` for various arithmetic operations (addition, subtraction, multiplication, division).

### Zip Method

The `zip` method takes a list of arguments and a list of bifunctions (functions that take two arguments and produce a single instance of that type). It applies the bifunctions iteratively to the arguments, storing the results at each step to be used by the next bifunction in the next iteration.

## Function Groups

In this section, the focus is on defining groups of bijections using functional programming concepts.

### BijectionGroup

The `BijectionGroup` class contains methods to calculate the set of all bijections of an input set. It also provides a group structure for the set of bijections based on the binary operation of function composition. The implementation ensures the group properties of closure, associativity, and existence of identity and inverse elements.

## Contributing
Contributions to the FunctionGroups project are welcome! If you encounter any issues or have suggestions for improvement, feel free to open an issue or submit a pull request. Please read CONTRIBUTING.md for more details.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
If you have any questions or feedback, you can contact the project maintainer at:

Email: pmtaday@gmail.com
GitHub: @ptaday
