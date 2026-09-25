package JPMC;
/*
@TODO try your own approach
 */
public class Merge2SortArrays {

    public static int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        int[] merged = merge(a, b);
        System.out.println("a = " + java.util.Arrays.toString(a));
        System.out.println("b =" + java.util.Arrays.toString(b));
        System.out.println("Merged array = " + java.util.Arrays.toString(merged));

    }
}
