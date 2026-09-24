class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Store the order in which courses can be completed
        int[] ans = new int[numCourses];

        // Create adjacency list for the course graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Store the number of prerequisites for each course
        int[] indegree = new int[numCourses];

        // Build the graph and calculate indegrees
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            // prerequisite -> course
            adj.get(prerequisite).add(course);

            // Increase indegree of the course
            indegree[course]++;
        }

        // Add courses with no prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        int completed = 0;

        // Process courses using Kahn's Algorithm (BFS)
        while (!queue.isEmpty()) {
            int course = queue.poll();

            // Add the course to the result
            ans[i++] = course;
            completed++;

            // Update the prerequisites of dependent courses
            for (int next : adj.get(course)) {
                indegree[next]--;

                // If all prerequisites are completed, add the course
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If not all courses can be completed, a cycle exists
        if (completed != numCourses) {
            return new int[]{};
        }

        return ans;
    }
}