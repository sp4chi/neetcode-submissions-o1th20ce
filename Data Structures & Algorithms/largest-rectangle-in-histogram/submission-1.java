class Solution {
    public int[] NSL(int[] height){
        int N = height.length;
        int[] out = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                out[i] = stack.peek();
            }else{
                out[i] = -1;
            }

            stack.push(i);
        }

        return out;
    }

    public int[] NSR(int[] height){
        int N = height.length;
        int[] out = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=N-1; i>=0; i--){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){         
                out[i] = stack.peek();
            }else{
                out[i] = N;
            }
            stack.push(i);
        }

        return out;
    }
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] L = NSL(heights);
        int[] R = NSR(heights);

        int area = 0;

        for(int i=0; i<N; i++){
            int height = heights[i];
            int width = R[i] - L[i] - 1;

            int temp = height * width;

            if(area < temp){
                area = temp;
            }
        }
        return area;
    }
}
