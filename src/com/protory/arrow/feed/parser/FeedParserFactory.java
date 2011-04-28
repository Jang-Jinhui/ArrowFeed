package com.protory.arrow.feed.parser;

public class FeedParserFactory {
    private static FeedParserFactory factory = new FeedParserFactory();
    private FeedParser parser;

    private FeedParserFactory() {
    }

    public static FeedParserFactory newFeedParserFactory() {
        return factory;
    }

    public FeedParser newFeedParser() {
        if (parser == null) {
            parser = new FeedParser();
        }
        return parser;
    }
}
