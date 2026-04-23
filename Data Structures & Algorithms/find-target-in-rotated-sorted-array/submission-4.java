class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;

        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (high - low) / 2 + low;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[0]) { // target is in part 1

                if (nums[mid] < nums[0]) { // mid is in part 2
                    high = mid - 1;
                } else { // mid is in part 1
                    if (nums[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else { // target is in part 2
                if (nums[mid] > nums[0]) { // mid is in part 1
                    low = mid + 1;
                } else {
                    if (nums[mid] < target) { // mid is in part 2
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
