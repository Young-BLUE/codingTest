import java.util.*;

public class Coding_150370 {

        public List<Integer> solution() {
            //https://school.programmers.co.kr/learn/courses/30/lessons/150370

            String today = "2022.05.19";
            String[] terms = {"A 6", "B 12", "C 3"};
            String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
            ArrayList<Integer> answer = new ArrayList<Integer>();

            // 여기에서는 1년이 365일이 아니라 12 * 28 인 것을 망각하면 안된다.
            String[] todays = today.split("\\.");
            int todayInt = (Integer.valueOf(todays[0]) * 12 * 28) + (Integer.valueOf(todays[1]) * 28) + Integer.valueOf(todays[2]);

            Map<String, Integer> termsMap = termsMapping(terms);

            int index = 1;
            for (String privacy : privacies) {
                String date = privacy.split(" ")[0];
                String term = privacy.split(" ")[1];
                boolean result = calculator(todayInt, term, date, termsMap);
                if(result) {
                    answer.add(index);
                }
                index++;
            }

            return answer;
        }

        public boolean calculator(int todayInt, String term, String date, Map<String, Integer> termsMap) {
            String[] dates = date.split("\\.");
            int dateInt = (Integer.valueOf(dates[0]) * 12 * 28) + (Integer.valueOf(dates[1]) * 28) + Integer.valueOf(dates[2]);

            int termDays = termsMap.get(term) * 28;
            if (todayInt >= (dateInt + termDays)) {
                return true;
            } else {
                return false;
            }
        }

        public Map<String, Integer> termsMapping(String[] terms) {
            Map<String, Integer> map = new HashMap<String, Integer>();

            for(String term : terms) {
                String[] termSplit = term.split(" ");
                map.put(termSplit[0], Integer.valueOf(termSplit[1]));
            }

            return map;
        }
}
