public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set <String> checkSeq = new HashSet<String>();
        Set <String> repeatedSeq = new HashSet<String>();
        for (int i = 0; i < s.length() - 9 ; i++) {
            String currSeq = s.substring(i, i + 10);
            if (!checkSeq.add(currSeq)) {
                repeatedSeq.add(currSeq);
            }
        }
        return new ArrayList(repeatedSeq);
    }
}