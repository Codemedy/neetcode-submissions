package neetcode.array;

public class ProductOfArrayExceptSelf {

    //O(3N) O(N) solution
    public int[] productExceptSelf1(int[] nums) {

        if (nums == null || nums.length <= 1){
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        postfix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            postfix[i] = postfix[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++){
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }

    // O(2N) O(1) solution, postfix & prefix arrays aren't necessary
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int postfix = 1;
        for (int i = n-1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
