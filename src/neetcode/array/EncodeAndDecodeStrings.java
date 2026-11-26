package neetcode.array;

import java.util.ArrayList;
import java.util.List;

class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()){

            int j = i;
            while (j < str.length() && str.charAt(j) != '#'){
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
