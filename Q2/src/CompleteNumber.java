public class CompleteNumber {

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            if (isComplete(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isComplete(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num)
            return true;
        return false;
    }
}
