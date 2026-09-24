class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        int complete = 0;

        // Process courses using Kahn's Algorithm (BFS)
        while (!queue.isEmpty()) {
            int course = queue.poll();
            complete++;

            // Remove the current course as a prerequisite
            for (int next : adj.get(course)) {
                indegree[next]--;

                // If all prerequisites are completed, add the course
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses are completed, there is no cycle
        return complete == numCourses;
    }
}