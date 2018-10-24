class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0, leftP = 0, rightP = height.length -1, currentArea = 0;
        while(leftP < rightP){
            currentArea = (rightP - leftP)*(height[rightP] <= height[leftP] ? height[rightP]:height[leftP]);
            if(currentArea > maxArea){
                maxArea = currentArea;
            }
            if(height[rightP] < height[leftP]){
                --rightP;
            } else {
                ++leftP;
            }
        }
        return maxArea;
    }
}
