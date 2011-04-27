package com.protory.arrow.feed.parser;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class FeedParserTest {
    private static String WITHOUT_IMAGE_RSS_URL = "http://cafe.daum.net/xml/rss/breakiphone";
    private static String WITH_IMAGE_RSS_URL = "http://hepi2.blog.me/rss";

    @Test
    public void newFeedParser() {
        FeedParser feedParser = FeedParserFactory.newFeedParser();

        assertNotNull(feedParser);
    }

    @Test
    public void newFeedParserListener() {
        FeedParserListener listener = new DefaultFeedParserListener() {
        };

        assertNotNull(listener);
    }

    @Test
    public void parseFeedChannel() throws Exception {
        FeedParser feedParser = FeedParserFactory.newFeedParser();
        final Channel channel = new Channel();

        feedParser.parse(new DefaultFeedParserListener() {
            @Override
            public void onChannel(String title, String link, String description, Date pubDate) {
                channel.title = title;
                channel.link = link;
                channel.description = description;
                channel.pubDate = pubDate;
            }
        }, WITHOUT_IMAGE_RSS_URL);

        assertNotNull(channel.title);
        assertNotNull(channel.link);
        assertNotNull(channel.description);
        assertNotNull(channel.pubDate);
    }

    @Test
    public void parseFeedImage() throws Exception {
        FeedParser feedParser = FeedParserFactory.newFeedParser();
        final Image image = new Image();

        feedParser.parse(new DefaultFeedParserListener() {
            @Override
            public void onImage(String url, String title, String link) {
                image.url = url;
                image.title = title;
                image.link = link;
            }
        }, WITH_IMAGE_RSS_URL);

        assertNotNull(image.url);
        assertNotNull(image.title);
        assertNotNull(image.link);
    }

    @Test
    public void parseFeedItems() throws Exception {
        FeedParser feedParser = FeedParserFactory.newFeedParser();
        final List<Item> items = new ArrayList<Item>();

        feedParser.parse(new DefaultFeedParserListener() {
            @Override
            public void onItem(String author, String title, String description, String link, String guid, Date pubDate) {
                Item item = new Item();
                item.author = author;

                items.add(item);
            }
        }, WITH_IMAGE_RSS_URL);

        assertFalse("size is zero.", items.size() == 0);
    }

    class Channel {
        String title;
        String link;
        String description;
        Date pubDate;
    }

    class Image {
        String url;
        String title;
        String link;
    }

    class Item {
        String author;
        String title;
        String description;
        String link;
        String guid;
        Date pubDate;
    }
}