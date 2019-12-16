/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TweetsSprinkleData.Twitter;

import DB.ITweetDataBase;
import java.util.List;

/**
 *
 * @author Adminn
 */
public class TweetsStorageHost implements ITrendingTopic{

    ITweetDataBase TweetDB;

    public TweetsStorageHost(ITweetDataBase dB) {
        this.TweetDB = dB;
    }
    
    @Override
    public void topicTweeted(String topicName) {
        this.TweetDB.addTweet(topicName);
    }

    @Override
    public List<String> getTopTrendingTopics(int N, int T) {
        return this.TweetDB.getTrendingTweet(N, T);
    }
    
}
