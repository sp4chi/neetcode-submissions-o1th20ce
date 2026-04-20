class Solution {
    public boolean isValid(int mid, int h, int[] piles){
        int temp = 0;
        for(int i : piles){
            temp += i/mid; // floor
            if(i % mid != 0) temp++; // 1 + floor = ceil
        }

        if(temp <= h){
            return true;
        }

        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        int high = 0;
        for(int i=0;i<N;i++){
            if(piles[i]>high){
                high = piles[i];
            }
        }

        int low = 1;

        int k = high;

        while(low <= high){
            int mid = (high - low)/2 + low;

            if(isValid(mid,h,piles)){
                k = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return k;
    }
}
