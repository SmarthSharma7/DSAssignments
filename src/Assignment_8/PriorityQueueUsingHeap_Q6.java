package Assignment_8;

public class PriorityQueueUsingHeap_Q6 {

    static class MaxHeap {
        int size;
        int capacity;
        int[] heap;

        MaxHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            if (size == capacity) {
                System.out.println("Heap is full!");
                return;
            }

            heap[size] = value;
            int i = size;
            size++;

            while (i != 0 && heap[parent(i)] < heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Heap is empty!");
                return -1;
            }
            return heap[0];
        }

        int extractMax() {
            if (size == 0) {
                System.out.println("Heap is empty!");
                return -1;
            }

            int root = heap[0];

            heap[0] = heap[size - 1];
            size--;

            heapify(0); // fix downward

            return root;
        }

        void heapify(int i) {
            int largest = i;
            int left = left(i);
            int right = right(i);

            if (left < size && heap[left] > heap[largest])
                largest = left;

            if (right < size && heap[right] > heap[largest])
                largest = right;

            if (largest != i) {
                swap(i, largest);
                heapify(largest);
            }
        }

        int parent(int i) { return (i - 1) / 2; }
        int left(int i) { return 2 * i + 1; }
        int right(int i) { return 2 * i + 2; }

        void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void printHeap() {
            for (int i = 0; i < size; i++)
                System.out.print(heap[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxHeap pq = new MaxHeap(20);

        pq.insert(40);
        pq.insert(10);
        pq.insert(50);
        pq.insert(30);
        pq.insert(60);

        System.out.println("Priority Queue (Max-Heap): ");
        pq.printHeap();

        System.out.println("Max element (peek): " + pq.peek());

        System.out.println("\nExtracting elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.print(pq.extractMax() + " ");
        }
    }
}
