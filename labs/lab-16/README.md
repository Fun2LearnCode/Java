# Lab 16

Lab 16 is about constructors and data encapsulation.

## Constructors

Constructors are one of the unique type of method in Java. Constructors have no return type(not even void), and share a name with the class they belong to.

Each class that isn't a static class will need a constructor to be useful, but they aren't complicated and you usually will only use one per class.

## Data encapsulation

Data encapsulation is what objects and Java are useful for. They allow you to create stores of information that are unique and defined by the user. An easy way to think of this is to break an every day object down into very simple attributes. For the lab well use animals.

In a class each attribute will be stored as a instance variable and will be set by the user. However because we need to get used to using writing constructors, there will be several constructors.


## Lab Task

The task of the lab is to create the Animals class. Animals have a few attributes, like a the breed. For the sake of the lab, the information about the animals doesn't need to be true, say you make a cat, cat isn't a breed, but for our purposes it will work.

The class needs to contain the following data about a given animal:

* Breed
* Age
* If it lives on land
* Weight
* If it can swim
* If it can hop

The class also needs to have getters for all of these instance variables.

Likewise if no age is specified at the time of the objects construction, assume the animal is 0 and has just been born. Assume animals that live on land can't swim and can jump by default. The reverse is true for animals that don't live on land. All of this should be done in various constructors that meet these conditions.
