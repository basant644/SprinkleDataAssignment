/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TweetsSprinkleData.Twitter;

import java.util.List;

/**
 *
 * @author Adminn
 */
public interface ITrendingTopic {
  /*
  For each tweet, its topic will be captured by this interface
   */
  void topicTweeted(String topicName);
  /*
  Returns N most frequently tweeted topics in last T mins. The value of T can be between 1 and 30.
   */
  List<String> getTopTrendingTopics(int N, int T);
}


