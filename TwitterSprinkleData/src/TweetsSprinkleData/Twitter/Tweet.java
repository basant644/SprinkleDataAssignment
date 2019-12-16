/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TweetsSprinkleData.Twitter;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author Adminn
 */
public final class Tweet {
    final public String tweet;
    final public Timestamp tweetTime;
    
    public Tweet(String tweet)
    {
        this.tweet = tweet;
        Date d = new Date();
        tweetTime = new Timestamp(d.getTime());
    }
    
    public boolean isWithinTimeBound(int bounds)
    {
        Date d = new Date();
        Timestamp currentTime = new Timestamp(d.getTime()); 
        long tweetAge = currentTime.getTime() - this.tweetTime.getTime();
        int boundInMS = bounds*1000;
        
        return tweetAge <= boundInMS;
    }
    
    @Override
    public int hashCode() 
    {
        return this.tweet.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tweet other = (Tweet) obj;
        if (!Objects.equals(this.tweet, other.tweet)) {
            return false;
        }
        return true;
    }
}
