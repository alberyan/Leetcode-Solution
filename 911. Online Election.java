class TopVotedCandidate {
    int[] winner;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        winner = new int[times.length];
        this.times = times;
        int[] count = new int[persons.length];
        int currentWinner = persons[0];
        int currentMax = 1;
        count[currentWinner] = 1;
        winner[0] = currentWinner;
        for (int i = 1; i < persons.length; i++){
            int person = persons[i];
            count[person]++;
            if (count[person] >= currentMax){
                currentWinner = person;
                currentMax = count[person];
            }
            winner[i] = currentWinner;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        if (t >= times[right]){
            return winner[right];
        }
        int mid = 0;
        while (left < right - 1){
            mid = left + (right - left) / 2;
            if (times[mid] == t){
                return winner[mid];
            } else if (times[mid] > t){
                right = mid;
            } else {
                left = mid;
            }
        }
        return winner[left];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

//  Runtime: 141 ms, faster than 96.25% of Java online submissions for Online Election.
// Memory Usage: 71.4 MB, less than 83.33% of Java online submissions for Online Election.
