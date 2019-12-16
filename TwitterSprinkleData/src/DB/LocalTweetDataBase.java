/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Utility.OrderedTweetsWithTimeStamp;
import java.util.List;

/**
 *
 * @author Adminn
 */
public class LocalTweetDataBase implements ITweetDataBase {
    OrderedTweetsWithTimeStamp tweetsData;

    public LocalTweetDataBase() {
        this.tweetsData = new OrderedTweetsWithTimeStamp(30);
    }

    @Override
    public void addTweet(String tweet) {
        this.tweetsData.add(tweet);
    }

    @Override
    public List<String> getTrendingTweet(int n, int time) {
        return this.tweetsData.getTopTrendingTopic(n, time);
    }
}
