package main.examples;
// EnumExample.java
public class EnumExample {

    // Define an enum with constants and fields
    enum Size {
        SMALL("S"),
        MEDIUM("M"),
        LARGE("L"),
        EXTRALARGE("XL");

        private final String abbreviation;

        // Constructor for enum (must be private or package-private)
        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        // Getter method
        public String getAbbreviation() {
            return abbreviation;
        }
    }

    public static void main(String[] args) {
        // Example: Accessing enum constants
        Size mySize = Size.MEDIUM;
        System.out.println("Selected size: " + mySize);
        System.out.println("Abbreviation: " + mySize.getAbbreviation());

        // Example: Iterating over all enum values
        System.out.println("\nAvailable sizes:");
        for (Size size : Size.values()) {
            System.out.println(size + " (" + size.getAbbreviation() + ")");
        }

        // Example: Using enum in switch statement
        System.out.println("\nSwitch example:");
        switch (mySize) {
            case SMALL:
                System.out.println("You selected a small size.");
                break;
            case MEDIUM:
                System.out.println("You selected a medium size.");
                break;
            case LARGE:
                System.out.println("You selected a large size.");
                break;
            case EXTRALARGE:
                System.out.println("You selected an extra-large size.");
                break;
        }
    }
}
