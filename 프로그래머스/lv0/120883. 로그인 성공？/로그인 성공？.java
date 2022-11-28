import java.util.Arrays;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
         Object[] arr = Arrays.stream(db).filter(el -> el[0].equals(id_pw[0])).flatMap(Arrays::stream).toArray();

        if(arr.length == 0) return "fail";
        else if(arr[1].equals(id_pw[1])) return "login";
        else return "wrong pw";
    }
}