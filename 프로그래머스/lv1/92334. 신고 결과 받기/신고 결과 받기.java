import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        int[] cnt = new int[id_list.length];
        for(String rep : report){
            String id = rep.split(" ")[0];
            String repo = rep.split(" ")[1];

            if(reportMap.containsKey(id)){
                if(!reportMap.get(id).contains(repo)){
                    ArrayList<String> cloneAl = reportMap.get(id);
                    cloneAl.add(repo);
                    reportMap.put(id, cloneAl);
                }
            } else{
                ArrayList<String> aL = new ArrayList<>();
                aL.add(repo);
                reportMap.put(id, aL);
            }
        }

        for(String reportId : reportMap.keySet()){
            ArrayList<String> aL =reportMap.get(reportId);
            for(String s : aL){
                int where = Arrays.asList(id_list).indexOf(s);
                cnt[where]++;
            }
        }

        for(int i=0; i<cnt.length; i++){
            if(cnt[i] >= k){
                for(String s : reportMap.keySet()){
                    if(reportMap.get(s).contains(id_list[i])){
                        int where = Arrays.asList(id_list).indexOf(s);
                        answer[where]++;
                    }
                }
            }
        }

        return answer;
    }
}