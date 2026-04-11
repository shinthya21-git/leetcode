class Solution {
    public int minimumDistance(int[] nums) {
        int l = nums.length;
        if (l <= 2) {
            return -1;
        }
        if (l == 3) {
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return 4;
            } else {
                return -1;
            }
        }
        Map<Integer, Deque<Integer>> index = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            if (!index.containsKey(nums[i])) {
                index.put(nums[i], new ArrayDeque<>());
            }
            index.get(nums[i]).addLast(i);
            Deque<Integer> x = index.get(nums[i]);
            if (x.size() > 3) {
                index.get(nums[i]).removeFirst();
            }
            if(x.size()==3){
                int a = index.get(nums[i]).peekFirst();
                int c = index.get(nums[i]).peekLast();
                ans = Math.min(ans, 2 * (c - a));
            }
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}