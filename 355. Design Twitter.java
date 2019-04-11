import javafx.util.Pair;

class Twitter {

    Map<Integer, Set<Integer>> followMap;
    List<Pair<Integer, Integer>> tweetNews;
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetNews = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetNews.add(new Pair(userId, tweetId));
        Set<Integer> set = followMap.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        followMap.put(userId, set);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        int index = tweetNews.size() - 1;
        Set<Integer> set = followMap.getOrDefault(userId, new HashSet<>());
        while (list.size() < 10 && index >= 0){
            Pair<Integer, Integer> news = tweetNews.get(index);
            if (set.contains(news.getKey())) list.add(news.getValue());
            index--;
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followMap.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        set.remove(followeeId);
        followMap.put(followerId, set);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


 // Runtime: 106 ms, faster than 23.50% of Java online submissions for Design Twitter.
 // Memory Usage: 55.6 MB, less than 5.19% of Java online submissions for Design Twitter.
