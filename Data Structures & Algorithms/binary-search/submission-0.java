class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;

        int L = 0;
        int R = N - 1;

        int mid = -1;

        while(L <= R){
            mid = L + ( R - L)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return -1;
    }
}
