class Solution {

    public String encode(List<String> strs) {
        StringBuilder newStr = new StringBuilder();
        for (String str : strs) {
            newStr.append(str.length()).append("@").append(str);
        }
        return newStr.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (j < str.length() && str.charAt(j) != '@') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int startOfWord = j + 1;
            int endOfWord = startOfWord + length;

            String res = str.substring(startOfWord, endOfWord);
            result.add(res);
            i = endOfWord;
        }
        return result;
    }
}
