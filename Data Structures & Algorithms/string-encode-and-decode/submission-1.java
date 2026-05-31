class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new LinkedList<>();
        int i = 0;
        
        while (i < str.length()){

            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            int startOfWord = j + 1;
            int endOfWord = startOfWord + length;

            String word = str.substring(startOfWord, endOfWord);
            result.add(word);

            i = endOfWord;
        }

        return result;
    }
}
