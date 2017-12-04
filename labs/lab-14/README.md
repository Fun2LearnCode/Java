# Lab 14

Lab 14 is a series of questions about methods and encapsulation. For all the questions assume that any import that is needed is found in the code.

## Questions

### 1

What are the different types of methods?

### 2

Explain what each of the following key words do, and where they are used.

* public
* private
* protected
* static
* void
* final

### 3

How do instance variables differ from static ones?

### 4

What are Varargs and why are they useful?

### 5

What is the output of the code below? (If there is an error, why?)

```java
public class Person{
    public int age;
    public String name;
    public static void main(String args[]){
        System.out.println(Person.getAge());
    }
    public static int getAge(){
        return age;
    }
    public static String getName(){
        return name;
    }
}
```

### 6

What is the output of the code below? (If there is an error, why?)

```java
public class QuestionSix{
    public static void main(String args[]){
        int[] myArray = new int[5];
        for(int x = myArray.length-1; x > -1; x--){
            myArray[x] = x;
        }
        setPoint(myArray, 0, 5);
        System.out.println(Arrays.toString(myArray));
    }
    public static void setPoint(int[] array, int index, int value){
        array[index] = value;
    }
}
```

### 7

What is the output of the code below? (If there is an error, why?)

```java
public class QuestionSeven{
    public static void main(String args[]){
        QuestionSeven question = new QuestionSeven();
        QuestionSeven.methodOne();
        QuestionSeven.methodTwo();
        System.out.println(question.methodThree());
    }
    public static void methodOne(){

    }
    public static void methodOne(int x){

    }
    public static int methodTwo(){
        return 2;
    }
    public int methodThree(){
        return 3;
    }
    public int static methodFour(){
        return 4;
    }
}
```
