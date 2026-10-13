package CitiBank;


/*
TODO don't understand algorithm solution


✅ Codility Java Assessment: Detailed Questions + Answers + Test Harness (Main Classes)
Below is a set of typical Codility-style tasks with:

Detailed question statements
Correct solution approach (with reasoning)
Java implementation
Main test classes that run multiple datasets (including edge cases)
📌 Note: The tests are written as standalone Java main classes (not JUnit) so they’re easy to run from the command line.

1) ✅ Task: Binary Gap
📌 Question
You are given an integer N. Write a function that returns the length of the longest sequence of consecutive zeros surrounded by ones in the binary representation of N.

Example:
N = 529 → binary 1000010001 → longest binary gap is 4
✅ Key Points
Only zeros between two 1s count.
Leading/trailing zeros don’t count.
💡 Solution Idea
Convert by repeatedly shifting bits.
Track when we’ve seen the first 1, then count zeros until next 1.
Maintain maxGap.

 */
public class BinaryGap {

    public static int solution(int N) {

        String binary = Integer.toBinaryString(N);
        System.out.println("n="+N+" s="+binary);

        int maxGap = 0;
        int currentGap = 0;

        for (char ch : binary.toCharArray()) {

            if (ch == '1') {
                maxGap = Math.max(maxGap, currentGap);
                currentGap = 0;
            } else {
                currentGap++;
            }
        }

        return maxGap;
    }


    public static int solution2(int N) {
        int maxGap = 0;
        int current = -1; // -1 means "haven't seen a '1' yet"

        while (N > 0) {
            if ((N & 1) == 1) { // bit is 1
                if (current >= 0) { // we were counting a gap
                    maxGap = Math.max(maxGap, current);
                }
                current = 0; // start counting zeros after this 1
            } else { // bit is 0
                if (current >= 0) {
                    current++;
                }
            }
            N >>= 1;
        }
        return maxGap;
    }

    public static void main(String[] args) {

        int[] tests = {9, 529, 20, 15, 32};

        for (int test : tests) {
            System.out.printf("%d -> %d%n",
                    test,
                    solution2(test));
        }
    }
}
