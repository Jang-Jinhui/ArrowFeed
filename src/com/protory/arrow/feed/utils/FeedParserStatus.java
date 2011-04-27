package com.protory.arrow.feed.utils;

import java.util.Date;

import com.protory.arrow.feed.domain.Feed;
import com.protory.arrow.feed.parser.FeedParser;
import com.protory.arrow.feed.parser.FeedParserFactory;
import com.protory.arrow.feed.parser.FeedParserListener;

public class FeedParserStatus {
    private FeedParser feedParser;
    private String resource;
    private Feed feed;

    public FeedParserStatus(String resource) {
        this.resource = resource;
        feedParser = FeedParserFactory.newFeedParser();
    }

    public void parse() throws Exception {
        feedParser.parse(new FeedParserListener() {
            @Override
            public void onItem(String author, String title, String description, String link, String guid, Date pubDate) {
            }

            @Override
            public void onImage(String url, String title, String link) {
            }

            @Override
            public void onChannel(String title, String link, String description, Date pubDate) {
                feed = new Feed();
                feed.setTitle(title);
                feed.setLink(link);
                feed.setDescription(description);
                feed.setPubDate(pubDate);
            }
        }, resource);
    }

    public Feed getFeed() {
        return feed;
    }
}
