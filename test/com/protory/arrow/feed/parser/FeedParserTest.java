package com.protory.arrow.feed.parser;

import static junit.framework.Assert.assertNull;
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
        FeedParser feedParser = FeedParserFactory.newFeedParserFactory().newFeedParser();

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
        FeedParser feedParser = FeedParserFactory.newFeedParserFactory().newFeedParser();
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
        FeedParser feedParser = FeedParserFactory.newFeedParserFactory().newFeedParser();
        final Image image1 = new Image();

        feedParser.parse(new DefaultFeedParserListener() {
            @Override
            public void onImage(String url, String title, String link) {
                image1.url = url;
                image1.title = title;
                image1.link = link;
            }
        }, WITH_IMAGE_RSS_URL);

        assertNotNull(image1.url);
        assertNotNull(image1.title);
        assertNotNull(image1.link);

        final Image image2 = new Image();
        feedParser.parse(new DefaultFeedParserListener() {
            @Override
            public void onImage(String url, String title, String link) {
                image2.url = url;
                image2.title = title;
                image2.link = link;
            }
        }, WITHOUT_IMAGE_RSS_URL);

        assertNull(image2.url);
        assertNull(image2.title);
        assertNull(image2.link);
    }

    @Test
    public void parseFeedItems() throws Exception {
        FeedParser feedParser = FeedParserFactory.newFeedParserFactory().newFeedParser();
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