# SprinkleDataAssignment
Top Trending Tweets

/*
Implemented the below interface to compute trending topics in Twitter. Write the unit testcases.
The evaluation will be done based on clean design, test cases and performant code.
Create a project in github and share the project.
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
