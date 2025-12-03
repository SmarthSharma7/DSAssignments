
package Assignment_2;

public class FindMissing_Q3 {
    public static void main(String[] args) {

        int[] sortedArr = {2, 3, 4, 5, 6, 7, 8, 9};
        int size = sortedArr.length;
        System.out.println("Array: ");
        for (int i : sortedArr) System.out.print(i + ", ");

        System.out.println("\nUsing linear approach:");
        findMissingLinear(sortedArr, size);
        System.out.println("Using binary approach:");
        findMissingBinary(sortedArr, size);

    }

    static void findMissingLinear(int[] arr, int size) {
        boolean missing = false;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i + 1] != arr[i] + 1) {
                missing = true;
                System.out.println((arr[i] + 1) + " is missing in the array");
            }
        }
        if (!missing) System.out.println("No element is missing in the array");
    }

    static void findMissingBinary(int[] arr, int size) {
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (arr[mid] == mid + 1) l = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] == mid) {
                    System.out.println((mid + 1) + " is missing in the array");
                    return;
                } else {
                    r = mid - 1;
                }
            }
        }
        System.out.println("No element is missing in the array");
    }

}
