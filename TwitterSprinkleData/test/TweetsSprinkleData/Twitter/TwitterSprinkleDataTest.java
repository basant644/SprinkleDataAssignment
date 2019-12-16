/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TweetsSprinkleData.Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adminn
 */
public class TwitterSprinkleDataTest {
    
    public TwitterSprinkleDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createAndGetTweetHostWithLocalStorage method, of class TwitterSprinkleData.
     */
    @Test
    public void testCreateAndGetTweetHostWithLocalStorage() {
        System.out.println("createAndGetTweetHostWithLocalStorage");
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic result = instance.createAndGetTweetHostWithLocalStorage();
        assertNotNull( result);
    }

    /**
     * Test of main method, of class TwitterSprinkleData.
     */
    @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopic_ReturnsEmptyList() {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        List<String> result = host.getTopTrendingTopics(10, 30);
        assertEquals(result.size(),0);
    }
    
    /**
     * Test of main method, of class TwitterSprinkleData.
     */
    @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopicOfNLength_ReturnsSameLengthOfResult() {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        host.topicTweeted("sample1");
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample6");
        host.topicTweeted("sample7");
        
        int n = 5;
        List<String> result = host.getTopTrendingTopics(n, 30);
        assertEquals(result.size(),n);
    }
    
    @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopic_ReturnsNullIfAllTweetsExpired() throws InterruptedException {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        host.topicTweeted("sample1");
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample6");
        host.topicTweeted("sample7");
        
        TimeUnit.SECONDS.sleep(5);
        
        int n = 5;
        List<String> result = host.getTopTrendingTopics(n, 4);
        assertEquals(result.size(), 0);
    }
    
    @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopic_ReturnsNullIfAllTimeIsZero() throws InterruptedException {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        host.topicTweeted("sample1");
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample6");
        host.topicTweeted("sample7");
        
        TimeUnit.SECONDS.sleep((long) 0.001);
        
        int n = 5;
        List<String> result = host.getTopTrendingTopics(n, 0);
        assertEquals(result.size(), 0);
    }
    
     @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopic_ReturnsTheTopicsInSortedOrederOfTrending() throws InterruptedException {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        host.topicTweeted("sample1");
        host.topicTweeted("sample1");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample1");
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample2");
        
        int n = 3;
        List<String> result = host.getTopTrendingTopics(n, 30);
        List<String> expected = new ArrayList<String>(Arrays.asList("sample2", "sample5", "sample1"));
        assertEquals(result, expected);
    }
    
     @Test
    public void testTwitterSprinkleDataHost_GetTrendingTopic_ReturnsCorrectSetOfTrending() throws InterruptedException {
        TwitterSprinkleData instance = new TwitterSprinkleData();
        ITrendingTopic host = instance.createAndGetTweetHostWithLocalStorage();
        host.topicTweeted("sample1");
        host.topicTweeted("sample1");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample1");
        
        TimeUnit.SECONDS.sleep(2);
        
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample2");
        
        TimeUnit.SECONDS.sleep(5);
        
        host.topicTweeted("sample2");
        host.topicTweeted("sample3");
        host.topicTweeted("sample1");
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample2");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample5");
        host.topicTweeted("sample2");
        
        TimeUnit.SECONDS.sleep(2);
       
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        host.topicTweeted("sample5");
        
        TimeUnit.SECONDS.sleep(5);
        
        host.topicTweeted("sample1");
        host.topicTweeted("sample1");
        host.topicTweeted("sample4");
        host.topicTweeted("sample4");
        
        int n = 3;
        List<String> result = host.getTopTrendingTopics(n, 8);
        List<String> expected = new ArrayList<String>(Arrays.asList("sample4", "sample2", "sample5"));
        assertEquals(result, expected);
    }
    
}
