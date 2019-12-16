/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import TweetsSprinkleData.Twitter.Tweet;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Adminn
 */



public class OrderedTweetsWithTimeStamp {
    
    Deque<Tweet> tweets; 
    // maxTime in seconds
    int maxTime;

    public OrderedTweetsWithTimeStamp(int maxTime) {
        this.tweets = new ArrayDeque<>();
        this.maxTime = maxTime;
    }

    public OrderedTweetsWithTimeStamp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void removeOutDatedTweets()
    {
        while(!tweets.isEmpty()&& !tweets.peek().isWithinTimeBound(maxTime))
        {
            tweets.remove();
        }
    }
    
    public boolean add(String tweet)
    {
        Tweet t = new Tweet(tweet);
        return this.tweets.add(t);
    }
    
    public List<String> getTopTrendingTopic(int N, int T)
    {
        T = Math.min(maxTime, T);
        List<String> trending = new ArrayList<>();
        Iterator<Tweet> itr = tweets.descendingIterator();
        
        Map<Tweet, Integer> mp  = new HashMap<>();
        
        while(itr.hasNext())
        {
            Tweet t = itr.next();
            if(!t.isWithinTimeBound(T))
            {
                break;
            }
            boolean k = mp.containsKey(t);
            if(k)
            {
                mp.put(t, mp.get(t)+1);
            }
            else
            {
                mp.put(t, 1);
            }
        }
        
        Set<Entry<Tweet, Integer>> setOfEntries = mp.entrySet();
        
        Iterator<Entry<Tweet, Integer>> setItr = setOfEntries.iterator();
        List<TweetsCountWrapper> result = new ArrayList<>();
        
        setOfEntries.stream().forEach((entry) -> {
            result.add(new TweetsCountWrapper(entry.getKey(), entry.getValue()));
        });
        
        Collections.sort(result, new SortTweets());
        int i = 0;
        for(TweetsCountWrapper entry: result)
        {
            if(i<N)
            {
                i++;
                trending.add(entry.t.tweet);
            }
            else
                break;
        }
        return trending;
    }
}

class TweetsCountWrapper
{
    final Tweet t;
    int count;

    TweetsCountWrapper(Tweet t, int count) {
        this.t  = t;
        this.count = count;
    }
}

class SortTweets implements Comparator<TweetsCountWrapper>
{

    @Override
    public int compare(TweetsCountWrapper t, TweetsCountWrapper t1) {
        if(t.count>t1.count)
            return -1;
        return 0;
    }

}