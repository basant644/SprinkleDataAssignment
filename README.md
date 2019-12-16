# SprinkleDataAssignment
Top Trending Tweets

/*
Implemented the below interface to compute trending topics in Twitter. 

public interface TrendingTopic {

  /*
  For each tweet, its topic will be captured by this interface
   */
   
  void topicTweeted(String topicName);
  
  /*
  Returns N most frequently tweeted topics in last T mins. The value of T can be between 1 and 30.
   */
   
  List<String> getTopTrendingTopics(int N, int T);
  
}
