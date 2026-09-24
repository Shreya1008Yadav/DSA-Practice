```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (p1, p2) ->
                (p2[0] * p2[0] + p2[1] * p2[1])
                - (p1[1] * p1[1] + p1[0] * p1[0])
        );

        // Add points to heap
        for (int[] pt : points) {
            pq.offer(pt);

            // Keep only k closest points
            if (pq.size() > k)
                pq.poll();
        }

        // Store result
        int[][] res = new int[k][2];

        // Get k closest points
        while (k > 0) {
            res[--k] = pq.poll();
        }

        return res;
    }
}
```
