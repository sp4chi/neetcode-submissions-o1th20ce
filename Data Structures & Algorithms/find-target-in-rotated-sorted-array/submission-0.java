class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;

        int low = 0;
        int high = N - 1;
        

        while( low <= high){
            int mid = (high - low)/2 + low;

            if(nums[mid] == target){
                return mid;
            }else if(target < nums[0] && target < nums[0]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
