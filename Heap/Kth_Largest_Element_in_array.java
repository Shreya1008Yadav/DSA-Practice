class KthLargest {

    // Min-heap to store the K largest elements seen so far
    PriorityQueue<Integer> pq;

    // Number of largest elements we want to keep
    int k;

    // Constructor
    public KthLargest(int k, int[] nums) {

        // Store the value of k
        this.k = k;

        // Create a min-heap
        // The smallest element will always be at the top
        pq = new PriorityQueue<>();

        // Add all elements from the initial array
        // add() will make sure that only the K largest
        // elements remain in the heap
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    // Adds a new value to the stream
    // and returns the K-th largest element
    public int add(int val) {

        // Add the new value to the min-heap
        pq.offer(val);

        // If we have more than K elements,
        // remove the smallest element.
        //
        // Why?
        // We only need to keep the K largest elements.
        if (pq.size() > k) {
            pq.poll();
        }

        // The smallest element among the K largest
        // elements is the K-th largest element overall.
        return pq.peek();
    }
}


