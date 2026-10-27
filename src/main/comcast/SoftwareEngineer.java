package comcast;

/*
x Can you access us private variables in subclass?
 No, private variables are not accessible in subclasses. They can only be accessed within the class
 they are declared in.

x how to access private variables in junit class?
 You can access private variables in a JUnit test class using reflection. Here's an example:

x  string class vs string
x equals and == in java
x different waus to use final  can't extend it or only assign once
x common lamda expressions in java


 */
public class SoftwareEngineer {

    public void stringTest(){

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1 == s2); // true, because string literals are interned
        System.out.println(s1 == s3); // false, because s3 is a new object
        System.out.println(s1.equals(s3)); // true, because equals() compares content

    }

    //create main method and call stringTest method
    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer();
        se.stringTest();
    }

}
