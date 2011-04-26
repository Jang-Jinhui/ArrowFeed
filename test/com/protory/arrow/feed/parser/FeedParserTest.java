package com.protory.arrow.feed.parser;

import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

public class FeedParserTest {
    private static String STRING_URL = "http://cafe.daum.net/xml/rss/breakiphone";

    @Test
    public void newFeedParser() {
        FeedParser feedParser = FeedParserFactory.newFeedParser();

        assertNotNull(feedParser);
    }

    @Test
    public void newFeedParserListener() {
        FeedParserListener listener = new FeedParserListener() {
            @Override
            public void onChannel(String title, String link, String description) {
            }
        };

        assertNotNull(listener);
    }

    @Test
    public void parseFeedChannel() throws Exception {
        FeedParser feedParser = FeedParserFactory.newFeedParser();
        final Channel channel = new Channel();

        feedParser.parse(new FeedParserListener() {
            @Override
            public void onChannel(String title, String link, String description) {
                channel.title = title;
            }
        }, STRING_URL);

        assertNotNull(channel.title);
    }

    class Channel {
        String title;
    }
}