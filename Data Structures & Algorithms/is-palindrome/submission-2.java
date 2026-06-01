class Solution {
    public boolean isPalindrome(String s) {
        String clear = s.replaceAll("[^a-zA-Z0-9]", "");
        String lowerResult = clear.toLowerCase();

        char[] result = lowerResult.toCharArray();
        int i = 0;
        int j = result.length - 1;
        while (i < j){
            if (result[i] != result[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}