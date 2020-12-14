package com.company;

import java.util.*;

public class Tweet {

    private final List<String> hashtags = new ArrayList<String>();

    private final Map<String, Integer> tagsCount = new HashMap<>();
    private String text;
    private int noOfTweets;

    public Map<String, Integer> getTagsCount() {
        return tagsCount;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    private Tweet(int noOfTweets) {
        this.noOfTweets = noOfTweets;
    }

    public static Tweet getTweet(String tweetText, int noOfTweets) {
        Tweet tweet = new Tweet(noOfTweets);
        tweet.text = tweetText;
        tweet.parse();
        return tweet;
    }

    private void parse() {
        StringTokenizer tokenizer = new StringTokenizer(this.text);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.startsWith("#")) {
                hashtags.add(token);
                String removeHash = token.replace("#", "");
                tagsCount.put(removeHash, tagsCount.getOrDefault(removeHash, 0) + 1);
            }
        }
    }

    public Set<String> getUniqueHashtags() {
        Set<String> unique = new HashSet<String>();
        unique.addAll(hashtags);
        return unique;
    }

//    public Map<String,Integer> getSortedHashMap() {
//        return (Map<String, Integer>) entriesSortedByValues(getTagsCount());
//    }

    <K, V extends Comparable<? super V>>
    List<String> entriesSortedByValues(Map<K, V> map) {

        List<Map.Entry<K, V>> sortedEntries = new ArrayList<Map.Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );
        List<String> popularTagLists = new ArrayList<>();
        if (sortedEntries.size() < this.noOfTweets) {
            this.noOfTweets = sortedEntries.size();
        }
        for (int i = 0; i < this.noOfTweets; i++) {
            popularTagLists.add((String) sortedEntries.get(i).getKey());
        }
        return popularTagLists;
    }


}
