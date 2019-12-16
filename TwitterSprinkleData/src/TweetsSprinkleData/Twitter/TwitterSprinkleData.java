/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TweetsSprinkleData.Twitter;

import DB.LocalTweetDataBase;
import java.util.Scanner;

/**
 *
 * @author Adminn
 */
public class TwitterSprinkleData {

    public ITrendingTopic createAndGetTweetHostWithLocalStorage()
    {
        return new TweetsStorageHost(new LocalTweetDataBase());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwitterSprinkleData tSD = new TwitterSprinkleData();
        ITrendingTopic tweetsHost = tSD.createAndGetTweetHostWithLocalStorage();
        Scanner sc = new Scanner(System.in);
        int i = 1;
        try
        {
        while(true)
        {
            System.out.println("Choose the option \n 1. Tweet \n 2. Get trending");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    String str = sc.next();
                    tweetsHost.topicTweeted(str);
                    break;
                case 2:
                    System.out.println(" Enter time and length");
                    int t = sc.nextInt();
                    int n = sc.nextInt();
                    System.out.println(tweetsHost.getTopTrendingTopics(n, t));
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
        }
        catch(Exception e)
        {
            System.out.println("System enters into invalid state, aborting...");
        }
    }
    
}

/*
Sample input
1 t 1 t 1 t 1 t2 1 t4 1 t5 1 t6 1 t6 1 t 1 t5 1 t6 1 t3 1 t4 1 t6 1 t6 1 t6 1 t2 1 t4 1 t5 1 t6 1 t6 1 t6 1 t5 1 t6 1 t3 1 t4 

*/