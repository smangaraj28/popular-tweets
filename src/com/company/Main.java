package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner hashtag = new Scanner(System.in);
        System.out.println("Please enter a line of text");
        String tweetText = hashtag.nextLine();
        Tweet tweet = Tweet.getTweet(tweetText, 10);
        Map<String, Integer> tagsCount = tweet.getTagsCount();
        List<String> popularTags = tweet.entriesSortedByValues(tagsCount);
        System.out.println("Most popular Tweets: ");
        System.out.println(popularTags);
//        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
//        minHeap.offer(new int[]{10 - 1, 0});
//        System.out.println(tweet.getHashtags());
    }
}
