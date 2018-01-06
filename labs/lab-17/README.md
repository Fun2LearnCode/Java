# Lab 17

Lab 17 is about interfaces and abstract classes and super classes.

## Interfaces

I can't explain interfaces here, they are complicated. They allow for polymorphism of items that have the same type of output, but arrive at that output in different ways.

## Abstract classes

Abstract classes are a combination of interfaces and super classes. They can leave abstract methods unimplemented, like an interface, but they can also define methods like a super class.

## Super classes

Super classes are meant to share most of, it not all, of its functionality. They can be overridden but if you do this too often the super class likely is not needed.

### Lab Project

The lab project is mean to use and store shapes. The outline of each method is shown below. All of these classes should be stored in one array list, just like in the in-class example. The example is provided in examples.

The example is meant to add triangles, we don't want regular triangles, we only want specific triangles, so the triangle class will be abstract. The triangles we would like to allow are right triangles, equilateral triangle and isosceles triangles. You may need to google to area formula for each, I can't add them to this file. After creating each of these classes, add them to the array containing shapes in the Polymorphism class and make sure it works.
