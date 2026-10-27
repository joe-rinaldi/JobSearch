package Leidos;

public class RecentPairSumMain {
    public static void main(String[] args) {
        RecentPairSum pairSum = new RecentPairSum(3);

        pairSum.add(1);
        pairSum.add(5);
        pairSum.add(3);
        System.out.println("hasPair(8) = " + pairSum.hasPair(8)); // true: 5 + 3

        pairSum.add(9);
        System.out.println("hasPair(6) = " + pairSum.hasPair(6)); // false: 1 expired
        System.out.println("hasPair(12) = " + pairSum.hasPair(12)); // true: 3 + 9
    }
}
