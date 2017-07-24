# Lab 4
Lab 4 is a lab about encapsulation and [array list](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). In this lab you'll be creating your own custom [array list](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).

This custom array is mean to do a few things, each method is meant to mimic the behavior of an [array list](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). If the behaviors of an [array list](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) aren't known then the table below shows the purpose of each method.

Method header | purpose
------|------
CustomArray() | default constructor.
CustomArray(int size) | constructor that creates the array to a specific size.
boolean add(int item) | adds item to the end of the list.
void add(int item, int index) | add item to the specified location, shifting other items down.
int removeIndex(int index) | removes and returns item at index.
boolean removeValue(int value) | removes first instance of value, returns true if it did.
boolean contains(int value) | checks if the array contains a value.
int getSize() | checks how many items are in the array.
void grow() | grows the array to a larger size if needed.
void shrink() | shrinks the array to a smaller size if needed.
String toString() | returns the array as a string to be printed.

## grow and shrink

The Custom array is meant to be built upon a regular array, because of this the array is going to need to grow and shrink to save resources. grow is meant to double the size of the array when it runs out of space and shrink is meant to halve the array when the array is 1/4th the way used. 
