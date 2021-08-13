package arrays;

public class CheckIfExist {
    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (num == arr[j] * 2 || arr[j] == 2 * num) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
int[] n = new int[]{10,2,5,3};
        System.out.println(checkIfExist(n));
    }
}
