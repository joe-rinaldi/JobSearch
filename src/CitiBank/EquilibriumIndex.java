package CitiBank;

public class EquilibriumIndex {

    public static int solution(int[] A) {

        long totalSum = 0;

        for(int value : A)
            totalSum += value;

        long leftSum = 0;

        for(int i=0;i<A.length;i++) {

            totalSum -= A[i];

            if(leftSum == totalSum)
                return i;

            leftSum += A[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {-7,1,5,2,-4,3,0};

        System.out.println(solution(arr));
    }
}
