class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {

        // Add the current subset to the result
        res.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {

            // Choose the current element
            path.add(nums[i]);

            // Explore further subsets
            helper(nums, i + 1, path, res);

            // Backtrack by removing the last chosen element
            path.remove(path.size() - 1);
        }
    }
}

/*
    Time Complexity: O(2^n)
    Space Complexity: O(n) (excluding output)
*/