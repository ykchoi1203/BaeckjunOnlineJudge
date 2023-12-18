import java.util.HashMap;
class Solution {
    public int solution(String s) {
		// StringBuffer answer = new StringBuffer();
		// StringBuffer word = new StringBuffer();
        String[] numbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<numbers.length; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));  
        }
        
// 		HashMap<String, String> numberMap = new HashMap<>();
// 		numberMap.put("zero","0");
// 		numberMap.put("one","1");
// 		numberMap.put("two","2");
// 		numberMap.put("three","3");
// 		numberMap.put("four","4");
// 		numberMap.put("five","5");
// 		numberMap.put("six","6");
// 		numberMap.put("seven","7");
// 		numberMap.put("eight","8");
// 		numberMap.put("nine","9");

// 		for(int i = 0; i < s.length(); i++) {
// 			if(s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' ||
// 					s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9' || s.charAt(i) == '0') {
// 				if(word.length() != 0 && numberMap.containsKey(word.toString())) {
// 					answer.append(numberMap.get(word.toString()));
// 					word.delete(0, word.length());
// 				}
// 				answer.append(s.charAt(i));
// 			} else {
// 				if(word.length() != 0 && numberMap.containsKey(word.toString())) {
// 					answer.append(numberMap.get(word.toString()));
// 					word.delete(0, word.length());
// 				} 
                
// 				word.append(s.charAt(i));
// 			}
// 		}
        
//         if(word.length() != 0) {
//             answer.append(numberMap.get(word.toString()));
//         }
       
        return  Integer.parseInt(s);
    }
}