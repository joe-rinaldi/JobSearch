package main.examples;

/*
https://www.bing.com/videos/riverview/relatedvideo?q=Glider+online+test&mid=7E6F3E11A3803B887DF97E6F3E11A3803B887DF9&churl=https%3a%2f%2fwww.youtube.com%2fchannel%2fUCLLf3BKaLS2Jfcyl4U5RmKA&FORM=VIRE

Test 1 input
SAM
JOHN
SAMJOHN

output
yes

Test 2 input
SAM
JOHN
SAMLJOHN

output
No

Test 3 input
SAM
JOH
SALJOHN

output
No


 */
public class MagneticLetters {

    public String solve(String s1, String s2, String R){
        for (char c : s1.toCharArray()) {
            if (R.indexOf(c) == -1) {
                return "NO";
            }
        }
        for (char c : s2.toCharArray()) {
            if (R.indexOf(c) == -1) {
                return "NO";
            }
        }

        for (char c : R.toCharArray()) {
            if ((s1+s2).indexOf(c) == -1) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + new MagneticLetters().solve("SAM", "JOHN", "SAMJOHN"));
        System.out.println("Test 2: " + new MagneticLetters().solve("SAM", "JOHN", "SAMLJOHN"));
        System.out.println("Test 3: " + new MagneticLetters().solve("SAM", "JOH", "SALJOHN"));
    }
}
