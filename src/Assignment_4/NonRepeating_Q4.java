package Assignment_4;

public class NonRepeating_Q4 {
    public static void main(String[] args) {
        int[] arr = {'a', 'a', 'b', 'c'};
        int[] res = firstNonRepeating(arr, arr.length);
        for (int i : res) System.out.print(i == -1 ? i + ", " : (char)i + ", ");
    }

    static int[] firstNonRepeating(int[] arr, int n) {
        int[] freq = new int[256]; // I took size as 256 for all possible ASCII characters
        Queuee q = new Queuee();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int ch = arr[i];
            freq[ch]++;
            q.enqueue(ch);
            while (!q.isEmpty() && freq[q.peek()] > 1) {
                q.dequeue();
            }
            res[i] = q.isEmpty() ? -1 : q.peek();
        }

        return res;
    }
}
