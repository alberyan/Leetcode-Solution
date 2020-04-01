import java.util.PriorityQueue;

class Solution {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] voteCounts = new int[26][len];
        for (String vote: votes) {
            for (int i = 0; i < len; i++) {
                char ch = vote.charAt(i);
                voteCounts[ch - 'A'][i]++;
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Character ch1, Character ch2) {
                int[] voteCount1 = voteCounts[ch1 - 'A'];
                int[] voteCount2 = voteCounts[ch2 - 'A'];
                for (int i = 0; i < len; i++) {
                    if (voteCount1[i] > voteCount2[i]) return -1;
                    if (voteCount2[i] > voteCount1[i]) return 1;
                }
                return ch1 - ch2;
            }
        });
        for (char ch: votes[0].toCharArray()) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}

// Runtime: 4 ms, faster than 95.40% of Java online submissions for Rank Teams by Votes.
// Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Rank Teams by Votes.