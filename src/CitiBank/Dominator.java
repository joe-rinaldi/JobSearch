package CitiBank;
/*

TODO don't understand
 */
public class Dominator {

    public static int solution(int[] A) {

        int size = 0;
        int candidate = -1;

        for (int value : A) {

            if (size == 0) {
                size++;
                candidate = value;
            } else if (candidate == value) {
                size++;
            } else {
                size--;
            }
        }

        int count = 0;
        int index = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }

        return count > A.length / 2
                ? index
                : -1;
    }

    public static void main(String[] args) {

        int[] arr =
                {3, 4, 3, 2, 3, -1, 3, 3};

        System.out.println(
                solution(arr));
    }
}
